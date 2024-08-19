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
/** SetAttribute.jave ("/set")에서 저장한 값들을 추출**/
@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		String ctxMsg = (String)ctx.getAttribute("context");
		String sessionMsg = (String)ctx.getAttribute("session");
		String requestMsg = (String)ctx.getAttribute("request");
		
		pw.print(ctxMsg + "<br>");
		pw.print(sessionMsg + "<br>");
		pw.print(requestMsg + "<br>");
	}

}

/**
	ServletContext		: Servlet이 소멸되기 전까지 유지
	HttpSession			: 동일 브라우저에서만 유지
	HttpServletRequest 	: 동일 URL에서만 유지
 **/
