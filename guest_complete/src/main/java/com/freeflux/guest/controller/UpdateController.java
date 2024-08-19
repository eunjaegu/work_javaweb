package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.freeflux.guest.dao.MySQLConnector;
import com.freeflux.guest.dao.Querys;
import com.freeflux.guest.dto.Guest;

public class UpdateController extends MySQLConnector implements Querys {
	Connection connector = null;

	public UpdateController() {
		this.connector = connect();
	}
	
	public void update(Guest guest) {
		PreparedStatement pstmt =null;
	
		//  set title=? , content=?, moment=now()  where idx=?"
		try {
			pstmt = connector.prepareStatement(UPDATE);
			
			pstmt.setString(1, guest.getTitle());
			pstmt.setString(2, guest.getTitle());
			pstmt.setInt(3, guest.getIdx());
			
			int n =pstmt.executeUpdate();
			
			if(n < 1) {
				System.out.println("UPDATE FAIL !!!");
			}
			
		}catch (SQLException e) {
			System.err.println("UpdateController => update() ERR : " + e.getMessage());
		}finally {
			close(connector, pstmt);
		}		
		System.out.println("UpdateController => update() END");
	}

}
