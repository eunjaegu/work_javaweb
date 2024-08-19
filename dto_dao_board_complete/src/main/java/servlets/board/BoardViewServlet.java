package servlets.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardModel;

import dao.board.BoardDAO;

/**
 * 게시판 상세 조회 서블릿 클래스
 * @since 2024.04.02
 * @author freeflux
 */
@WebServlet("/board/boardViewServlet")
public class BoardViewServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/** BOARD DAO */
	private BoardDAO boardDAO = null;
	
    public BoardViewServlet() {
        super();
    }

	/**
	 * GET 접근 시 (상세 조회 접근 시)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// 파라미터
		String num = request.getParameter("num");
		String pageNum = request.getParameter("pageNum");
		String searchType = request.getParameter("searchType");
		String searchText = request.getParameter("searchText");

		// 모델
		BoardModel boardModel = new BoardModel();
		boardModel.setNum(Integer.parseInt(num));
		boardModel.setPageNum(pageNum);
		boardModel.setSearchType(searchType);
		boardModel.setSearchText(searchText);
		
		// 게시물 상세 조회
		this.boardDAO = new BoardDAO();
		boardModel = this.boardDAO.selectOne(boardModel);
		
		// 게시물 조회수 증가
		this.boardDAO.updateHit(boardModel);
		
		// View 사용될 객체 설정
		request.setAttribute("boardModel", boardModel);
		
		// View 보내기
		RequestDispatcher requestDispatcher =
			request.getRequestDispatcher("/board/boardView.jsp");
		requestDispatcher.forward(request, response);
	}

}
