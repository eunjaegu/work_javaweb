package servlets.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.session.SessionDAO;
import model.mall.SessionVO;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    public LoginCheckServlet() {
        super();
    }

	/**
	 * @see 관리자 / 사용자 로그인 여부 체크
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SessionVO sessionVO = null;
		SessionDAO sessionDAO = new SessionDAO();
		response.setContentType("text/html; charset=utf-8");
		String val = request.getParameter("val");
		
		if(session.isNew() || session.getAttribute("id") == null) { // 최초 접속
			System.out.println("미 로그인 상태");
			response.sendRedirect(request.getContextPath() + "/util/loginCheck.jsp");
			
		} else {
			sessionVO = new SessionVO((String)session.getAttribute("id"));
			String overlappedLogin = sessionDAO.loginCheck(sessionVO);
			if(val == null) val = "no";
			if(overlappedLogin.equals("admin")) {
				switch(val) { // 관리자 전용 상단 버튼 이동
				case "member":
					response.sendRedirect(request.getContextPath() + "/AdminMemServlet");
					break;
				case "product":
					response.sendRedirect(request.getContextPath() + "/adminProduct");
					break;
				case "order":
					response.sendRedirect(request.getContextPath() + "/AdminOrderServlet");
					break;
				default:
					response.sendRedirect(request.getContextPath() + "/admin/adminHome.jsp");
					break;
				}
				
			} else if(overlappedLogin.equals("member")) {
				switch(val) { // 회원 전용 상단 버튼 이동
				case "product":
					response.sendRedirect(request.getContextPath() + "/members/memList.jsp");
					break;
				case "wish":
					response.sendRedirect(request.getContextPath() + "/members/memCartList.jsp");
					break;
				case "order":
					response.sendRedirect(request.getContextPath() + "/members/memOrder.jsp");
					break;
				default:
					response.sendRedirect(request.getContextPath() + "/members/memHome.jsp");
					break;
				}
		    }
				
		} // if(sessionCheck) end
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
