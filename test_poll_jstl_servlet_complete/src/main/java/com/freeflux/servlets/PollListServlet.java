package com.freeflux.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freeflux.beans.PollListBean;
import com.freeflux.dao.PollMgr;

@WebServlet("/list.do")
public class PollListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/** default.jsp : <c:redirect url="poll/list.do" /> **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = 0;

		if (!(request.getParameter("num") == null || request.getParameter("num").equals(""))) {
			num = Integer.parseInt(request.getParameter("num"));
		}

		PollMgr pMgr = new PollMgr();
		PollListBean plBean = pMgr.getList(num);			//번호
		List<String> tlist = pMgr.getItem(num);				//폼
		List<PollListBean> alist = pMgr.getAllList();		//리스트

		request.setAttribute("plBean", plBean);
		request.setAttribute("tlist", tlist);
		request.setAttribute("alist", alist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/pollList.jsp");
		dispatcher.forward(request, response);
	}

	/**  **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		doGet(request, response);
	}

}
