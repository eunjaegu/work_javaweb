package com.ej.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ej.db.MemberController;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/main")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		String _id = "admin";	// form_test 프로젝트에서 id 쓰고 있기에
//		String _pw = "1234";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//		String result ="";														// 홈페이지에 로그인 되었습니다. 아이디 또는 비밀번호 확인!!! 출력을 위해
//		if(_id.equals(id) && _pw.equals(pw)) {
//			System.out.println("로그인 되었습니다.");
//			result = "success"; 
//		}else {
//			System.out.println("아이디 또는 비밀번호 확인!!!");	
//			result = "fail"; 
////			RequestDispatcher rd = request.getRequestDispatcher("join.jsp");	// join.jsp에 담아 보낼게 없어 바로 forward(화면넘김) // 여러개 보내려면 이거 사용
////			rd.forward(request, response);										//request.getRequestDispatche와 response.sendRedirect 둘다 사요 가능
//		}
		
		MemberController mc = new MemberController();
		String result = mc.join(id, pw);
		response.sendRedirect("join.jsp?RESULT="+ result);						// 단순 데이터 이동 join , 마지막 result 값을 join으로 이동
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
