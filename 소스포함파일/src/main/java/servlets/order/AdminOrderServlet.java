package servlets.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.order.AdminOrderDAO;
import model.mall.AdminOrderModel;

@WebServlet("/AdminOrderServlet")
public class AdminOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminOrderDAO adminorderDAO=null;
 
    public AdminOrderServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandlet(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandlet(request, response);
	}
	
	protected void doHandlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminorderDAO = new AdminOrderDAO();
		
		
		ArrayList<AdminOrderModel> orderModel = this.adminorderDAO.productNameAll();
		
		request.setAttribute("OrderModel", orderModel);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/adminOrder.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	

}
