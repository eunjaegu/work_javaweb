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
 * 게시판 수정폼, 수정처리 서블릿 클래스
 * @since 2024.04.02
 * @author freeflux
 */
@WebServlet("/board/boardModifyServlet")
public class BoardModifyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/** BOARD DAO */
	private BoardDAO boardDAO = null;
    
    public BoardModifyServlet() {
        super();
    }

	/**
	 * GET 접근 시 (수정폼 접근 시)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// 파라미터
		int n=Integer.parseInt(request.getParameter("num"));


		// 모델
		BoardModel boardModel=new BoardModel();
		boardModel.setNum(n);

		// 게시물 상세 조회
		boardDAO=new BoardDAO();
		BoardModel boardOne=boardDAO.selectOne(boardModel);

		// View 사용될 객체 설정
		request.setAttribute("boardModel", boardOne);

		// View 보내기
		RequestDispatcher rd=request.getRequestDispatcher("boardModify.jsp");
		rd.forward(request, response);
	}

	/**
	 * POST 접근 시 (수정처리 접근 시)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// POST 한글 파라미터 깨짐 처리
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터
		int n=Integer.parseInt(request.getParameter("num"));

		// 모델
		BoardModel boardModel=new BoardModel();
		boardModel.setNum(n);
		boardModel.setSubject(request.getParameter("subject"));
		boardModel.setWriter(request.getParameter("writer"));
		boardModel.setContents(request.getParameter("contents"));


		// 게시물 수정 처리
		BoardDAO dao=new BoardDAO();
		dao.update(boardModel);
		
		// 페이지 이동	
		response.sendRedirect("boardListServlet");
	}

}
