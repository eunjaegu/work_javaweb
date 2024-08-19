package com.ej.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnector {
	public Connection connector = null;

	public MySQLConnector() { // 외부에서 객체 생성 방지
	}

	public void connect() {
		
		if (connector == null) {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				connector = DriverManager.getConnection("ID", "PW", "DBNAME");
			} catch (ClassNotFoundException | SQLException e) {
				System.err.println("CLASS | CONNECTION ERR : " + e.getMessage());

			}

		} // if()
	} // connect()
	public void close() {	
		if(connector !=null) {	
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
	
	
	
	
	
	
	
	
	
	
    	
    }	// END class MySQLConnector
