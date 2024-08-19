package servlets.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.order.AdminOrderDAO;
import model.mall.AdminOrderModel;

@WebServlet("/AdminOrderModServlet")
public class AdminOrderModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminOrderDAO adminorderDAO=null;

    public AdminOrderModServlet() {
        super();
    }
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		 int n = Integer.parseInt(request.getParameter("no"));
   		 

   		AdminOrderModel adminorderModel=new AdminOrderModel();
   		adminorderModel.setNo(n);
   		

   		adminorderDAO = new AdminOrderDAO();
   		AdminOrderModel adminmemOne = adminorderDAO.selectOne(n);
   		
   		request.setAttribute("adminorderOne", adminmemOne);
//   		System.out.println(adminorderOne.toString());
   		
//   		System.out.println("========> AdminOrderModServlet doGet()");
   		RequestDispatcher rd = request.getRequestDispatcher("/admin/adminOrder.jsp");
   		rd.forward(request, response);

   	}

   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		request.setCharacterEncoding("utf-8");
   		adminorderDAO = new AdminOrderDAO();
   		
   		int n=Integer.parseInt(request.getParameter("no"));
   		String state = request.getParameter("state");
   		System.out.println(state);
   
   		AdminOrderModel admiordermModel = new AdminOrderModel();
   		admiordermModel.setState(state);
   		admiordermModel.setNo(n);

 
   		adminorderDAO=new AdminOrderDAO();
   		adminorderDAO.update(admiordermModel);
   		
   		System.out.println("========> AdminMemModServlet doPost()");
   		
   		RequestDispatcher rd = request.getRequestDispatcher("AdminOrderServlet");
   		rd.forward(request, response);
   		
   		
   	}

   }
