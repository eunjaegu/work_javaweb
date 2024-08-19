package com.ej.guest.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ej.guest.controller.DeleteController;
import com.ej.guest.controller.DetailController;
import com.ej.guest.controller.InsertController;
import com.ej.guest.controller.ListController;
import com.ej.guest.controller.UpdateController;

@WebServlet("/guest")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	//매개변수 request, response 부모로부터 상속받음.
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath()); //외부로 내보냄. 이 코드있으면 아래 코드 실행 못함.
		//response //append : 글자추가 

		RequestDispatcher rd = null;	// 전송할 수 있는 class가 필요함.
		String cmd = null;	
		String status = "";// 글목록에서 제목 클릭 / 글상세에서 수정화면이동 클릭	// 객체 생성
		if (request.getParameter("command") != null) {
			cmd = request.getParameter("command");
			switch (cmd) {
			case "L": // 글목록
				ListController list = new ListController();	// 실
				list.list();
				rd = request.getRequestDispatcher("list.jsp");
				//request.setAttribute("",);
				rd.forward(request, response);
				
				break;

			case "W": // 글쓰기(저장버튼)
				InsertController insert = new InsertController();
				insert.insert();
				
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
				
				break;

			case "D": // 글상세
				status = request.getParameter("status");// 받겠다.
				
				DetailController detail = new DetailController(); //객체생성
				detail.detail();	//객체 안에 있는 클래스 실행
				
				if(status.equals("detail")) {
					rd = request.getRequestDispatcher("detail.jsp");
				} else{
					rd = request.getRequestDispatcher("modify.jsp");
				}
				rd.forward(request, response);
				
				break;

			case "U": // 글수정
				UpdateController update = new UpdateController();
				update.update();
				
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);

				break;

			case "DEL": // 글삭제
				DeleteController delete = new DeleteController();
				delete.delete();
				
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
				
				break;
			} // switch (cmd) END
		} // if () END
	} // doGet() END

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
