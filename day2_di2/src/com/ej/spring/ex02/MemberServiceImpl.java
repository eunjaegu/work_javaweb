package com.ej.spring.ex02;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO; // 1. 스프링  컨테이너에 의해 주입됨.
	
	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void listMembers() {
		System.out.println("Service의 listMembers() 메서드 호출");
		memberDAO.listMember();
	}

	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {	//2. setter를 이용한 DI
		this.memberDAO = memberDAO;
	}

	
	
	
}
