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


@WebServlet("/board/boardWriteServlet")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private BoardDAO boardDAO=null;
	
    public BoardWriteServlet() {
        super();
    }
    
    /**
	 * GET 접근 시 (등록 폼 접근 시)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//View 보내기
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/board/boardWrite.JSP");
		requestDispatcher.forward(request, response);
		
	}
	
	/**
	 * POST 접근 시 (등록처리 접근 시)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//파라미터
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		String ip = request.getRemoteAddr();
		
		//모델
		BoardModel boardModel = new BoardModel();
		boardModel.setSubject(subject);
		boardModel.setWriter(writer);
		boardModel.setContents(contents);
		boardModel.setIp(ip);
		
		//게시물 등록
		this.boardDAO=new BoardDAO();
		this.boardDAO.insert(boardModel);
		
		//페이지이동
		response.sendRedirect("boardListServlet");
		
	}

	
}
