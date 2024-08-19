package com.kkh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Select2_PreparedStatement_Search {

	public static void main(String[] args) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bbsdb";
		String user = "root";
		String pwd = "1234";

		Connection con = null;
		PreparedStatement pstmt = null;

		String s_name, s_email, s_phone;
		String sql;

		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("customer ���̺��� ã�����ϴ� ����̸��̳� �̸����̳� ��ȭ��ȣ�� �Է��ϱ�");
			
			System.out.print(" �̸� �Է�: ");
			s_name = br.readLine(); // ���̺��� ã�����ϴ� ����� �̸��� �Է� ����
			
			System.out.print(" �̸��� �Է�: ");
			s_email = br.readLine(); // ���̺��� ã�����ϴ� ����� �̸����� �Է� ����
			
			System.out.print(" ��ȭ��ȣ �Է�: ");
			s_phone = br.readLine(); // ���̺��� ã�����ϴ� ����� ��ȭ��ȣ�� �Է� ����

			// SELECT �������� �ۼ�
			sql = "SELECT * FROM customer WHERE name LIKE ? AND email LIKE ? AND phone LIKE ? ";
			pstmt = con.prepareStatement(sql);

			if (s_name.equals("")){
				s_name = "%";
			}
			if (s_email.equals("")){
				s_email = "%";
			}
			if (s_phone.equals("")){
				s_phone = "%";
			}

			pstmt.setString(1, s_name);
			pstmt.setString(2, s_email);
			pstmt.setString(3, s_phone);

			// PreparedStatement ��ü�� executeQuery( ) �޼ҵ�� ������ �˻�
			rs = pstmt.executeQuery();
			System.out.println("\n\n --------- �˻� ��� ��� ---------- ");
			
			while (rs.next()) {
				s_name = rs.getString("name");
				s_email = rs.getString("email");
				s_phone = rs.getString("phone");
				// �÷� ���� ȭ�鿡 ���
				System.out.println(s_name + " \t " + s_email + " \t " + s_phone);
			} // while

			rs.close();
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("SQL ERR! : " + e.getMessage());

		} catch (IOException e) {
					System.out.println("IO ERR! : " + e.getMessage());
					
		} finally {
			try { // rs, stmt, con ��ü�� close() �޼��带 ȣ���� ����
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
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