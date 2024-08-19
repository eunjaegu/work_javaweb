package servlets.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.MemJoinDAO;
import model.mall.MemInfoVO;

/**
 * Servlet implementation class MemModifyServley
 */
@WebServlet("/memModify")
public class MemModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemInfoVO infoVO = null;
	private MemJoinDAO joinDAO = null;
	
    public MemModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see 회원 수정 폼 이동
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		joinDAO = new MemJoinDAO();
		
		infoVO = joinDAO.selectOne(id);
		
		request.setAttribute("member", infoVO);
		RequestDispatcher rd = request.getRequestDispatcher("/members/memModInfo.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see 회원 수정
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		infoVO = new MemInfoVO();
		
		infoVO.setId(request.getParameter("pwd"));
		infoVO.setPwd(request.getParameter("pwd"));
		infoVO.setName(request.getParameter("name"));
		infoVO.setGender(request.getParameter("gender"));
		infoVO.setBirthday(request.getParameter("birthday"));
		infoVO.setEmail(request.getParameter("email"));
		infoVO.setZipcode(request.getParameter("zipcode"));
		infoVO.setAddress(request.getParameter("address"));
		infoVO.setHobby(request.getParameter("hobbys"));
		infoVO.setJob(request.getParameter("job"));
		
		joinDAO.updateMember(infoVO);
	}

}
