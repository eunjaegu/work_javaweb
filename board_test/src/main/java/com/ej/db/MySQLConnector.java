package com.ej.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Connection 객체는 하나의 서블릿이 일을 마칠 때 마다 바로 close() **/
public class MySQLConnector {
	public Connection connector = null;

	public MySQLConnector() { // 외부에서 객체 생성 방지
	}

	public void connect() {
		// 1. connector가 null인지 확인 후, null 일 경우에만 객체 생성
		if (connector == null) {
			try {
				// Driver로드
				Class.forName("com.mysql.cj.jdbc.Driver");
				// Connection 객체 얻기
				connector = DriverManager.getConnection("ID", "PW", "DBNAME");
			} catch (ClassNotFoundException | SQLException e) {
				System.err.println("CLASS | CONNECTION ERR : " + e.getMessage());

			}

		} // if()
	} // connect()
	public void close() {	//Connection CLOSE
		if(connector !=null) {	//connector !=null
			try {
				connector.close();
			} catch (SQLException e) {
				System.err.println("CONNECTION CLOSE ERR : " + e.getMessage());
			}
			
		}
	}
	
	public void close(PreparedStatement pstmt, ResultSet rs) {	//Connection CLOSE
			if(rs !=null) {	//connector !=null
				try {
					rs.close();
					//connector.close();
				} catch (SQLException e) {
					System.err.println("ResultSet CLOSE ERR : " + e.getMessage());
				}
				if(pstmt !=null) {	
					try {
						pstmt.close();
					} catch (SQLException e) {
						System.err.println("PreparedStatement CLOSE ERR " + e.getMessage());
					}
				}
			}
		}	//close()
    	
    }
