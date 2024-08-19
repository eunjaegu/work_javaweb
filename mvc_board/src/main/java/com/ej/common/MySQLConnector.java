package com.ej.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLConnector {
	private Connection connector = null;
	
	public MySQLConnector() {	//외부에서 객체 생성 방지
	}
	
	/** MemberDAO 의 각 메서드 내에서 호출 **/
	public Connection getConnector() {	
		if (connector == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://127.0.0.1:3306/test";
				
				connector = DriverManager.getConnection(url, "root", "1234");
			} catch (Exception e) {
				System.err.println("getConnector() ERR : " + e.getMessage());
			}
		}
		return connector;
	} //end
	
	/** PreparedStatement, Connection CLOSE **/
	public static void close(PreparedStatement pstmt, Connection connector) {
		if (pstmt !=null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.err.println("PreparedStatement CLOSE() ERR : " + e.getMessage());
			}
		}
	}
		
		/** ResultSet, PreparedStatement, Connection CLOSE **/
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection connector) {
		if (rs !=null) {
			try {
					rs.close();
			} catch (Exception e) {
					System.err.println("ResultSet CLOSE() ERR : " + e.getMessage());
			}
		}
			
		if (pstmt !=null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.err.println("PreparedStatement CLOSE() ERR : " + e.getMessage());
			}
		}
			
		if (connector !=null) {
			try {
				connector.close();
			} catch (Exception e) {
				System.err.println("Connection CLOSE() ERR : " + e.getMessage());
			}
		}
	
	}// close end

}
