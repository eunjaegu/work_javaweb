package com.ej.attr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 	ServletContext
 	HttpSession
 	HttpServletRequest
 **/
@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//내부 한글을 외부로 내보낼 때...인코딩 설정
		response.setContentType("text/html;charset=utf-8");
		
		//웹 브라우저에 출력할 내용
		PrintWriter pw = response.getWriter();
		String ctxMsg = "context에 바인딩!!";
		String sessionMsg = "session에 바인딩!!";
		String requestMsg = "request에 바인딩!!";
		
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		ctx.setAttribute("context", ctxMsg);
		session.setAttribute("session", sessionMsg);
		//매개변수가 전달되기 때문에 별도의 객체 생성 불필요!
		request.setAttribute("request", requestMsg);
		
		pw.print("바인딩을 수행합니다..");
	}	// doGet()

	
}
