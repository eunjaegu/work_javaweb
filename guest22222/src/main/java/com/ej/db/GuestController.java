package com.ej.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestController extends MySQLConnector {	//접속과 close 필요함

	public GuestController() {
		connect();	//DB 접속 완료
	
	}
	
	
	public String join(String id, String pw) {
		String query = "select * from guest where id=? and pw=?";
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String result=null;	

		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				result="SUCCESS";
			} else {
				result="FAIL";
			}
		} catch (SQLException e) {
			System.err.println("join() ERR" + e.getMessage());
		}	finally {
			close(pstmt, rs);
			close();
		}
		return result;
		
	}
}	//end