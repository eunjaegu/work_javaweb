package servlets.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.MemLoginDAO;
import model.mall.MemLoginVO;

/**
 * Servlet implementation class MemLoginServlet
 */
@WebServlet("/memLogin")
public class MemLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HttpSession session = null;
	
    public MemLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		MemLoginVO member = null;
		MemLoginDAO memLoginDAO = new MemLoginDAO();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		member = new MemLoginVO(id, pw);
		
		session = request.getSession();
		boolean overlappedLogin = memLoginDAO.MemLogin(member);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(overlappedLogin) {
			if(session.isNew() || session.getAttribute("id") == null) {
				session.setAttribute("id", member.getMem_id());
				out.print("success");
			}
			else
				out.print("already");
		} else
			out.print("fail");
		
		out.close();
	}

}
