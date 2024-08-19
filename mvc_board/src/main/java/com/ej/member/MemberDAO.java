package com.ej.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;

import com.ej.common.MySQLConnector;

/** MemberController 에서 각 메서드 호출**/
public class MemberDAO {
	private Connection connector = null;
	private MySQLConnector datasource = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public MemberDAO() {
		datasource = new MySQLConnector();
	}

	/** 회원목록(정보) 조회**/
	public List<MemberVO> ListMembers(){
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		try {
			connector = datasource.getConnector();
			String query = "select * from t_member order by joindate desc";
			
			pstmt = connector.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			MemberVO member = null;
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setJoindate(rs.getDate("joindate"));
				//System.out.println(member);
				memberList.add(member);
			}
			
		} catch (SQLException e) {
			System.err.println("listMembers() ERR : " + e.getMessage());
		}
		
		return memberList;
	}
	/** 회원 가입 처리**/
	public void addMember(MemberVO member) {
		try {
			connector=datasource.getConnector();
			
			String query = "insert into t_member values(?, ?, ?, ?, now())";
			
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
		
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.err.println("addMember() : " + e.getMessage());
		}
	}
	
	/** 한사람의 정보 처리(수정링크 클릭시 : 목록에서) **/
	public MemberVO findMember(String _id) {
		MemberVO member = null;
		try {
			connector = datasource.getConnector();
			String query="select * from t_member where id=?";
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, _id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setJoindate(rs.getDate("joindate"));
			}
			
		} catch (SQLException e) {
			System.err.println("findMember() ERR :" + e.getMessage());
		}
		return member;
	}// findMember() END
	
	/** 회원정보 수정 처리(수정버튼 클릭시 : 수정화면에서) **/
	public void modMember(MemberVO member) {
		try {
			connector = datasource.getConnector();
			String query = "update t_member set name=?, email=?, pwd=? where id=?";
			
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPwd());
			pstmt.setString(4, member.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("modMember() ERR : " +e.getMessage() );
		}
	}
	
	/** 회원정보 삭제 처리(삭제링크 클릭시 : 목록에서) **/
	public void delMember(String _id) {
		try {
			connector = datasource.getConnector();
			String query = "delete from t_member where id=?";
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1,_id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("delMember() ERR : " + e.getMessage());
		}
	}
	
	/** 아이디 중복 처리**/
	public boolean overlappinID(String _id) {
		boolean result = false;
		
		try {
			connector = datasource.getConnector();
			
			String query = "select id from t_member where id=?";
			
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, _id);
			rs=pstmt.executeQuery();
			
			result = rs.next();
			
		}catch (SQLException e) {
			System.err.println("overlappedID() ERR : " +e.getMessage());
		}
		return result;
	}
	
}



