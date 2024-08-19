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

			System.out.println("customer 테이블에서 찾고자하는 사람이름이나 이메일이나 전화번호를 입력하기");
			
			System.out.print(" 이름 입력: ");
			s_name = br.readLine(); // 테이블에서 찾고자하는 사람의 이름을 입력 받음
			
			System.out.print(" 이메일 입력: ");
			s_email = br.readLine(); // 테이블에서 찾고자하는 사람의 이메일을 입력 받음
			
			System.out.print(" 전화번호 입력: ");
			s_phone = br.readLine(); // 테이블에서 찾고자하는 사람의 전화번호를 입력 받음

			// SELECT 쿼리문을 작성
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

			// PreparedStatement 객체의 executeQuery( ) 메소드로 데이터 검색
			rs = pstmt.executeQuery();
			System.out.println("\n\n --------- 검색 결과 출력 ---------- ");
			
			while (rs.next()) {
				s_name = rs.getString("name");
				s_email = rs.getString("email");
				s_phone = rs.getString("phone");
				// 컬럼 값을 화면에 출력
				System.out.println(s_name + " \t " + s_email + " \t " + s_phone);
			} // while

			rs.close();
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("SQL ERR! : " + e.getMessage());

		} catch (IOException e) {
					System.out.println("IO ERR! : " + e.getMessage());
					
		} finally {
			try { // rs, stmt, con 객체를 close() 메서드를 호출해 해제
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
				System.out.println("자원해제 ERR! : " + e.getMessage());
			}
		}
	}
}