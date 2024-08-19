package com.ej.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnector {
	private Connection connector=null;
	
	public MySQLConnector() {
		
	}
	
	public Connection getConnection() {
		if (connector == null) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/test";
				
				connector = DriverManager.getConnection(url, "root", "1234");
				
			} catch (Exception e) {
				System.err.println("CONNECTION ERR :" + e.getMessage());
			}
		}
		return connector;
		
	}
	
	
	public void close(Connection connector, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (connector != null) {
				rs.close();
			}
			if (connector != null) {
				pstmt.close();
			}
			if (connector != null) {
				connector.close();
			}
		} catch (SQLException e) {
			System.err.println("Connection, PreparedStatement, ResultSet CLOSE ERR : " + e.getMessage());
		}
	}
	
}
