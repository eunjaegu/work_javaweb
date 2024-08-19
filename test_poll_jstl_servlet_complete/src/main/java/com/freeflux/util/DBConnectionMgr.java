package com.freeflux.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;


/**
 * java.sql.Connection 풀을 관리.
 *
 * @author  Anil Hemrajani
 */
public class DBConnectionMgr {
    
    private ArrayList<ConnectionObject> connections = new ArrayList<ConnectionObject>();
    
    
 // 데이터베이스 접속 설정 정보
 	/** JDBC DRIVER 패키지 정보 */
 	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
 	
 	/** 데이터베이스 URL */
 	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test";
 	
 	/** 데이터베이스 아이디 */
 	private String DB_ID = "root";
 	
 	/** 데이터베이스 암호 */
 	private String DB_PWD = "1234";
    
    private boolean _traceOn = false;
    private boolean initialized = false;
    private int _openConnections = 50;
    private static DBConnectionMgr instance = null;

    public DBConnectionMgr() {
    }

    /** 사용하지 않는 연결이 닫히기 전에 열려 있는 최대 연결 수를 설정 **/
    public static DBConnectionMgr getInstance() {
        if (instance == null) {
            synchronized (DBConnectionMgr.class) {
                if (instance == null) {
                    instance = new DBConnectionMgr();
                }
            }
        }
        return instance;
    }

    /** 열려 있는 최대 연결 수를 설정 **/
    public void setOpenConnectionCount(int count) {
        _openConnections = count;
    }


    /** 사용 가능 여부를 설정 **/
    public void setEnableTrace(boolean enable) {
        _traceOn = enable;
    }


    /** java.sql.Connection 객체들을 반환 */
    public ArrayList<ConnectionObject> getConnectionList() {
        return connections;
    }


    /** 지정된 갯수만큼 연결을 열고 이를 기존 풀에 추가 */
    public synchronized void setInitOpenConnections(int count) throws SQLException {
        Connection c = null;
        ConnectionObject co = null;

        for (int i = 0; i < count; i++) {
            c = createConnection();
            co = new ConnectionObject(c, false);

            connections.add(co);
            trace("ConnectionPoolManager: Adding new DB connection to pool (" + connections.size() + ")");
        }
    }


    /** 열린 연결 수를 반환 */
    public int getConnectionCount() {
        return connections.size();
    }


    /** 사용되지 않은 기존 연결이나 새 연결을 반환.  */
    public synchronized Connection getConnection()
            throws Exception {
        if (!initialized) {
            Class c = Class.forName(JDBC_DRIVER);
            DriverManager.registerDriver((Driver) c.newInstance());

            initialized = true;
        }


        Connection c = null;
        ConnectionObject co = null;
        boolean badConnection = false;


        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);

            // 연결이 사용되지 않는 경우 테스트하여 여전히 유효한지 확인!
            if (!co.inUse) {
                try {
                    badConnection = co.connection.isClosed();
                    if (!badConnection)
                        badConnection = (co.connection.getWarnings() != null);
                } catch (Exception e) {
                    badConnection = true;
                    e.printStackTrace();
                }

                // 연결 상태가 좋지 않은 연결을 풀에서 제거
                if (badConnection) {
                    connections.remove(i);
                    trace("ConnectionPoolManager: 연결이 끊어진 DB 연결을 제거 #" + i);
                    continue;
                }

                c = co.connection;
                co.inUse = true;

                trace("ConnectionPoolManager: 기존 DB 연결을 사용 #" + (i + 1));
                break;
            }
        }

        if (c == null) {
            c = createConnection();
            co = new ConnectionObject(c, true);
            connections.add(co);

            trace("ConnectionPoolManager: 새로운 DB 연결을 생성 #" + connections.size());
        }

        return c;
    }


    /** 이 연결이 더 이상 사용되지 않음을 나타내기 위해 ConnectionObject에 플래그를 표시 */
    public synchronized void freeConnection(Connection c) {
        if (c == null)
            return;

        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);
            if (c == co.connection) {
                co.inUse = false;
                break;
            }
        }

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);
            if ((i + 1) > _openConnections && !co.inUse)
                removeConnection(co.connection);
        }
    }

    public void freeConnection(Connection c, PreparedStatement p, ResultSet r) {
        try {
            if (r != null) r.close();
            if (p != null) p.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, Statement s, ResultSet r) {
        try {
            if (r != null) r.close();
            if (s != null) s.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, PreparedStatement p) {
        try {
            if (p != null) p.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, Statement s) {
        try {
            if (s != null) s.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /** 이 연결이 더 이상 사용되지 않음을 나타내기 위해 ConnectionObject에 플래그를 표시 */
    public synchronized void removeConnection(Connection c) {
        if (c == null)
            return;

        ConnectionObject co = null;
        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);
            if (c == co.connection) {
                try {
                    c.close();
                    connections.remove(i);
                    trace("Removed " + c.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            }
        }
    }


    private Connection createConnection()
            throws SQLException {
        Connection con = null;

        try {
            if (DB_ID == null)
                DB_ID = "";
            if (DB_PWD == null)
                DB_PWD = "";

            Properties props = new Properties();
            props.put("user", DB_ID);
            props.put("password", DB_PWD);

            con = DriverManager.getConnection(DB_URL, props);
        } catch (Throwable t) {
            throw new SQLException(t.getMessage());
        }

        return con;
    }


    /** 모든 연결을 닫고 연결 풀을 제거 */
    public void releaseFreeConnections() {
        trace("ConnectionPoolManager.releaseFreeConnections()");

        Connection c = null;
        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);
            if (!co.inUse)
                removeConnection(co.connection);
        }
    }


    /** 모든 연결을 닫고 연결 풀을 지움 */
    public void finalize() {
        trace("ConnectionPoolManager.finalize()");

        Connection c = null;
        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);
            try {
                co.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            co = null;
        }

        connections.clear();
    }


    private void trace(String s) {
        if (_traceOn)
            System.err.println(s);
    }

}


class ConnectionObject {
    public java.sql.Connection connection = null;
    public boolean inUse = false;

    public ConnectionObject(Connection c, boolean useFlag) {
        connection = c;
        inUse = useFlag;
    }
}
