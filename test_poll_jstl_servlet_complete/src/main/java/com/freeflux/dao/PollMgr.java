package com.freeflux.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.freeflux.beans.PollItemBean;
import com.freeflux.beans.PollListBean;
import com.freeflux.util.DBConnectionMgr;

public class PollMgr {

	private DBConnectionMgr pool;

	public PollMgr() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/** tblPollList 테이블의 가장 큰 num 값을 추출 **/
	public int getMaxNum() {
		Connection connector = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int maxNum = 0;
		try {
			connector = pool.getConnection();
			sql = "select max(num) from tblPollList";
			pstmt = connector.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				maxNum = rs.getInt(1);//
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connector, pstmt, rs);
		}
		return maxNum;
	}

	
	
	/** tblPollList 테이블에 새로운 설문 추가 **/
	public boolean insertPoll(PollListBean plBean, PollItemBean piBean) {
		Connection connector = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		String sql = null;
		try {
			connector = pool.getConnection();
			sql = "insert into tblPollList (question,sdate,edate,wdate,type) " + " values (?,?,?,now(),?)";
			pstmt = connector.prepareStatement(sql);
			pstmt.setString(1, plBean.getQuestion());
			pstmt.setString(2, plBean.getSdate());
			pstmt.setString(3, plBean.getEdate());
			pstmt.setInt(4, plBean.getType());
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				sql = "insert into tblPollItem values(?,?,?,?)";
				pstmt.close();
				
				pstmt = connector.prepareStatement(sql);
				String item[] = piBean.getItem();
				int itemnum = getMaxNum();
				int j = 0;
				for (int i = 0; i < item.length; i++) {
					if (item[i] == null || item[i].equals("")) {
						break;
					}
					pstmt.setInt(1, itemnum);
					pstmt.setInt(2, i);
					pstmt.setString(3, item[i]);
					pstmt.setInt(4, 0);
					j = pstmt.executeUpdate();		//쿼리반복, 쿼리같아서
				}
				if (j > 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connector, pstmt);
		}
		return flag;
	}

	
	
	/** tblPollList 테이블의 모든 레코드 추출 **/
	public ArrayList<PollListBean> getAllList() {
		Connection connector = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		ArrayList<PollListBean> alist = new ArrayList<PollListBean>();
		try {
			connector = pool.getConnection();
			sql = "select * from tblPollList order by num desc";
			pstmt = connector.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PollListBean plBean = new PollListBean();
				plBean.setNum(rs.getInt("num"));
				plBean.setQuestion(rs.getString("question"));
				plBean.setSdate(rs.getString("sdate"));
				plBean.setEdate(rs.getString("edate"));
				alist.add(plBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connector, pstmt, rs);
		}
		return alist;
	}

	
	
	/** tblPollList 테이블의 모든 레코드, 하나의 레코드 추출 **/
	public PollListBean getList(int num) {
		Connection connector = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		PollListBean plBean = new PollListBean();
		try {
			connector = pool.getConnection();
			if (num == 0) {
				sql = "select * from tblPollList order by num desc";
			}else {
				sql = "select * from tblPollList where num=" + num;
			}
			pstmt = connector.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				plBean.setNum(rs.getInt("num"));
				plBean.setQuestion(rs.getString("question"));
				plBean.setType(rs.getInt("type"));
				plBean.setActive(rs.getInt("active"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connector, pstmt, rs);
		}
		return plBean;
	}

	
	
	/** tblPollItem 테이블의 item 추출 **/
	public ArrayList<String> getItem(int num) {
		Connection connector = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		ArrayList<String> alist = new ArrayList<String>();
		try {
			connector = pool.getConnection();
			
			if (num == 0) {
				num = getMaxNum();
			}
			
			sql = "select item from tblPollItem where listnum = ?";
			pstmt = connector.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				alist.add(rs.getString(1));
				System.out.println("====>" + rs.getString(1) +  "<====");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connector, pstmt, rs);
		}
		return alist;
	}

	
	
	/** tblPollItem 테이블의 count 1 증가 **/
	public boolean updatePoll(int num, String[] itemnum) {
		Connection connector = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		String sql = null;
		try {
			connector = pool.getConnection();
			sql = "update tblPollItem set count=count+1 where listnum=? and itemnum = ?";
			pstmt = connector.prepareStatement(sql);
			if (num == 0)
				num = getMaxNum();
			for (int i = 0; i < itemnum.length; i++) {
				if (itemnum[i] == null || itemnum[i].equals(""))
					break;
				pstmt.setInt(1, num);
				pstmt.setInt(2, Integer.parseInt(itemnum[i]));
				int j = pstmt.executeUpdate();
				if (j > 0)
					flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connector, pstmt);
		}
		return flag;
	}

	
	
	/** tblPollItem 테이블의 item,count 추출 **/
	public ArrayList<PollItemBean> getView(int num) {	// 설문번호값
		
		Connection connector = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		ArrayList<PollItemBean> alist = new ArrayList<PollItemBean>();
		
		try {
			connector = pool.getConnection();
			sql = "select item,count from tblPollItem where listnum=?";
			pstmt = connector.prepareStatement(sql);
			
			if (num == 0) {
				pstmt.setInt(1, getMaxNum());
			}else {
				pstmt.setInt(1, num);
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PollItemBean piBean = new PollItemBean();	//item 객체 (색깔 넘버 등 다 넣어주기 위해)
				
				String item[] = new String[1];	// 선언
				item[0] = rs.getString(1);		//아이템 명getString (1) 여기서 1은 item(sql 순서대로)
				piBean.setItem(item);			// string  배열에 넣음 0번에 넣음
				piBean.setCount(rs.getInt(2));	// 카운터에 넣고
				
				alist.add(piBean);
				System.out.println(piBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connector, pstmt, rs);
		}
		
		return alist;
	}

	
	/** tblPollItem 테이블의 count 합 추출 **/
	public int sumCount(int num) {
		Connection connector = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		try {
			connector = pool.getConnection();
			sql = "select sum(count) from tblPollItem where listnum=?";
			pstmt = connector.prepareStatement(sql);
			if (num == 0)
				pstmt.setInt(1, getMaxNum());
			else
				pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connector, pstmt);
		}
		return count;
	}
}