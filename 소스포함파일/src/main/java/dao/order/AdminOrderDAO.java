package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.mall.MySQLConnector;
import db.mall.AdminQuerys;
import model.mall.AdminOrderModel;

public class AdminOrderDAO implements AdminQuerys{

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private MySQLConnector datasource = null;
	private ResultSet rs = null;

	public AdminOrderDAO() {
		datasource = new MySQLConnector();
	}

	/**
	 * 주문정보 목록 조회
	 * 
	 * @param AdminMemModel
	 * @return
	 */
	public ArrayList<AdminOrderModel> productNameAll() {
		ArrayList<AdminOrderModel> orderList = new ArrayList<AdminOrderModel>();

		try {
			this.conn = datasource.dbConnect();
			PreparedStatement pstmt = conn.prepareStatement(orderAll);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AdminOrderModel orderModel = new AdminOrderModel();
				orderModel.setNo(this.rs.getInt("no"));
				orderModel.setId(this.rs.getString("id"));
				orderModel.setProductname(this.rs.getString("name"));
				orderModel.setQuantity(this.rs.getInt("quantity"));
				orderModel.setDate(this.rs.getString("date"));
				orderModel.setState(this.rs.getString("state"));
	

				orderList.add(orderModel);
			}
		} catch (Exception e) {
			System.err.println("productName All err : " + e.getMessage());
		} finally {
			datasource.close(rs, pstmt, conn);
		}

		return orderList;
	}

	
	/**
	 * 주문 상세 조회
	 * 
	 * @param no
	 * @return
	 */
	public AdminOrderModel selectOne(int no) {
		AdminOrderModel adminorderModel = null;
		try {
			this.conn = datasource.dbConnect();
			this.pstmt = this.conn.prepareStatement(orderOne);
			this.pstmt.setInt(1, no);
			this.rs = this.pstmt.executeQuery();

			if (this.rs.next()) {
				adminorderModel = new AdminOrderModel();
				adminorderModel.setNo(this.rs.getInt("no"));
				adminorderModel.setId(this.rs.getString("id"));
				adminorderModel.setProductname(this.rs.getString("name"));
				adminorderModel.setQuantity(this.rs.getInt("quantity"));
				adminorderModel.setDate(this.rs.getString("date"));
				adminorderModel.setState(this.rs.getString("state"));
				adminorderModel.setProductno(this.rs.getInt("productNo"));
				adminorderModel.setPrice(this.rs.getInt("price"));
				adminorderModel.setStock(this.rs.getInt("stock"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 객체 종료
			datasource.close(this.rs, this.pstmt, this.conn);
		}
		return adminorderModel;
	}
	
	/**
	 * 관리자 주문 상태 수정
	 * @param adminordermModel
	 */
	public void update(AdminOrderModel adminordermModel) {
		try {
			conn = datasource.dbConnect();
			this.pstmt = this.conn.prepareStatement(updateOrder);
			    
			this.pstmt.setString(1, adminordermModel.getState());
			this.pstmt.setInt(2, adminordermModel.getNo());
			   
	
			int n = this.pstmt.executeUpdate();
			System.out.println(adminordermModel.toString());
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
	 * 주문 삭제 처리
	 * 
	 * @param boardModel
	 */
	public void delete(AdminOrderModel boardModel) {
		try {
			conn = datasource.dbConnect();

			this.pstmt = this.conn.prepareStatement(deleteOrder);
			this.pstmt.setInt(1, boardModel.getNo());
			int n = this.pstmt.executeUpdate();
			if (n > 0) {
				System.out.println("=> DELETE  SUCCESS !!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			datasource.close(null, this.pstmt, this.conn);
		}
	}

} // class END
