package servlets.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admin.AdminDAO;
import dao.member.MemDAO;
import model.MemVO;

@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemDAO memDAO = null;

	public void init() throws ServletException {
		memDAO = new MemDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		String id = (String) request.getParameter("id");

		AdminDAO adminDAO = new AdminDAO();
		MemDAO memberDAO = new MemDAO();
		boolean overlappedID = adminDAO.overlappedID(id);

		if (overlappedID) {	// 관리자 아이디 체크
			System.out.println("관리자 아이디 중복");
			writer.print("not_usable");
		} else {
			overlappedID = memberDAO.overlappedID(id);
			if(overlappedID) {
				// 회원 아이디 체크
				System.out.println("멤버 아이디 중복");
				writer.print("not_usable");
			} else {
				System.out.println("사용가능 아이디");
				writer.print("usable");
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 회원가입 */
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String call = request.getParameter("call");
		String email = request.getParameter("email");
		
		MemVO memVO = new MemVO();
		memVO.setMemId(id);
		memVO.setMemPw(pw);
		memVO.setMemName(name);
		memVO.setMemCall(call);
		memVO.setMemEmail(email);
		memDAO.insert(memVO);
		
		System.out.println("========> MainForm.jsp doPost()");
		
		
		response.sendRedirect(request.getContextPath()  + "/members/MainForm.jsp");
	}
	

}


