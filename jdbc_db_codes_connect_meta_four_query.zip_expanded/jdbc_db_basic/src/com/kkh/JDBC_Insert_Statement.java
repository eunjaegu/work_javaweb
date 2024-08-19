package com.kkh;

//���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Insert_Statement {
	
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bbsdb";
		Connection con = null;
		Statement stmt = null;

		String sql;

		String name, email, tel, no;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			stmt = con.createStatement();
			
			// ---JDBC_Insert �߰��� ����-------
			// ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" customer ���̺� �� �Է��ϱ� .....");

			System.out.print(" ��ȣ �Է�: ");
			no = br.readLine(); // ���̺� �߰��� no �ʵ� ���� �Է� ����

			System.out.print(" �̸� �Է�: ");
			name = br.readLine(); // ���̺� �߰��� name �ʵ� ���� �Է� ����
			
			System.out.print(" �̸��� �Է�: ");
			email = br.readLine(); // ���̺� �߰��� email �ʵ� ���� �Է� ����
			
			System.out.print(" ��ȭ��ȣ �Է�: ");
			tel = br.readLine(); // ���̺� �߰��� tel �ʵ� ���� �Է� ����

			// INSERT �������� �ۼ�
			sql = "INSERT into customer (no, name, email, phone) values ";
			sql += "(" + no + ",'" + name + "','" + email + "','" + tel + "')";

			// Statement ��ü�� executeUpdate(sql) �޼��带 �̿���
			stmt.executeUpdate(sql); // �����ͺ��̽� ���Ͽ� ���ο� ���� �߰���Ŵ
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("SQL ERR! : " + e.getMessage());
			
		}  catch (IOException e) {
			System.out.println("IO ERR! : " + e.getMessage());
			
		}	finally {
			try {
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
