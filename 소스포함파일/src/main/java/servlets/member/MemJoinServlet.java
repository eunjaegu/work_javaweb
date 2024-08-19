package servlets.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.AdminLoginDAO;
import dao.member.MemJoinDAO;
import model.mall.MemInfoVO;

/**
 * Servlet implementation class MemJoinServlet
 */
@WebServlet("/memberJoin")
public class MemJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemJoinDAO memJoinDAO = null;
	
    public MemJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see 아이디 중복 확인
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = (String)request.getParameter("id");
		memJoinDAO = new MemJoinDAO();
		
		boolean overlappedID = memJoinDAO.overlappedID(id);
		
		if(overlappedID) {
			out.print("not_usable");
			System.out.println("멤버에 값이 있음");
		}
		else {
			AdminLoginDAO adminLoginDAO = new AdminLoginDAO();
			overlappedID = adminLoginDAO.overlappedID(id);
			
			if(overlappedID) {
				out.print("not_usable");
				System.out.println("어드민에 값이 있음");
			}
			else
				out.print("usable");
		}
			
		

	}

	/**
	 * @see 회원가입 처리
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemInfoVO memInfoVO = new MemInfoVO();
		memJoinDAO = new MemJoinDAO();
		System.out.println("servlet param : " + request.getParameter("hobbys"));

		memInfoVO.setId(request.getParameter("id"));
		memInfoVO.setPwd(request.getParameter("pwd"));
		memInfoVO.setName(request.getParameter("name"));
		memInfoVO.setGender(request.getParameter("gender"));
		memInfoVO.setBirthday(request.getParameter("birthday"));
		memInfoVO.setEmail(request.getParameter("email"));
		memInfoVO.setZipcode(request.getParameter("zipcode"));
		memInfoVO.setAddress(request.getParameter("address"));
		memInfoVO.setHobby(request.getParameter("hobbys"));
		memInfoVO.setJob(request.getParameter("job"));
		
		memJoinDAO.insertMember(memInfoVO);
		
	}

}
