package servlets.reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.reservation.RevDAO;
import dao.room.RoomDAO;
import dao.roomImg.RoomImgDAO;
import model.RevVO;
import model.RoomImgVO;
import model.RoomVO;

/**
 * Servlet implementation class RevInsert
 */
@WebServlet("/RevInsert")
public class RevInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RevVO revVO = null;
	private RevDAO revDAO = null;
	
    public RevInsert() {
        super();
    }

	/**
	 * @see 예약 화면으로 이동
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String idType = (String)session.getAttribute("idType");
		
		if(session.getAttribute("id") == null || idType == null) {
			response.sendRedirect(request.getContextPath() + "/common/Login.jsp");
			return;
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String tempNum = request.getParameter("roomNo");
		if(tempNum == null || tempNum.equals("")) {
			out.print("nullRoomNo");
			return;
		}
		
		int roomNum = Integer.parseInt(tempNum);

		revDAO = new RevDAO();
		RoomImgDAO imgDAO = new RoomImgDAO();
		RoomDAO roomDAO = new RoomDAO();
		RoomImgVO imgVO = new RoomImgVO();
		RoomVO roomVO = new RoomVO();
		ArrayList<RevVO> revList = new ArrayList<RevVO>();
		
		imgVO = imgDAO.selectOne(roomNum);
		roomVO = roomDAO.selectOne(roomNum);
		revList.addAll(revDAO.selectRoomRev(roomNum));
		
		request.setAttribute("revList", revList);
		request.setAttribute("roomVO", roomVO);
		request.setAttribute("imgVO", imgVO);
		
		request.getRequestDispatcher("/members/RoomRev.jsp").forward(request, response);
	}

	/**
	 * @see 예약 처리
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String memId = (String)session.getAttribute("id");
		String bookCheck = request.getParameter("bookCheck");
		String bookCheckOut = request.getParameter("bookCheckOut");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date_bookCheck = null;
		Date date_bookCheckOut = null;
		revVO = new RevVO();
		revDAO = new RevDAO();
		
		try {
			date_bookCheck = (Date) dateFormat.parse(bookCheck);
			date_bookCheck = (Date) dateFormat.parse(bookCheckOut);
		} catch (java.text.ParseException e) {
			System.out.println("Rev Insert Parse ERR : " + e.getMessage());
		}
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(currentDateTime);
		
		revVO.setBookDate(timestamp);
		revVO.setRoomNo(Integer.parseInt(request.getParameter("roomNo")));
		revVO.setBookCheck(date_bookCheck);
		revVO.setBookCheckOut(date_bookCheckOut);
		revVO.setHeadCount(Integer.parseInt(request.getParameter("headCount")));
		revVO.setPrice(Integer.parseInt(request.getParameter("price")));
		revVO.setMemId(memId);
		
		int result = revDAO.insertRev(revVO);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result == 1) 
			out.print("success");
		else
			out.print("fail");
		
	}

}
