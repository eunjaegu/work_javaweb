package dao.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.board.BoardModel;

/**
 * 게시판 DAO 클래스 (데이터베이스 질의문 실행)
 * @since 2020.02.05
 * @author freeflux
 */
public class BoardDAO {
	// 사용할 객체 초기화
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 데이터베이스 접속 설정 정보
	/** JDBC DRIVER 패키지 정보 */
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	/** 데이터베이스 URL */
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test";
	
	/** 데이터베이스 아이디 */
	private final String DB_ID = "root";
	
	/** 데이터베이스 암호 */
	private final String DB_PWD = "1234";
	
	/**
	 * 게시판 목록 조회
	 * @param boardModel
	 * @return
	 */
	public List<BoardModel> selectList(BoardModel boardModel) {

		int pageNum = Integer.parseInt(boardModel.getPageNum()); // "1" => 1
		int listCount = boardModel.getListCount();	// 한 페이지 게시물 갯수
		String searchType = boardModel.getSearchType();	//  검색 종류
		String searchText = boardModel.getSearchText();		// 검색어
		// 처음 호출 되었을 때 selectCount()에 의해 "" 값으로 초기화....
		
		String whereSQL = "";		// 조건 부분 쿼리만 저장
		List<BoardModel> boardList = null; 	// 결과 값들을 각각 BoardModel 객체로
		// 저장한 후, 한번에 반환시키키 위한 ArrayList<BoardModel> 을 저장
		// ArrayList는 List 인터페이스를 구현받았기 때문에..List<BoardModel> 타입도 가능
		
		
		
		try {
			// 검색어가 있는 경우에 대한 쿼리문 생성
			if (!"".equals(searchText)) {
				if ("ALL".equals(searchType)) {
					whereSQL = " WHERE SUBJECT LIKE CONCAT('%',?,'%') OR WRITER LIKE CONCAT('%',?,'%') OR CONTENTS LIKE CONCAT('%',?,'%') ";
				} else if ("SUBJECT".equals(searchType)) {
					whereSQL = " WHERE SUBJECT LIKE CONCAT('%',?,'%') ";
				} else if ("WRITER".equals(searchType)) {
					whereSQL = " WHERE WRITER LIKE CONCAT('%',?,'%') ";
				} else if ("CONTENTS".equals(searchType)) {
					whereSQL = " WHERE CONTENTS LIKE CONCAT('%',?,'%') ";
				}
			}
			
			// 데이터베이스 객체 생성
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			// 게시물 목록 조회 (목록화면에 필요한 필드만...)
			String end=" ORDER BY NUM DESC LIMIT ?, ?"; // 페이지에서 ?번호에서 ?까지
			String first="SELECT NUM, SUBJECT, WRITER, REG_DATE, HIT FROM board_table ";
			String query=first + whereSQL + end;
			this.pstmt = this.conn.prepareStatement(query);
			
			if (!"".equals(whereSQL)) {		// 검색 쿼리가 있을 경우에만
				
				if ("ALL".equals(searchType)) {				// 전체검색일 경우 ? 다섯 개
					this.pstmt.setString(1, searchText);
					this.pstmt.setString(2, searchText);
					this.pstmt.setString(3, searchText);
					this.pstmt.setInt(4, listCount * (pageNum-1));	// 페이지의 시작 번호
					this.pstmt.setInt(5, listCount);							// 조회 갯수
				} else {
					this.pstmt.setString(1, searchText);			// 그 외의 검색일 경우 ? 세 개
					this.pstmt.setInt(2, listCount * (pageNum-1)); //listCount=10 한페이지 게시물 갯수
					this.pstmt.setInt(3, listCount);			
				}
			} else {	// 검색 쿼리(검색어)가 없을 경우
				this.pstmt.setInt(1, listCount * (pageNum-1));	// 페이지의 시작 번호
				this.pstmt.setInt(2, listCount);							// 조회 갯수
			}	
			// if (!"".equals(whereSQL)) { ~~ } else { ~~ } END
			
			
			// 조회 실행
			this.rs = this.pstmt.executeQuery();
			
			// LIST 객체에 저장하기 위한 객체 생성
			boardList = new ArrayList<BoardModel>(); 

			while(this.rs.next()) {
				boardModel = new BoardModel();	// 각 레코드를 하나의 객체로
				boardModel.setNum(this.rs.getInt("NUM"));
				boardModel.setSubject(this.rs.getString("SUBJECT"));
				boardModel.setWriter(this.rs.getString("WRITER"));
				boardModel.setHit(this.rs.getInt("HIT"));
				boardModel.setRegDate(this.rs.getString("REG_DATE"));
				
				boardList.add(boardModel);	// ArrayList에 추가
			}	// while() END
		} catch (Exception e) {		// SQLException
			e.printStackTrace();		// System.out.println(e.getMessage())
		} finally {
			// 사용한 객체 종료
			close(this.rs, this.pstmt, this.conn);
		}
		return boardList;
	}
	
