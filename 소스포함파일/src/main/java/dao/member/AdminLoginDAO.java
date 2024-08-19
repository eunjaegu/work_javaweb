package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.mall.MySQLConnector;
import db.mall.AdminQuerys;
import model.mall.AdminVO;

public class AdminLoginDAO implements AdminQuerys {
	private MySQLConnector DB = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AdminLoginDAO() {
		DB = new MySQLConnector();
	}
	/** 어드민 로그인 처리 **/
	public boolean adminLogin(AdminVO admin) {
		boolean result = false;
		String id = null;
		String pwd = null;
		
		try {
			conn = DB.dbConnect();
			pstmt = conn.prepareStatement(adminID);
			pstmt.setString(1, admin.getAdmin_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("admin_id");
				pwd = rs.getString("admin_pwd");
				if(admin.getAdmin_id().equals(id) && admin.getAdmin_pw().equals(pwd)) 
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
	
	/** 어드민 아이디 중복 처리 **/
	public boolean overlappedID(String _id) {
		boolean result = false;
	
		try {
			conn = DB.dbConnect();
			pstmt = conn.prepareStatement(adminID);
			pstmt.setString(1, _id);
			rs = pstmt.executeQuery();
			
			result = rs.next();
		} catch (SQLException e) {
			System.err.println("overlappedID() ERR : " + e.getMessage());
		} finally {
			DB.close(rs, pstmt, conn);
		}
		
		return result;
	}
}

