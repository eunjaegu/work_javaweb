package com.kkh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Select_Statement {
	
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bbsdb";
		Connection con = null;
		Statement stmt = null;
		
		// ---JDBC_Select �߰��� ���� -------
		ResultSet rs = null;
		int no = 0;
		
		String name, email, phone; // �����ͺ��̽����� ���� �ʵ尪 ������ ���� ����
		String sql; // SQL���� ������ ���� ����
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			stmt = con.createStatement();
			
			// ---JDBC_Select �߰��� ���� -------
			sql = "SELECT * FROM customer";
			System.out.printf("��ȣ \t �̸� \t\t �̸��� \t\t ��ȭ��ȣ \n");
			System.out.printf("-----------------------------------------------------------------\n");
			
			rs = stmt.executeQuery(sql); // ����� ���ڵ带 ������
			while (rs.next()) {
				no = rs.getInt("no");
				name = rs.getString("name");
				email = rs.getString("email");
				phone = rs.getString("phone");
				System.out.printf(" %d \t %s \t %s \t %s\n", no, name, email, phone);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("SQL ERR! : " + e.getMessage());
			
		} finally {
			try {	// rs, stmt, con ��ü�� close() �޼��带 ȣ���� ����
				if (rs != null){
					rs.close();
				}
				if (stmt != null){
					stmt.close();
				}
				if (con != null){
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("�ڿ����� ERR! : " + e.getMessage());
			}
		}
	}
}
