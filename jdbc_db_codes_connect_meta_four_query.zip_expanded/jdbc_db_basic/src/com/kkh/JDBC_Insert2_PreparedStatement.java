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

		PreparedStatement pstmt = null; // PreparedStatement 객체 변수 pstmt를 선언
		
		int no;
		String name, email, phone, temp; // 데이터베이스에서 얻어온 필드 값 저장할 변수 선언
		
		String sql; // SQL문을 저장할 변수 선언

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");

			// ---JDBC_Insert2 추가된 내용-------
			// 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" customer 테이블에 값 입력하기 .....");
			System.out.print(" 번호 입력: ");
			temp = br.readLine();
			
			System.out.print(" 이름 입력: ");
			name = br.readLine(); // 테이블에 추가할 name 필드 값을 입력 받음
			
			System.out.print(" 이메일 입력: ");
			email = br.readLine(); // 테이블에 추가할 email 필드 값을 입력 받음
			
			System.out.print(" 전화번호 입력: ");
			phone = br.readLine(); // 테이블에 추가할 phone 필드 값을 입력 받음

			// ? 문자가 포함된 INSERT 문을 작성
			sql = "INSERT INTO customer(no, name, email, phone) values(?,?,?,?)";

			// PrepareStatement를 객체를 생성
			pstmt = con.prepareStatement(sql);
			
			no = Integer.parseInt(temp);
			pstmt.setInt(1, no); // 첫 번째 ? 에 사용자로부터 입력받은 번호를 대입
			pstmt.setString(2, name); // 두 번째 ? 에 사용자로부터 입력받은 이름을 대입
			pstmt.setString(3, email); // 세 번째 ? 에 사용자로부터 입력받은 이메일을 대입
			pstmt.setString(4, phone); // 네 번째 ? 에 사용자로부터 입력받은 전화번호를 대입

			// PreparedStatement 객체의 executeUpdate( ) 메서드를 이용해
			pstmt.executeUpdate(); // 데이터베이스 파일에 새로운 값을 추가시킴

		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("SQL ERR! : " + e.getMessage());
			
		}  catch (IOException e) {
			System.out.println("IO ERR! : " + e.getMessage());
			
		} finally {
			try {
				if (pstmt != null){
					pstmt.close(); // PrepareStatement 객체를 메모리에서 해제
				}
				if (con != null){
					con.close();
				}
					
			} catch (SQLException e) {
				System.out.println("자원해제 ERR! : " + e.getMessage());
			}
		}// finally 끝
	}
}
