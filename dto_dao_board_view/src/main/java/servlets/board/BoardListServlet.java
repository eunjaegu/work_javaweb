package servlets.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDAO;
import model.board.BoardModel;
import util.PageNavigator;

@WebServlet("/board/boardListServlet")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardDAO boardDAO = null;
	
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNum = request.getParameter("pageNum");	// 페이지 번호
		String searchType = request.getParameter("searchType");	//검색 종류
		String searchText = request.getParameter("searchText");	// 검색어
		if (pageNum == null) {
			pageNum="1";	//전달된 페이지 번호가 없으면 1 // 맨 첫 페이지
		}
		if (searchText == null) {
			searchType="";
			searchText="";
		}
		
		// 모델 (BoardDAO의 메서드에게 전달할 데이터를 하나의 객체로)
		BoardModel boarModel = new BoardModel();
		boarModel.setPageNum(pageNum);
		boarModel.setPageNum(pageNum);
		boarModel.setPageNum(pageNum);
		
		//DAO (DB의 테이블에 접속하여 쿼리를 실행할 수 있는 메서드 보유 객체 생성)
		this.boardDAO=new BoardDAO();
		
		// 게시물 목록을 얻는 쿼리 실행(ArrayList<BoardModel>로 반환 받음)
		List<BoardModel> boardList = this.boardDAO.selectList(boarModel);
		
		// View(상세조회) 사용될 객체 설정
		request.setAttribute("totalCount", totalCount);
		
		// 목록 하단 페이지 번호출력을 위한 객체 생성
		PageNavigator pNavigator=new PageNavigator();
		
		//페이지 번호들을 문자열로 반환하는 메서드 호출
		String p_navi=pNavigator.getPageNavigator(totalCount, )
				boardModel.getListCount(),
				boardModel.getPagePerBlock(),
				Integer.parseInt(pageNum),
				searchType, searchText);		
	
		request.setAttribute("pageNavigator", p_navi); //페이지 번호들
		request.setAttribute("boardList", p_navi); //조회 결과 리스트
		request.setAttribute("boardModel", p_navi); //모델
		
		RequestDispatcher requestDispatcher=
				request.getRequestDispatcher("/board/boardList.jsp");
		requestDispatcher.forward(request, response);
		

}
}
