package com.ej.attr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ej.listen.LoginImpl;

@WebServlet(description = "전송된 ID와 비밀번호를 저장", urlPatterns = {"/loginTest"})
public class LoginTestID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Sessoin 객체
		HttpSession session = request.getSession();
		//request.getSessoin() 은 기존 Session이 없을 경우 생성, 있을 경우 기존 Session을 반환
		
		//2. 전달된 파라미터
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		
		// 3. Listener 객체
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		
		// 4. Session 객체가 새로운 객체인지...(이벤트발생시킴)
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}
		
		// 5. 결과 브라우저로 출력(JSP 파일로... 지금은 생략)
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<script type='text/javascript'>");
		out.print("setTimeout('history.go(0);', 2000)");
		out.print("</script></head>");
		out.print("<body>");
		out.print("아이디는" + loginUser.user_id + "<br>");
		out.print("총 접속자 수는" + LoginImpl.total_user + "<br>");
		out.print("</body>");
		out.print("</html>");
		
	}
	
}	// doPost()

/** <script type="text/javascript">
	텍스트 기반의 자바스크립트로 이루어진 코드
	 
	setTimeout('호출함수', 대기시간) = sleep 과 비슷
	예) setTimeout('history.go(0);', 2000)
	2초 뒤에 history.go(0) 함수 호출
	
	history.go(0) 	=> 웹브라우저의 이전/다음 페이지로 이동
					=> go(0) 현재 페이지로 이동
					=> go(1) 다음 페이지로 이동
					=> go(2) 다음다음 페이지로 이동
					=> go(-1) 이전 페이지로 이동
					=> go(-2) 이전이전 페이지로 이동

 			**/



