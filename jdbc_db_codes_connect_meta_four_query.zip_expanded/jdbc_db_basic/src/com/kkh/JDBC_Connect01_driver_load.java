package com.kkh;

public class JDBC_Connect01_driver_load {
	
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			System.out.println("����̹� �ε� ����!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ERR! : " + e.getMessage());
		}
	}
}
