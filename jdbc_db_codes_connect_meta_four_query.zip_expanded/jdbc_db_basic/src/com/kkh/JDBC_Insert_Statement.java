package com.kkh;

//도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
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
			
			// ---JDBC_Insert 추가된 내용-------
			// 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" customer 테이블에 값 입력하기 .....");

			System.out.print(" 번호 입력: ");
			no = br.readLine(); // 테이블에 추가할 no 필드 값을 입력 받음

			System.out.print(" 이름 입력: ");
			name = br.readLine(); // 테이블에 추가할 name 필드 값을 입력 받음
			
			System.out.print(" 이메일 입력: ");
			email = br.readLine(); // 테이블에 추가할 email 필드 값을 입력 받음
			
			System.out.print(" 전화번호 입력: ");
			tel = br.readLine(); // 테이블에 추가할 tel 필드 값을 입력 받음

			// INSERT 쿼리문을 작성
			sql = "INSERT into customer (no, name, email, phone) values ";
			sql += "(" + no + ",'" + name + "','" + email + "','" + tel + "')";

			// Statement 객체의 executeUpdate(sql) 메서드를 이용해
			stmt.executeUpdate(sql); // 데이터베이스 파일에 새로운 값을 추가시킴
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 ERR! : " + e.getMessage());

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
				System.out.println("자원해제 ERR! : " + e.getMessage());
			}
		}
	}
}
