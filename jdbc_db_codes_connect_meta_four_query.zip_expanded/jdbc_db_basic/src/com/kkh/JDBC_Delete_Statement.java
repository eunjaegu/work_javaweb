package com.kkh;

import java.io.BufferedReader; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Delete_Statement {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bbsdb";
		Connection con = null;
		Statement stmt = null;

		String sql;
		String name;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			stmt = con.createStatement();

			// ---JDBC_Delete 변경된 내용-------
			// 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println(" customer 테이블에서 레코드 삭제하기 .....");
			System.out.print("어떤 분의 내용을 삭제할지 그분의 이름을 입력하세요: ");
			name = br.readLine(); // 테이블에서 삭제할 name 필드 값을 입력 받음

			// DELETE 쿼리문을 작성
			sql = "DELETE FROM customer WHERE name ='";
			sql += name + "'";

			// Statement 객체의 executeUpdate(sql) 메서드를 이용해
			stmt.executeUpdate(sql); // 데이터베이스 파일에서 레코드 삭제시킴

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("SQL ERR! : " + e.getMessage());

		} catch (IOException e) {
			System.out.println("IO ERR! : " + e.getMessage());

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
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
