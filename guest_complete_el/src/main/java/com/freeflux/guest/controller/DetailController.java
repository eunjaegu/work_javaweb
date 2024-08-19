package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.freeflux.guest.dao.MySQLConnector;
import com.freeflux.guest.dao.Querys;
import com.freeflux.guest.dto.Guest;

public class DetailController extends MySQLConnector implements Querys {
	Connection connector = null;
	PreparedStatement pstmt = null;

	public DetailController() {
		this.connector = connect();
	}

	private void hit(int idx) {
		// set hit=hit+1 where idx=?
		try {
			pstmt = connector.prepareStatement(UPDATE_HIT);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("DetailController => hit() ERR : " + e.getMessage());
		} 
	}

	public Guest detail(int idx) {
		this.hit(idx);
		ResultSet rs = null;

		Guest guest = null;

		// select * from "+ TABLE_NAME + " where idx=?
		try {
			pstmt = connector.prepareStatement(SELECT_ONE);
			pstmt.setInt(1, idx);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				guest = new Guest();
				guest.setIdx(rs.getInt(1));
				guest.setName(rs.getString(2));
				guest.setTitle(rs.getString(3));
				guest.setContent(rs.getString(4));
				guest.setMoment(rs.getDate(5));
				guest.setHit(rs.getInt(6));
				System.out.println("DETAIL RECODE : " + guest);
			}

		} catch (SQLException e) {
			System.err.println("DetailController => detail() ERR : " + e.getMessage());
		} finally {
			close(connector, pstmt, rs);
		}

		System.out.println("DetailController =>  detail() END");
		return guest;
	}

}
