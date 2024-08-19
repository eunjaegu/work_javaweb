package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.freeflux.guest.dao.MySQLConnector;
import com.freeflux.guest.dao.Querys;
import com.freeflux.guest.dto.Guest;

public class InsertController  extends MySQLConnector implements Querys{
	Connection connector = null;
	
	public InsertController() {
		this.connector = connect();
	}

	public void insert(Guest guest) {
		PreparedStatement pstmt =null;
		// (name, title, content, moment, hit) values (?, ?, ?, now(), 0)
		try {
			pstmt = connector.prepareStatement(INSERT);
			pstmt.setString(1, guest.getName());
			pstmt.setString(2, guest.getTitle());
			pstmt.setString(3, guest.getContent());
			
			int n=pstmt.executeUpdate();
			if(n < 1) {
				System.err.println("INSERT FAIL!!!!");
			}
			
		}catch (SQLException e) {
			System.err.println("InsertController => insert() ERR : " + e.getMessage());
		}finally {
			close(connector, pstmt);
		}
		System.out.println("InsertController => insert() END" );

	}
}
