package com.ej.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberController extends MySQLConnector {	//접속과 close 필요함
	/** MySQLConnector로 부터 상속받은 변수 및 메서드 **/
	//public Connection connector = null;
	//public void connect() {}
	//public void close() {}
	public MemberController() {
		connect();	//DB 접속 완료
	
	}
	
	/** id/pw를 비교한 결과 문자열을 DispatcherServlet에게 반환 **/
	// 로그인 성공 : SUCCESS / 실패 : FAIL
	public String join(String id, String pw) {
		String query = "select * from member where id=? and pw=?";
		
		//close() 해야할 객체 선언시, 기본값을 null로 설정!!
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String result=null;	// String 변수 선언 시, 기본값을 null 로 설정하면 추후 비교가 편리.
		//숫자 관련 변수 선언 시 기본값을 0으로 설정!!
		
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery(); //executeQuery() Result 객체 반환
			// 결과 : 1 record 또는 0 record <= rs.next() : true면 (1) / false (0)
			
//			String result="";
			if (rs.next()) {
				result = "SUCCESS";		// 방법 1
//		return "SUCCESS";		// 방법 2 = 제거하고 return 으로 변경
			}else {
				result="Fail";
//		return "Fail";
			}
		return result;

		} catch (Exception e) {
			System.err.println("JOIN() ERR : " + e.getMessage());
		}finally {
			close(pstmt, rs);
			close();	// Connection close
		}
		
		
		return result;
	}
}	//end
