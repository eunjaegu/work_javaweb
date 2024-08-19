//package servlets.order;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.member.AdminMemDAO;
//import dao.order.AdminOrderDAO;
//import model.mall.AdminMemModel;
//import model.mall.AdminOrderModel;
//
//
//@WebServlet("/AdminDetailServlet")
//public class AdminDetailServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	private AdminOrderDAO adminorderDAO=null;
// 
//    public AdminDetailServlet() {
//        super();
//    }
//
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int n = Integer.parseInt(request.getParameter("no"));
//		
//		this.adminorderDAO = new AdminOrderDAO();
//		
//		AdminOrderModel orderModel = new AdminOrderModel();
//		orderModel = adminorderDAO.selectOne(n);
//		
//		
//		
//		request.setAttribute("orderModel", orderModel);
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/adminOrderDetail.jsp");
//		requestDispatcher.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}
//
//}
