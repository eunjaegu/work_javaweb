package servlets.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.order.AdminOrderDAO;
import model.mall.AdminOrderModel;


@WebServlet("/AdminDeleteServlet")
public class AdminDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminOrderDAO admioOrderDAO = null;
	
    public AdminDeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n=Integer.parseInt(request.getParameter("no"));

		AdminOrderModel adminorderModel=new AdminOrderModel();
		adminorderModel.setNo(n);
		
		String contextPath = request.getContextPath();
		
		admioOrderDAO=new AdminOrderDAO();
		admioOrderDAO.delete(adminorderModel);

		
		response.sendRedirect(contextPath+"/AdminOrderServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
