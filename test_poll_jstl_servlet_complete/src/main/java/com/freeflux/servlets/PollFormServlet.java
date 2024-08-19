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

@WebServlet("/form.do")
public class PollFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;

		if (!(request.getParameter("num") == null || request.getParameter("num").equals(""))) {
			num = Integer.parseInt(request.getParameter("num"));
		}

		PollMgr pMgr = new PollMgr();
		PollListBean plBean = pMgr.getList(num);
		List<String> alist = pMgr.getItem(num);
		
		request.setAttribute("plBean", plBean);
		request.setAttribute("alist", alist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("pollList.jsp");
		dispatcher.forward(request, response);

	}

	/** 설문폼(pollForm.jsp) 투표 버튼 클릭 **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int num = Integer.parseInt(request.getParameter("num"));
		String[] itemnum = request.getParameterValues("itemnum");

		PollMgr pMgr = new PollMgr();
		boolean flag = pMgr.updatePoll(num, itemnum);

		String msg = "투표가 등록되지 않습니다.";
		if (flag) {
			msg = "투표가 정상적으로 등록되었습니다.";
		}
		System.out.println(msg);  // 데이터 수정 확인
		
	
		request.setAttribute("msg", msg);   
		RequestDispatcher dispatcher = request.getRequestDispatcher("default.jsp");
		dispatcher.forward(request, response);
	}

}
