package com.kkh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connect03_statement {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bbsdb";
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			
			stmt = con.createStatement();
			System.out.println("Statement ��ü ���� ����!");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("SQL ERR! : " + e.getMessage());

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("�ڿ����� ERR! : " + e.getMessage());
			}
		}
	}
}
