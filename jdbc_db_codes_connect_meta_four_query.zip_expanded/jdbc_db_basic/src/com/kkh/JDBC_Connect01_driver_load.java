package com.kkh;

public class JDBC_Connect01_driver_load {
	
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 ERR! : " + e.getMessage());
		}
	}
}
