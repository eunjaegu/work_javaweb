package servlets.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.AdminLoginDAO;
import model.mall.AdminVO;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HttpSession session = null;
	
    public AdminLoginServlet() {
        super();
    }

	/**
	 * @see 로그아웃
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/loginCheck");
	}

	/**
	 * @see 로그인
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminVO admin = null;
		AdminLoginDAO AdminLoginDAO = new AdminLoginDAO();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		admin = new AdminVO(id, pw);
		
		session = request.getSession();
		boolean overlappedLogin = AdminLoginDAO.adminLogin(admin);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(overlappedLogin) {
			if(session.isNew() || session.getAttribute("id") == null) {
				session.setAttribute("id", admin.getAdmin_id());
				out.print("success");
			}
			else
				out.print("already");
		} else
			out.print("fail");
		
		out.close();
	}

}
