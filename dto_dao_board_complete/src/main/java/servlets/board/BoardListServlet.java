package servlets.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.PageNavigator;

import model.board.BoardModel;
import dao.board.BoardDAO;

/**
 * 게시판 목록 페이지 서블릿 클래스
 * @since 2024.04.02
 * @author freeflux
 */
@WebServlet("/board/boardListServlet")
public class BoardListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/** BOARD DAO */
	private BoardDAO boardDAO = null;
    
    public BoardListServlet() {
        super();
    }

	/**
	 * GET 접근 시 (목록 조회 접근 시)
	 * 1. 처음 요청이 들어왔을 때 (페이지번호, 검색 종류, 검색어 없슴)
	 * 2. 검색 종류와 검색어를 입력한 후, 검색 버튼을 클릭 했을 때 (페이지 번호 없슴)
	 * 3. 페이지 번호를 클릭했을 때 (검색 종류, 검색어 없슴)
	 * 4. 글쓰기 후, 글 수정 후, 글 삭제 후  (페이지번호, 검색 종류, 검색어 없슴)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		// 전달된 파라미터를 이용하여 값 추출(처음에는 전달되는 값이 없슴)
		String pageNum = request.getParameter("pageNum");  // 페이지 번호
		String searchType = request.getParameter("searchType"); // 검색 종류
		String searchText = request.getParameter("searchText");  // 검색어
		if (pageNum == null) {
			pageNum = "1";			// 전달된 페이지 번호가 없으면 1
		}
		if (searchText == null) {
			searchType = "";			// 전달된 검색 종류가 없으면 "" 를 이용하여 초기화
			searchText = "";			// 전달된 검색어가 없으면  "" 를 이용하여 초기화
		}

		// 모델 (BoardDAO의 메서드에게 전달할 데이터를 하나의 객체로 )
		BoardModel boardModel = new BoardModel();
		boardModel.setPageNum(pageNum);
		boardModel.setSearchType(searchType);
		boardModel.setSearchText(searchText);
		
		// DAO (DB의 테이블에 접속하여 쿼리를 실행할 수 있는 메서드 보유 객체 생성) 
		this.boardDAO = new BoardDAO();
		
		// 게시물 총 수 (목록 아래에 페이지 번호를 계산하기 위한 메서드 호출) 
		int totalCount = this.boardDAO.selectCount(boardModel);
		
		// 게시물 목록을 얻는 쿼리 실행 (결과값을 ArrayList<BoardModel> 로 반환 받음)
		List<BoardModel> boardList = this.boardDAO.selectList(boardModel);
		
		// View 사용될 객체 설정
		request.setAttribute("totalCount", totalCount);
		
		// 목록 하단 페이지 번호출력을 위한 객체 생성
		PageNavigator pNavigator=new PageNavigator();
		
		// 페이지 번호들을 문자열로 반환하는 메서드 호출
		/* 반환 결과의 예
		 * 		 1  2  3  4  5  6  7  8  9  10  >  >>
		 * << 1  2  3  4  5  6  7  8  9  10  >  >>
		*/
		String p_navi=pNavigator.getPageNavigator(totalCount, 
																		boardModel.getListCount(), 
																		boardModel.getPagePerBlock(), 
																		Integer.parseInt(pageNum), 
																		searchType, searchText);
				
		request.setAttribute("pageNavigator", p_navi);   	// 페이지 번호들
		request.setAttribute("boardList", boardList);			// 조회 결과 리스트
		request.setAttribute("boardModel", boardModel);	// 모델
		
		
		// View 보내기
		RequestDispatcher requestDispatcher =
			request.getRequestDispatcher("/board/boardList.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
