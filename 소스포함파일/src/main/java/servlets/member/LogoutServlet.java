package servlets.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/btnLogout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HttpSession session = null;
	
    public LogoutServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		session.invalidate();
		String value = request.getParameter("value");
		if(value.equals("adminLogin"))
			response.sendRedirect(request.getContextPath() + "/admin/adminLogin.jsp");
		else
			response.sendRedirect(request.getContextPath() + "/loginCheck");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
