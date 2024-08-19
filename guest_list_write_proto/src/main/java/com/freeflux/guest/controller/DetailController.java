package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.freeflux.guest.dao.MySQLConnector;
import com.freeflux.guest.dao.Querys;
import com.freeflux.guest.dto.Guest;

public class DetailController extends MySQLConnector implements Querys {
	Connection connector = null; 

	public DetailController() {
		this.connector = connect();
	}
	
	
	public List<Guest> detail(int idx) {
		ArrayList<Guest> gdetail = new ArrayList<Guest>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = connector.prepareStatement(SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			Guest guest = null;
			while(rs.next()){
				guest = new Guest();
				
				guest.setIdx(rs.getInt("idx")); //idx
				guest.setName(rs.getString("name")); //name
				guest.setTitle(rs.getString("title")); //Title
				guest.setTitle(rs.getString("content")); //Title
				guest.setMoment(rs.getDate("moment")); //Moment
				guest.setHit(rs.getInt("hit")); //hit
				
				gdetail.add(guest);
			}
		} catch (Exception e) {
			System.err.println("DetailController => detail() END ");
		}finally {
			close(connector, pstmt, rs);
		}

		System.out.println("DetailController =>  detail() ");
		return gdetail;
	}

	
	
	
	
	
}