	/**
	 * 게시글 총 갯수 조회 (완성)
	 * @param boardModel //외부에서 들어온다 @param
	 * @return
	 */
	public int selectCount(BoardModel boardModel) {
		int totalCount = 0;	// 전체 조회 또는 검색어를 통한 조회 시 총 레코드 갯수 저장
		String searchType = boardModel.getSearchType();
		String searchText = boardModel.getSearchText();
		String whereSQL = "";		// select 쿼리의 조건 부분만 저장
		
		try {
			// 검색어 쿼리문 생성
			if (!"".equals(searchText)) {		// 검색어가 있을 경우에만
				
				if ("ALL".equals(searchType)) {		// 전체 검색일 경우
					whereSQL = " WHERE SUBJECT LIKE CONCAT('%',?,'%') OR WRITER LIKE CONCAT('%',?,'%') OR CONTENTS LIKE CONCAT('%',?,'%') ";
				} else if ("SUBJECT".equals(searchType)) {		// 제목 검색일 경우
					whereSQL = " WHERE SUBJECT LIKE CONCAT('%',?,'%') ";
				} else if ("WRITER".equals(searchType)) {		// 작성자 검색일 경우
					whereSQL = " WHERE WRITER LIKE CONCAT('%',?,'%') ";
				} else if ("CONTENTS".equals(searchType)) {		// 내용 검색일 경우
					whereSQL = " WHERE CONTENTS LIKE CONCAT('%',?,'%') ";
				}
			}
			// 데이터베이스 객체 생성 (dbConnect() 메서드 호출)
			// dbConnect() 메서드 없을 경우에만...
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			// 게시물의 총 수를 얻는 쿼리 실행
			String query="SELECT COUNT(NUM) AS TOTAL FROM board_table " + whereSQL;
			this.pstmt = this.conn.prepareStatement(query);
			if (!"".equals(whereSQL)) {		// 검색어가 있을 경우에만
				if ("ALL".equals(searchType)) {		// 전체 검색일 경우 ? 세 개
					this.pstmt.setString(1, searchText);
					this.pstmt.setString(2, searchText);
					this.pstmt.setString(3, searchText);
				} else {
					this.pstmt.setString(1, searchText);		// 그 외의 검색일 경우 ? 한 개 
				}
			}
			this.rs = this.pstmt.executeQuery();	// 쿼리 실행
			if (this.rs.next()) {
				totalCount = this.rs.getInt("TOTAL");	//  결과 필드명을 이용
			}
		} catch (Exception e) {		// SQLException   
			e.printStackTrace();		// System.out.println(e.getMessage());  
		} finally {
			// 사용한 객체 종료 (나중에 사용한 것 부터 종료)
			this.close(this.rs, this.pstmt, this.conn); 
		}
		return totalCount;	// 결과 값 반환...(BoardListServlet 의 doGet()에게)
	}	// selectCount() END 
	
