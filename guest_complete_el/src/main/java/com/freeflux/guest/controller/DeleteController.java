package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.freeflux.guest.dao.MySQLConnector;
import com.freeflux.guest.dao.Querys;

public class DeleteController extends MySQLConnector implements Querys {
	Connection connector = null;
	
	public DeleteController() {
		this.connector = connect();
	}
	
	public void delete(int idx2) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connector.prepareStatement(DELETE);
			pstmt.setInt(1, idx2);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("DeleteController => delete() ERR : " + e.getMessage());
		} 
		
		System.out.println("DeleteController => delete() END");
	}

}
