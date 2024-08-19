package servlets.member;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.AdminMemDAO;
import model.mall.MemInfoVO;


@WebServlet("/AdminMemModServlet")
public class AdminMemModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminMemDAO adminmemDAO=null;

    public AdminMemModServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String n = request.getParameter("id");
		 

		MemInfoVO adminmemModel=new MemInfoVO();
		adminmemModel.setId(n);
		

		adminmemDAO = new AdminMemDAO();
		MemInfoVO adminmemOne = adminmemDAO.selectOne(adminmemModel);
		
		request.setAttribute("adminmemOne", adminmemOne);
//		System.out.println(adminmemOne.toString());
		
		System.out.println("========> AdminMemModServlet doGet()");
		RequestDispatcher rd = request.getRequestDispatcher("/admin/adminModInfo.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("========> "+ request.getParameter("id"));
		String id=request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("date");
		String email = request.getParameter("email");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobbys");
		String job = request.getParameter("job");
		
		
		MemInfoVO adminmemModel = new MemInfoVO();
		adminmemModel.setId(id);
		adminmemModel.setPwd(pwd);
		adminmemModel.setName(name);
		adminmemModel.setGender(gender);
		adminmemModel.setBirthday(birthday);
		adminmemModel.setEmail(email);
		adminmemModel.setZipcode(zipcode);
		adminmemModel.setAddress(address);
		adminmemModel.setHobby(hobby);
		adminmemModel.setJob(job);
		adminmemDAO=new AdminMemDAO();
		adminmemDAO.update(adminmemModel);
		
		
		
		
		
	}

}
