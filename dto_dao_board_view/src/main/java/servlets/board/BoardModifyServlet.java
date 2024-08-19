package servlets.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDAO;
import model.board.BoardModel;

@WebServlet("/board/boardModifyServlet")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardDAO boardDAO = null;
	
    public BoardModifyServlet() {
        super();
    }
	/**
	 * GET 접근 시 (수정폼 접근 시)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터
		int n=Integer.parseInt(request.getParameter("num"));
		
		// 모델
		BoardModel boardModel=new BoardModel();
		boardModel.setNum(n);
		
		//게시물 상세조회
		boardDAO=new BoardDAO();
		BoardModel boardOne=boardDAO.selectOne(boardModel);
		
		//View 사용될 객체 설정
		request.setAttribute("boardModel", boardOne);
		
		// View 보내기
		RequestDispatcher rd= request.getRequestDispatcher("boardModify.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 한글 파라미터 깨짐 처리
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터
		int n=Integer.parseInt(request.getParameter("num"));
		
		//모델
		BoardModel boardModel=new BoardModel();
		boardModel.setNum(n);
		boardModel.setSubject(request.getParameter("subject"));
		boardModel.setWriter(request.getParameter("Writer"));
		boardModel.setContents(request.getParameter("contents"));
		
		//게시물 수정 처리
		BoardDAO dao=new BoardDAO();
		dao.update(boardModel);
		
		//페이지 이동
		response.sendRedirect("boardListServlet");
		
	}


}
