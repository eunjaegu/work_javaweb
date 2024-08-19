package dao.session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.mall.MemberQuerys;
import db.mall.MySQLConnector;
import db.mall.AdminQuerys;
import model.mall.SessionVO;

public class SessionDAO implements AdminQuerys, MemberQuerys {
	private MySQLConnector DB = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public SessionDAO() {
		DB = new MySQLConnector();
	}

	/** 세션 처리 **/
	public String loginCheck(SessionVO session) {
		String result = null;
		String id = null;
		
		try {
			conn = DB.dbConnect();
			pstmt = conn.prepareStatement(adminID);
			pstmt.setString(1, session.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("admin_id");
				if(session.getId().equals(id)) 
					result = "admin";
			}
			
			conn = DB.dbConnect();
			pstmt = conn.prepareStatement(memberID);
			pstmt.setString(1, session.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
				if(session.getId().equals(id)) 
					result = "member";
			}
		} catch (SQLException e) {
			System.err.println("loginCheck() ERR : " + e.getMessage());
		} finally {
			DB.close(rs, pstmt, conn);
		}
		return result;
	}
}
