package com.freeflux.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/idcheck.do")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandler(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}

	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		String id = (String) request.getParameter("id");
		System.out.println("id = " + id);
		
		if(id.length() > 0 && id.length() < 12) {
			
			MemberDAO memberDAO = new MemberDAO();
			boolean overlappedID = memberDAO.overlappedID(id);
			System.out.println("overlappedID = " + overlappedID);
			
			if (overlappedID == true) {
				writer.print("not_usable");
			} else {
				writer.print("usable");
			}
		} else {
			writer.print("not_usable");
		}
	}

}
