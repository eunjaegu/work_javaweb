package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.mall.MySQLConnector;
import db.mall.ProductQuerys;
import model.mall.AdminProductModel;

public class AdminProductDAO implements ProductQuerys{
	MySQLConnector mysql = new MySQLConnector();
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public AdminProductDAO() {
	}
	
	/**
		상품 목록 조회
		@return
	**/
	public List<AdminProductModel> selectList(){
		List<AdminProductModel> productList = null;
		try {
			conn = mysql.dbConnect();
			this.pstmt = conn.prepareStatement(productAll);
			rs = pstmt.executeQuery();
			productList = new ArrayList<AdminProductModel>();

			while(this.rs.next()) {
				AdminProductModel productModel = new AdminProductModel();
				productModel.setNum(this.rs.getInt("no"));
				productModel.setName(this.rs.getString("name"));
				productModel.setPrice(this.rs.getInt("price"));
				productModel.setDate(this.rs.getString("date"));
				productModel.setStock(this.rs.getInt("stock"));
				
				productList.add(productModel);
				
			}
		} catch (SQLException e) {
			System.err.println("select list err : " + e.getMessage());
		} finally {
			mysql.close(this.rs, this.pstmt, this.conn);
		}
		
		return productList;
	} // selectList() END
	
	/**
	 	상품 총 갯수 조회
	 	@return
	**/
	public int selectCount() {
		int totalCount = 0;
		try {
			conn = mysql.dbConnect();
			this.pstmt = conn.prepareStatement(productCount);
			this.rs = pstmt.executeQuery();
			if(this.rs.next()) {
				totalCount = this.rs.getInt("total");
			}
		} catch (SQLException e) {
			System.err.println("selectCount err : " + e.getMessage());
		}finally {
			mysql.close(this.rs, this.pstmt, this.conn);
		}
		return totalCount;
	}
	
	/**
	 	상품 상세 조회
	 	@param int
	 	@return
	**/
	public AdminProductModel selectOne(int num) {
		AdminProductModel productModel = null;
		
		try {
			conn = mysql.dbConnect();
			this.pstmt = conn.prepareStatement(productOne);
			this.pstmt.setInt(1, num);
			this.rs = pstmt.executeQuery();
			
			if(this.rs.next()) {
				productModel = new AdminProductModel();
				productModel.setNum(this.rs.getInt("no"));
				productModel.setName(this.rs.getString("name"));
				productModel.setImg(this.rs.getString("image"));
				productModel.setPrice(this.rs.getInt("price"));
				productModel.setDate(this.rs.getString("date"));
				productModel.setDetail(this.rs.getString("detail"));
				productModel.setStock(this.rs.getInt("stock"));
				productModel.setDetail(this.rs.getString("detail"));
				
			}
		} catch (SQLException e) {
			System.err.println("selectOne err : " + e.getMessage());
		} finally {
			mysql.close(this.rs, this.pstmt, this.conn);
		}
		
		return productModel;
	}
	
	/**
		상품 등록 처리
		@param AdminProductModel
	**/
	public void insert(AdminProductModel productModel) {
		try {
			this.conn = mysql.dbConnect();
			this.pstmt = conn.prepareStatement(productInsert);
			
			this.pstmt.setString(1, productModel.getName());
			this.pstmt.setInt(2, productModel.getPrice());
			this.pstmt.setString(3, productModel.getDetail());
			this.pstmt.setInt(4, productModel.getStock());
			this.pstmt.setString(5, productModel.getImg());
			int n = this.pstmt.executeUpdate();
			
			if(n > 0) {
				System.out.println("insert 성공");
			}
			
		} catch (SQLException e) {
			System.err.println("insert err : " + e.getMessage());
		}
	}
	/**
		상품 수정 처리
		@param AdminProductModel
	**/
	public void update(AdminProductModel productModel) {
		try {
			this.conn = mysql.dbConnect();
			
			this.pstmt = this.conn.prepareStatement(productUpdate);
			this.pstmt.setString(1, productModel.getName());
			this.pstmt.setInt(2, productModel.getPrice());
			this.pstmt.setString(3, productModel.getDetail());
			this.pstmt.setInt(4, productModel.getStock());
			this.pstmt.setString(5, productModel.getImg());
			this.pstmt.setInt(6, productModel.getNum());
			int n = this.pstmt.executeUpdate();
			if(n > 0 ) {
				System.out.println("update success");
			}
			
		} catch (Exception e) {
			System.err.println("update err : " + e.getMessage());
		} finally {
			mysql.close(null, this.pstmt, this.conn);
		}
	}
	
	/**
		상품 삭제 처리
		@param 
	**/
	public void delete(int num) {
		try {
			this.conn = mysql.dbConnect();
			this.pstmt = this.conn.prepareStatement(productDelete);
			this.pstmt.setInt(1, num);
			
			int n = this.pstmt.executeUpdate();
			
			if(n > 0) {
				System.err.println("delete success");
			}
		} catch (SQLException e) {
			System.err.println("delete err : " + e.getMessage());
		}finally {
			mysql.close(null, this.pstmt, this.conn);
		}
	}
}
