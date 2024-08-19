package com.freeflux.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freeflux.beans.PollItemBean;
import com.freeflux.beans.PollListBean;
import com.freeflux.dao.PollMgr;

@WebServlet("/insert.do")
public class PollInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

// question=설문+테스트&item=ㅁ&item=ㄴ&item=ㄹ&item=ㅅ&item=ㄱ&item=ㅛ&item=ㅏ&item=ㄷ&sDate=2024-04-12&eDate=2024-04-15&type=1
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PollListBean plBean = new PollListBean();
		plBean.setQuestion(request.getParameter("question"));

		plBean.setSdate(request.getParameter("sDate"));
		plBean.setEdate(request.getParameter("eDate"));

		plBean.setType(Integer.parseInt(request.getParameter("type")));

		System.out.println("===========================");
		System.out.println(plBean);
		System.out.println("===========================");
		
		PollItemBean piBean = new PollItemBean();
		piBean.setItem(request.getParameterValues("item"));
		
		PollMgr pMgr = new PollMgr();
		boolean flagList = pMgr.insertPoll(plBean, piBean);
		
		String msg = "설문 추가에 실패 하였습니다.";
		String url = "pollInsert.jsp";
		
		if (flagList) {
			msg = "설문이 추가 되었습니다.";
			url = "default.jsp";
		}
		System.out.println(msg + " : " + url);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
//		doGet(request, response);
	}

}
