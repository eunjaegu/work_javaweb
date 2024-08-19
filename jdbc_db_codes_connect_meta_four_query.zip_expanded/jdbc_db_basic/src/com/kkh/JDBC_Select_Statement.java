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
		
		// ---JDBC_Select 추가된 내용 -------
		ResultSet rs = null;
		int no = 0;
		
		String name, email, phone; // 데이터베이스에서 얻어온 필드값 저장할 변수 선언
		String sql; // SQL문을 저장할 변수 선언
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			stmt = con.createStatement();
			
			// ---JDBC_Select 추가된 내용 -------
			sql = "SELECT * FROM customer";
			System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \n");
			System.out.printf("-----------------------------------------------------------------\n");
			
			rs = stmt.executeQuery(sql); // 얻어진 레코드를 가져옴
			while (rs.next()) {
				no = rs.getInt("no");
				name = rs.getString("name");
				email = rs.getString("email");
				phone = rs.getString("phone");
				System.out.printf(" %d \t %s \t %s \t %s\n", no, name, email, phone);
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
				if (stmt != null){
					stmt.close();
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
