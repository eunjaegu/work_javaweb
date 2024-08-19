package com.kkh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connect02_db_connect {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bbsdb";
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");

			System.out.println("데이터베이스 연결 성공!");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 ERR! : " + e.getMessage());

		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Connection 자원해제 ERR! : " + e.getMessage());
			}
		}

	}
}
