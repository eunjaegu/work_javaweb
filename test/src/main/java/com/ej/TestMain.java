package com.ej;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestMain
 */
													// 요청명은 all 소문자가 많음.
@WebServlet(description = "ddd", urlPatterns = { "/TestMain" })
public class TestMain extends HttpServlet {
	private static final long serialVersionUID = 1L;	// 수정 및 삭제 불가
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestMain() {
        super();	// 부모의 생성자 호출하는 메서드로써 객체를 초기화함.
        // super 위에 코드 오면 안됨. 가장 먼저 써주어야함. SYS템. OUT. 등도 안됨.
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ //폼테그에서 전송방식 반드시 dOGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // 수정불가
		// TODO Auto-generated method stub	// dOGet는 매개변수 2개 request(외부에서 내부), response(내부에서 외부)
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//append 현재 글자에서 추가한다. 서블릿,jsp는 내부에서 처리함.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // 수정불가
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
