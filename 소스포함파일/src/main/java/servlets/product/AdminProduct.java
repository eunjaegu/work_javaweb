package servlets.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.product.AdminProductDAO;
import model.mall.AdminProductModel;

/**
 * 관리자 상품 목록
 **/
@WebServlet("/adminProduct")
public class AdminProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminProductDAO productDAO = null;

	public AdminProduct() {
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
		this.productDAO = new AdminProductDAO();

		int totalCount = this.productDAO.selectCount();

		List<AdminProductModel> productModel = this.productDAO.selectList();
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("productModel", productModel);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/adminProductList.jsp");
		requestDispatcher.forward(request, response);
	}
}
