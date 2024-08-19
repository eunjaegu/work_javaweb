package servlets.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.product.AdminProductDAO;


@WebServlet("/adminDeleteProduct")
public class AdminDeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private AdminProductDAO productDAO = null;
	
    public AdminDeleteProduct() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		productDAO = new AdminProductDAO();
		productDAO.delete(num);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminProduct");
		dispatcher.forward(request, response);
	}
}