	/**
	 * 게시판 상세 조회
	 * @param boardModel
	 * @return
	 */
	public BoardModel selectOne(BoardModel boardModel) {
		try {
			// 데이터베이스 객체 생성
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			// 게시물 상세 조회 쿼리 실행 
			String query="SELECT NUM, SUBJECT, CONTENTS, WRITER, HIT, REG_DATE "
					+ "FROM board_table WHERE NUM = ?";
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, boardModel.getNum());
			this.rs = this.pstmt.executeQuery();
			
			// 값이 존재한다면 
			if (this.rs.next()) {
				boardModel.setNum(this.rs.getInt("NUM"));
				boardModel.setSubject(this.rs.getString("SUBJECT"));
				boardModel.setContents(this.rs.getString("CONTENTS"));
				boardModel.setWriter(this.rs.getString("WRITER"));
				boardModel.setHit(this.rs.getInt("HIT"));
				boardModel.setRegDate(this.rs.getString("REG_DATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 객체 종료
			close(this.rs, this.pstmt, this.conn);
		}
		return boardModel;
	}
	
	/**
	 * 게시판 등록 처리
	 * @param boardModel
	 */
	public void insert(BoardModel boardModel) {
		try {
			// 데이터베이스 객체 생성
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			String first ="INSERT INTO board_table (SUBJECT, WRITER, CONTENTS, IP, HIT, REG_DATE, MOD_DATE) ";
			String last =" VALUES (?, ?, ?, ?, 0, NOW(), NOW())";
			String query=first+last;
			this.pstmt = this.conn.prepareStatement(query);
			
			//for(int i=12; i<112; i++){
				this.pstmt.setString(1, boardModel.getSubject());
				this.pstmt.setString(2, boardModel.getWriter());
				this.pstmt.setString(3, boardModel.getContents());
				this.pstmt.setString(4, boardModel.getIp());
				this.pstmt.executeUpdate();
			//}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 객체 종료
			close(null, this.pstmt, this.conn);
		}
	}
	
	/**
	 * 게시판 수정 처리
	 * @param boardModel
	 */
	public void update(BoardModel boardModel) {
		try {
			// 데이터베이스 객체 생성
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			String query="update board_table set subject=?, writer=?, contents=?, mod_date=now()  where num=?";

			this.pstmt=this.conn.prepareStatement(query);
			this.pstmt.setString(1, boardModel.getSubject());
			this.pstmt.setString(2, boardModel.getWriter());
			this.pstmt.setString(3, boardModel.getContents());
			this.pstmt.setInt(4, boardModel.getNum());
			int n=this.pstmt.executeUpdate();
			
			if(n >0) {
				System.out.println("=> UPDATE  SUCCESS !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 객체 종료
			close(null, this.pstmt, this.conn);
		}
	}
	
	/**
	 * 게시판 조회수 증가 수정 처리
	 * @param boardModel
	 */
	public void updateHit(BoardModel boardModel) {
		try {
			// 데이터베이스 객체 생성
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			// 조회수 증가 쿼리 실행
			String query="UPDATE board_table SET HIT=HIT+1 WHERE NUM = ?";
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, boardModel.getNum());
			this.pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 객체 종료
			close(null, this.pstmt, this.conn);
		}
	}
	
	/**
	 * 게시판 삭제 처리
	 * @param boardModel
	 */
	public void delete(BoardModel boardModel) {
		try {
			// 데이터베이스 객체 생성
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			// 삭제 쿼리 실행
			String query="delete from board_table where num=?";

			this.pstmt=this.conn.prepareStatement(query);
			this.pstmt.setInt(1, boardModel.getNum());
			int n=this.pstmt.executeUpdate();
			if(n >0) {
				System.out.println("=> DELETE  SUCCESS !!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 객체 종료
			close(null, this.pstmt, this.conn);
		}
	}
	
	/**
	 * 사용한 객체를 닫음
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




