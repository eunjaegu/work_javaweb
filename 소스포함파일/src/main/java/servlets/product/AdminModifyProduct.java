package servlets.product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.product.AdminProductDAO;
import model.mall.AdminProductModel;


@WebServlet("/adminModifyProduct")
@MultipartConfig
public class AdminModifyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private AdminProductDAO productDAO = null;
    
    public AdminModifyProduct() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = Integer.parseInt(request.getParameter("num"));
		
		AdminProductModel productModel = new AdminProductModel();
		AdminProductDAO productDAO = new AdminProductDAO();
		productModel = productDAO.selectOne(n);
		
		request.setAttribute("productModel", productModel);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/adminModProduct.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String fileName = null;
System.out.println("ddd");
		AdminProductModel productModel = new AdminProductModel();
		
		Part filePart = request.getPart("file");
		if (filePart.getContentType() != null) {

			fileName = filePart.getSubmittedFileName();
			InputStream fileName1 = filePart.getInputStream();
	
			String savePath = request.getServletContext().getRealPath("/") + "/img/" + fileName;

			try {
				OutputStream outputStream = new FileOutputStream(savePath);
				byte[] buffer = new byte[1024];

				int bytesRead;
				while ((bytesRead = fileName1.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				System.out.println("파일이 저장 되었습니다." + savePath);

				fileName1.close();
				outputStream.close();
			} catch (IOException e) {
				System.err.println("IOException err : " + e.getMessage());
			}

		} else {
			System.out.println("파일이 저장 되지 않았습니다.");
		}
		System.out.println(fileName);
		productModel.setNum(Integer.parseInt(request.getParameter("num")));
		productModel.setName(request.getParameter("name"));
		productModel.setPrice(Integer.parseInt(request.getParameter("price")));
		productModel.setDetail(request.getParameter("detail"));
		productModel.setStock(Integer.parseInt(request.getParameter("stock")));
		productModel.setImg(fileName);
 System.out.println(productModel.toString());
		productDAO = new AdminProductDAO();
		productDAO.update(productModel);
	}
	
}
