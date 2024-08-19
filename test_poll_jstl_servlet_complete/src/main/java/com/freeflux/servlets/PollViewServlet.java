package com.freeflux.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freeflux.beans.PollItemBean;
import com.freeflux.beans.PollListBean;
import com.freeflux.dao.PollMgr;
import com.freeflux.util.ColorRatio;

@WebServlet("/view.do")
public class PollViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** /view.do?num=12 **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int num = 0;
		if (request.getParameter("num") != null) {
			num = Integer.parseInt(request.getParameter("num"));
		}
		
		PollMgr pMgr = new PollMgr();
		
		int sum = pMgr.sumCount(num);
		
		List<PollItemBean> alist = pMgr.getView(num);	//리스트 목록
		PollListBean plBean = pMgr.getList(num);
		
		for(PollItemBean plitem : alist) {				// item을 하나씩 꺼내서
			plitem.sethRGB(ColorRatio.hexColor());		//item 에 색깔을 임의로 넣어주고
			plitem.setRatio(ColorRatio.ratio(plitem.getCount(), sum));
			
			System.out.println("--------------");
			System.out.println(plitem);
			System.out.println("--------------");
		}
		
		request.setAttribute("sum", sum);			// 합
		request.setAttribute("alist", alist);	 // 선택한 설문의 아이템 리스트
		request.setAttribute("plBean", plBean);  //  선택한 설문 (제목)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pollView.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
