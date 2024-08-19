package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.mall.MemberQuerys;
import db.mall.MySQLConnector;
import db.mall.ZipQuerys;
import model.mall.AddressVO;
import model.mall.MemInfoVO;

public class MemJoinDAO implements MemberQuerys , ZipQuerys {
	private MySQLConnector DB = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemJoinDAO() {
		DB = new MySQLConnector();
	}
	/** 아이디 중복 체크 **/
	public boolean overlappedID(String _id) {
		boolean result = false;
	
		try {
			conn = DB.dbConnect();
			pstmt = conn.prepareStatement(memberID);
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
	
	public ArrayList<AddressVO> address(String addr) {
		ArrayList<AddressVO> addrList = new ArrayList<AddressVO>();
		
		try {
			conn = DB.dbConnect();
			pstmt = conn.prepareStatement(searchAddr + addrWhereSQL);
			pstmt.setString(1, addr);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AddressVO addressVO = new AddressVO();
				addressVO.setZipcode(rs.getString("zipcode"));
				addressVO.setArea1(rs.getString("area1"));
				addressVO.setArea2(rs.getString("area2"));
				addressVO.setArea3(rs.getString("area3"));
				
				addrList.add(addressVO);
			}
			
		} catch (SQLException e) {
			System.err.println("address() ERR : " + e.getMessage());
		} finally {
			DB.close(rs, pstmt, conn);
		}
		return addrList;
	}
	
	public void insertMember(MemInfoVO infoVO) {
		try {
			conn = DB.dbConnect();
			pstmt = conn.prepareStatement(insertMem);
			pstmt.setString(1, infoVO.getId());
			pstmt.setString(2, infoVO.getPwd());
			pstmt.setString(3, infoVO.getName());
			pstmt.setString(4, infoVO.getGender());
			pstmt.setString(5, infoVO.getBirthday());
			pstmt.setString(6, infoVO.getEmail());
			pstmt.setString(7, infoVO.getZipcode());
			pstmt.setString(8, infoVO.getAddress());
			pstmt.setString(9, infoVO.getHobby());
			pstmt.setString(10, infoVO.getJob());
			 
			
		} catch (SQLException e) {
			System.err.println("insertMember() ERR : " + e.getMessage());
		} finally {
			DB.close(rs, pstmt, conn);
		}
	}
	
	public void updateMember(MemInfoVO infoVO) {
		try {
			conn = DB.dbConnect();
			pstmt = conn.prepareStatement(updateMem);
			pstmt.setString(2, infoVO.getPwd());
			pstmt.setString(3, infoVO.getName());
			pstmt.setString(4, infoVO.getGender());
			pstmt.setString(5, infoVO.getBirthday());
			pstmt.setString(6, infoVO.getEmail());
			pstmt.setString(7, infoVO.getZipcode());
			pstmt.setString(8, infoVO.getAddress());
			pstmt.setString(9, infoVO.getHobby());
			pstmt.setString(10, infoVO.getJob());
			pstmt.setString(1, infoVO.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("updateMember() ERR : " + e.getMessage());
		} finally {
			DB.close(rs, pstmt, conn);
		}
	}
	
	public MemInfoVO selectOne(String id) {
		MemInfoVO member = null;
		try {
			member = new MemInfoVO();
			conn = DB.dbConnect();
			this.pstmt = this.conn.prepareStatement(memberID);
			this.pstmt.setString(1, id);
			this.rs = this.pstmt.executeQuery();
 
			if (this.rs.next()) {
				member = new MemInfoVO();
				member.setId(this.rs.getString("id"));
				member.setPwd(this.rs.getString("pwd"));
				member.setName(this.rs.getString("name"));
				member.setGender(this.rs.getString("gender"));
				member.setBirthday(this.rs.getString("birthday"));
				member.setEmail(this.rs.getString("email"));
				member.setZipcode(this.rs.getString("zipcode"));
				member.setAddress(this.rs.getString("address"));
				member.setHobby(this.rs.getString("hobby"));
			}
		} catch (SQLException e) {
			System.err.println("selectOne() ERR : " + e.getMessage());
		} finally {
			// 사용한 객체 종료
			DB.close(this.rs, this.pstmt, this.conn);
		}
		return member;
	}
	
	
}
