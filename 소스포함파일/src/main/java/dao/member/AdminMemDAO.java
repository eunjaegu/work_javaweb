package dao.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.mall.MemberQuerys;
import db.mall.MySQLConnector;
import model.mall.MemInfoVO;

public class AdminMemDAO implements MemberQuerys {

	private Connection conn = null;
	private PreparedStatement pstmt=null;
	private MySQLConnector datasource=null;
	private ResultSet rs = null;
	
	public AdminMemDAO() {
		datasource = new MySQLConnector();
	}

	
	/**
	 * 관리자 회원 목록 조회
	 * @param AdminMemModel
	 * @return
	 */
	public ArrayList<MemInfoVO> selectList() {
		ArrayList adminmemList = new ArrayList<MemInfoVO>();
		
		try {
			conn = datasource.dbConnect();
			this.pstmt = this.conn.prepareStatement(selectAll);
			this.rs = this.pstmt.executeQuery();
			
			MemInfoVO adminmemModel = null;
			
			while (this.rs.next()) {
				adminmemModel = new MemInfoVO();
				adminmemModel.setId(this.rs.getString("id"));
				adminmemModel.setPwd(this.rs.getString("pwd"));
				adminmemModel.setName(this.rs.getString("name"));
				adminmemModel.setGender(this.rs.getString("gender"));
				adminmemModel.setBirthday(this.rs.getString("birthday"));
				adminmemModel.setEmail(this.rs.getString("email"));
				adminmemModel.setZipcode(this.rs.getString("zipcode"));
				adminmemModel.setAddress(this.rs.getString("address"));
				adminmemModel.setHobby(this.rs.getString("hobby"));
				
				adminmemList.add(adminmemModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			datasource.close(this.rs, this.pstmt, this.conn);
		}
		
		return adminmemList;
	}
	
	/**
	 * 관리자 회원 목록 상세 조회
	 * @param boardModel
	 * @return
	 */
	public MemInfoVO selectOne(MemInfoVO adminmemModel) {
		try {
			conn = datasource.dbConnect();
			this.pstmt = this.conn.prepareStatement(memberID);
			this.pstmt.setString(1, adminmemModel.getId());
			this.rs = this.pstmt.executeQuery();
 
			if (this.rs.next()) {
				adminmemModel = new MemInfoVO();
				adminmemModel.setId(this.rs.getString("id"));
				adminmemModel.setPwd(this.rs.getString("pwd"));
				adminmemModel.setName(this.rs.getString("name"));
				adminmemModel.setGender(this.rs.getString("gender"));
				adminmemModel.setBirthday(this.rs.getString("birthday"));
				adminmemModel.setEmail(this.rs.getString("email"));
				adminmemModel.setZipcode(this.rs.getString("zipcode"));
				adminmemModel.setAddress(this.rs.getString("address"));
				adminmemModel.setHobby(this.rs.getString("hobby"));
			}
//			System.out.println(adminmemModel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 객체 종료
			datasource.close(this.rs, this.pstmt, this.conn);
		}
		return adminmemModel;
	}
	
	/**
	 * 관리자 회원정보 수정
	 * @param AdminMemModel
	 */
	public void update(MemInfoVO adminmemModel) {
		try {
			conn = datasource.dbConnect();
			this.pstmt = this.conn.prepareStatement(updateMem);
			this.pstmt.setString(1, adminmemModel.getPwd());
			this.pstmt.setString(2, adminmemModel.getName());
			this.pstmt.setString(3, adminmemModel.getGender());
			this.pstmt.setString(4, adminmemModel.getBirthday());
			this.pstmt.setString(5, adminmemModel.getEmail());
			this.pstmt.setString(6, adminmemModel.getZipcode());
			this.pstmt.setString(7, adminmemModel.getAddress());
			this.pstmt.setString(8, adminmemModel.getHobby());
			this.pstmt.setString(9, adminmemModel.getJob());
			this.pstmt.setString(10, adminmemModel.getId());
			int n = this.pstmt.executeUpdate();
			if(n > 0) {
				System.out.println("update success!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			datasource.close(null, this.pstmt, this.conn);
		}
		
	}
	
	/**
	 * 사용한 객체를 닫음
	 * 
	 * @param rs
	 * @param pstmt
	 * @param conn
	 */
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
} // class END
