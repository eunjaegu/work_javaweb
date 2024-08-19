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
		
		
		PreparedStatement pstmt = null; // PreparedStatement 객체 변수 pstmt를 선언
		String sql; // SQL문을 저장할 변수 선언
		ResultSet rs = null;

		ResultSetMetaData rsm; // ResultSetMetaData 객체 변수 선언

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);

			sql = "SELECT * FROM customer";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery(sql);
			// ResultSet 객체로 getMetaData() 메서드를 호출하여 ResultSetMetaData 객체 생성
			rsm = rs.getMetaData();

			// ResultSetMetaData 의 getColumnCount() 메서드는 컬럼의 개수를 반환한다.
			int cols = rsm.getColumnCount();
			System.out.println("컬럼의 개수 : "+cols);

			// 컬럼 목록 보여주기
			for (int i = 1; i <= cols; i++) {
				// ResultSetMetaData 의 getColumnName( ) 메서드는 해당 위치의 컬럼명을 반환
				System.out.print(rsm.getColumnName(i) + "\t\t");
			}
			
			System.out.println();
			
			// 얻어낸 컬럼 값 보여주기
			while (rs.next()) {
				for (int i = 1; i <= cols; i++){
					System.out.print(rs.getObject(i) + "\t\t");
				}
				System.out.println();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("SQL ERR! : " + e.getMessage());

		} finally {
			
			try {	// rs, stmt, con 객체를 close() 메서드를 호출해 해제
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
				System.out.println("자원해제 ERR! : " + e.getMessage());
			}
		}
	}
}
