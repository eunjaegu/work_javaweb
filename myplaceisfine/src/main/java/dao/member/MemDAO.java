package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.connection.MySQLConnector;
import model.MemVO;

public class MemDAO implements MemberQuerys {
	private MySQLConnector DB = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemDAO() {
		DB = new MySQLConnector();
	}

	/**
	 * 회원 로그인 처리
	 **/
	public boolean AdminLogin(MemVO member) {
		boolean result = false;
		String id=null;
		String pwd=null;
		
		try {
			conn = DB.dbConnect();
			pstmt = conn.prepareStatement(memberID);
			pstmt.setString(1, member.getmem_id());
			rs = pstmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.close(rs, pstmt, conn);
		}

		return (Boolean) null;
	}
	
	
	
}	//class MemDAO END
