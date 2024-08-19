package com.kkh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Insert2_PreparedStatement {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bbsdb";
		Connection con = null;

		PreparedStatement pstmt = null; // PreparedStatement ��ü ���� pstmt�� ����
		
		int no;
		String name, email, phone, temp; // �����ͺ��̽����� ���� �ʵ� �� ������ ���� ����
		
		String sql; // SQL���� ������ ���� ����

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");

			// ---JDBC_Insert2 �߰��� ����-------
			// ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" customer ���̺� �� �Է��ϱ� .....");
			System.out.print(" ��ȣ �Է�: ");
			temp = br.readLine();
			
			System.out.print(" �̸� �Է�: ");
			name = br.readLine(); // ���̺� �߰��� name �ʵ� ���� �Է� ����
			
			System.out.print(" �̸��� �Է�: ");
			email = br.readLine(); // ���̺� �߰��� email �ʵ� ���� �Է� ����
			
			System.out.print(" ��ȭ��ȣ �Է�: ");
			phone = br.readLine(); // ���̺� �߰��� phone �ʵ� ���� �Է� ����

			// ? ���ڰ� ���Ե� INSERT ���� �ۼ�
			sql = "INSERT INTO customer(no, name, email, phone) values(?,?,?,?)";

			// PrepareStatement�� ��ü�� ����
			pstmt = con.prepareStatement(sql);
			
			no = Integer.parseInt(temp);
			pstmt.setInt(1, no); // ù ��° ? �� ����ڷκ��� �Է¹��� ��ȣ�� ����
			pstmt.setString(2, name); // �� ��° ? �� ����ڷκ��� �Է¹��� �̸��� ����
			pstmt.setString(3, email); // �� ��° ? �� ����ڷκ��� �Է¹��� �̸����� ����
			pstmt.setString(4, phone); // �� ��° ? �� ����ڷκ��� �Է¹��� ��ȭ��ȣ�� ����

			// PreparedStatement ��ü�� executeUpdate( ) �޼��带 �̿���
			pstmt.executeUpdate(); // �����ͺ��̽� ���Ͽ� ���ο� ���� �߰���Ŵ

		}catch (ClassNotFoundException e) {
			System.out.println("����̹� ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("SQL ERR! : " + e.getMessage());
			
		}  catch (IOException e) {
			System.out.println("IO ERR! : " + e.getMessage());
			
		} finally {
			try {
				if (pstmt != null){
					pstmt.close(); // PrepareStatement ��ü�� �޸𸮿��� ����
				}
				if (con != null){
					con.close();
				}
					
			} catch (SQLException e) {
				System.out.println("�ڿ����� ERR! : " + e.getMessage());
			}
		}// finally ��
	}
}
