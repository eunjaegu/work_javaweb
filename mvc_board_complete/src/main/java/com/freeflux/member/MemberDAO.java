package com.freeflux.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.freeflux.common.MySQLConnector;

public class MemberDAO {
	private Connection connect = null;
	private PreparedStatement pstmt = null;
	private MySQLConnector dataFactory = null;
	ResultSet rs = null;

	public MemberDAO() {
		dataFactory = new MySQLConnector(); 
	}

	public List<MemberVO> listMembers() {
		List<MemberVO> membersList = new ArrayList<MemberVO>();
		try {
			connect = dataFactory.getConnection();
			String query = "select * from  t_member order by joinDate desc";
			System.out.println(query);
			
			pstmt = connect.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
				membersList.add(memberVO);
				System.out.println(memberVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return membersList;
	}

	public void addMember(MemberVO m) {
		try {
			connect = dataFactory.getConnection();
			String id = m.getId();
			String pwd = m.getPwd();
			String name = m.getName();
			String email = m.getEmail();
			String query = "INSERT INTO t_member (id, pwd, name, email, joindate)" + " VALUES (?, ? ,? ,?, now())";
			System.out.println(query);
			
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MemberVO findMember(String _id) {
		MemberVO memInfo = null;
		try {
			connect = dataFactory.getConnection();
			String query = "select * from  t_member where id=?";
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, _id);
			System.out.println(query);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			memInfo = new MemberVO(id, pwd, name, email, joinDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return memInfo;
	}

	public void modMember(MemberVO memberVO) {
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		try {
			connect = dataFactory.getConnection();
			String query = "update t_member set pwd=?,name=?,email=?  where id=?";
			System.out.println(query);
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			pstmt.close();
//			connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delMember(String id) {
		try {
			connect = dataFactory.getConnection();
			String query = "delete from t_member where id=?";
			System.out.println(query);
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1,id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean overlappedID(String id) {
		boolean result = false;
		try {
			connect = dataFactory.getConnection();
			String query = "select * from t_member where id=?";
			System.out.println("prepareStatememt: " + query);

			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			result = rs.next();
			System.out.println("rs.next(): " + result);

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
