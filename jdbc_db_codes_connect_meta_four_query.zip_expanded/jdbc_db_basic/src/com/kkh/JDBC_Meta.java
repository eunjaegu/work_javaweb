package com.kkh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC_Meta {
	
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bbsdb";
		String user = "root";
		String pwd = "1234";

		Connection con = null;
		
		
		PreparedStatement pstmt = null; // PreparedStatement ��ü ���� pstmt�� ����
		String sql; // SQL���� ������ ���� ����
		ResultSet rs = null;

		ResultSetMetaData rsm; // ResultSetMetaData ��ü ���� ����

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);

			sql = "SELECT * FROM customer";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery(sql);
			// ResultSet ��ü�� getMetaData() �޼��带 ȣ���Ͽ� ResultSetMetaData ��ü ����
			rsm = rs.getMetaData();

			// ResultSetMetaData �� getColumnCount() �޼���� �÷��� ������ ��ȯ�Ѵ�.
			int cols = rsm.getColumnCount();
			System.out.println("�÷��� ���� : "+cols);

			// �÷� ��� �����ֱ�
			for (int i = 1; i <= cols; i++) {
				// ResultSetMetaData �� getColumnName( ) �޼���� �ش� ��ġ�� �÷����� ��ȯ
				System.out.print(rsm.getColumnName(i) + "\t\t");
			}
			
			System.out.println();
			
			// �� �÷� �� �����ֱ�
			while (rs.next()) {
				for (int i = 1; i <= cols; i++){
					System.out.print(rs.getObject(i) + "\t\t");
				}
				System.out.println();
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
				if (pstmt != null){
					pstmt.close();
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
