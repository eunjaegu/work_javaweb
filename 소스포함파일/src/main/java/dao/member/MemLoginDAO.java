package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.mall.MemberQuerys;
import db.mall.MySQLConnector;
import model.mall.MemLoginVO;

public class MemLoginDAO implements MemberQuerys {
	private MySQLConnector DB = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemLoginDAO() {
		DB = new MySQLConnector();
	}
	/** 멤버 로그인 처리 **/
	public boolean MemLogin(MemLoginVO member) {
		boolean result = false;
		String id = null;
		String pwd = null;
		
		try {
			conn = DB.dbConnect();
			pstmt = conn.prepareStatement(memberID);
			pstmt.setString(1, member.getMem_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
				pwd = rs.getString("pwd");
				if(member.getMem_id().equals(id) && member.getMem_pw().equals(pwd)) 
					result = true;
				else
					result = false;
			} else 
				result = false;
		} catch (SQLException e) {
			System.err.println("adminLogin() ERR : " + e.getMessage());
		} finally {
			DB.close(rs, pstmt, conn);
		}
		return result;
	}
	
}
