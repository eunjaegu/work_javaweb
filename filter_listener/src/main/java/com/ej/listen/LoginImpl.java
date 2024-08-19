package com.ej.listen;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/** HttpSession 에 어떤 데이터가 biding 되면 이벤트가 발생. = 이벤트 처리 **/
public class LoginImpl implements HttpSessionBindingListener{
	
	public String user_id, user_pw;
	
	//전체 접속자 수 저장
	public static int total_user = 0;  
	
	public LoginImpl() {	// 기본생성자
		
	}
	
	public LoginImpl(String user_id, String user_pw) {	//Overloding
		this.user_id=user_id;
		this.user_pw=user_pw;
		
	}
	// 접속여부(사용자가 로그인하면 추가되는 코드, 이벤트 발생)
	public void valueBound(HttpSessionBindingEvent e) {
		System.out.println("사용자 접속!!");
		++total_user;	//total_user++;
	}
	// 접속해제(사용자가 로그아웃하면 제거되는 코드)
	public void valueUnBound(HttpSessionBindingEvent e) {
		System.out.println("사용자 접속 해제..");
		total_user--;
	}
	
	
}
