package com.ej.urls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 데이터 추출 전에 사용~
		request.setCharacterEncoding("UTF-8"); 		//utf-8로도 가능.
		
		//내부 데이터 내보내기 전에 사용!!!
		response.setContentType("text/html;charset=utf-8");
		
		/**요청 주소의 다양한 값들...**/
		String context = request.getContextPath();
		String url = request.getRequestURI().toString();
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Servlet Test</title>");
		out.print("</head>");
		out.print("<body bgcolor='yellow'>");
		out.print("<b>Servlet Test 입니다.");
		
		out.print("컨텍스트 이름 : " + context);	// 컨텍스트 이름(프로젝트명)
		out.print("전체 경로 : " + url);			// 전체 URL
		out.print("매핑 이름" + mapping);			// 요청 UrlPattern
		out.print("URI : " + uri);					// 프로젝트명/요청URI
		
		out.print("</body>");
		out.print("</html>");

	}	// doGet()

}
