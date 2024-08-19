package com.ej.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO memberDAO = null;

	public void init() throws ServletException{// 서블릿 초기화 시 사용하는 메서드 dao 객체 필요
		memberDAO = new MemberDAO();
	} 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null; // 다른 화면으로 이동, 다른 화면 요청...
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo(); // 요청 주소 추출
		System.out.println("action : " + action); // 요청 주소 확인 코드(디버깅용)
		
		if (action==null | action.equals("/listMembers.do")) { // 회원목록 처리
			List<MemberVO> membersList = memberDAO.ListMembers();
			//System.out.println(membersList);
			
			request.setAttribute("membersList", membersList);
			nextPage = "/members/listMembers.jsp";
			
			// DAO => LIST 형태로 담아줘야함. 담아서 listmember.jsp {}가 받아야함.
			
		}else if (action.equals("/addMembers.do")) {	// 회원가입 처리(실제가입시)
			MemberVO member=new MemberVO();
			member.setId((String)request.getParameter("id"));
			member.setPwd((String)request.getParameter("pwd"));
			member.setName((String)request.getParameter("name"));
			member.setEmail((String)request.getParameter("email"));
			
		
			memberDAO.addMember(member);
		
			nextPage = "/member/listMembers.do";
			

		
		}else if (action.equals("/memberForm.do")) {	// 회원가입화면 처리(회원가입 화면만 내보냄)
			//메서드 호출
//			MemberVO jmember=new MemberVO();
//			jmember.setId((String)request.getParameter("id"));
//			jmember.setPwd((String)request.getParameter("pwd"));
//			jmember.setName((String)request.getParameter("name"));
//			jmember.setEmail((String)request.getParameter("email"));
			
			
			nextPage = "/members/memberForm.jsp";
			
		}else if (action.equals("/modMember.do")) {		// 회원수정 처리
			
			
			nextPage = "/member/listMembers.do";
			
		}else if (action.equals("/delMember.do")) {		// 회원삭제 처리
		
			
			nextPage = "/member/listMembers.do";
		
			
		}else if(action.equals("/idcheck.do")){			// ID 중복
			PrintWriter out = response.getWriter();
			
			String id =(String)request.getParameter("id");
			System.out.println("id : " + id);
			
			MemberDAO memberDao = new MemberDAO();
			boolean overlappedID = memberDao.overlappinID(id);
			System.out.println("overlappedID : " + overlappedID);
			
			if(overlappedID == true) {
				out.print("not_usable");
			}else {
				out.print("usable");
			}
			//nextPage = "/member/listMembers.do";
		}
			
			
		if(!action.equals("/idcheck.do")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);	
			
		}
		
	}
}


