package com.freeflux.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Connection 객체는 하나의 서블릿이 일을 마칠 때마다 바로 close() **/
public class MySQLConnector {
	private Connection connector = null;

	public MySQLConnector() { // 외부에서 객체 생성 방지
	}

	public Connection getConnection() {
		// 1. connector가 null인지 확인 후, null 일 경우에만 객체 생성
		if (connector == null) {

			try {
				// Driver로드
				Class.forName("com.mysql.cj.jdbc.Driver");
				// Connection 객체 얻기
				connector = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "1234");

			} catch (ClassNotFoundException | SQLException e) {
				System.err.println("CLASS | CONNECTION ERR : " + e.getMessage());
			}

		} // if() END
		return connector;
	} // connect() END

	public void close() { // Connection CLOSE
		if (connector != null) {
			try {
				connector.close();
			} catch (SQLException e) {
				System.err.println("CONNECTION CLOSE ERR : " + e.getMessage());
			}
		}
	} // close() END
	
	public void close(PreparedStatement pstmt) { 
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("PreparedStatement CLOSE ERR : " + e.getMessage());

			}
		}
		
	} // close() END

	public void close(ResultSet rs, PreparedStatement pstmt) { 
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println("ResultSet CLOSE ERR : " + e.getMessage());
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("PreparedStatement CLOSE ERR : " + e.getMessage());

			}
		}
		
	}

}
