package com.ej;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormTestServlet
 */
@WebServlet("/formtest") // 사용할땐 "/" 제거
public class FormTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//외부로부터 전달되는 값은 request 안으로 전달됨
		//request 내부 ID=ddd&pw=1234
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");		// id, pw 값을 request에 넣아줘야함.
		
		//다중값을 갖는 checkbox 는 getParameterValues() 를 이용!!!
		String[] chk = request.getParameterValues("chk");
		System.out.println(chk.length);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
//		request.setAttribute("ID", id); //setAttribute 가 없으면 Dispatcher로 받아야하며, result.jsp에 getAttribute는 못받음.!!
//		request.setAttribute("PW", pw);
		rd.forward(request, response);
		
		//System.out.println(id + " : " + pw);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
