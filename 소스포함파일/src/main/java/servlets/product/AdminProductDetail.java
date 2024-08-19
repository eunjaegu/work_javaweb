package servlets.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.product.AdminProductDAO;
import model.mall.AdminProductModel;

@WebServlet("/adminProductDetail")
public class AdminProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private AdminProductDAO productDAO = null;
	
    public AdminProductDetail() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = Integer.parseInt(request.getParameter("num"));
		
		AdminProductModel productModel = new AdminProductModel();
		productModel.setNum(n);
		
		this.productDAO = new AdminProductDAO();
		productModel = this.productDAO.selectOne(n);
		
		
		request.setAttribute("productModel", productModel);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/adminProductDetail.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
