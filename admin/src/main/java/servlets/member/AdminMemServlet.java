package servlets.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.AdminMemDAO;
import model.mall.AdminMemModel;

@WebServlet("/AdminMemServlet")
public class AdminMemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminMemDAO adminmemDAO = null;

	public AdminMemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.adminmemDAO = new AdminMemDAO();

		ArrayList<AdminMemModel> adminmemList = this.adminmemDAO.selectList();
		//System.out.println("========> AdminMemServlet doGet()");
		request.setAttribute("MemModel", adminmemList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/adminMemList.jsp");
		requestDispatcher.forward(request, response);
	}
}
