package com.ej.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
// 스프링에서 제공하는 Controller 인터페이스를 반드시 구현(implements Controller
public class SimpleUrlController implements Controller{

	public SimpleUrlController() {
		// TODO Auto-generated constructor stub
	}

//작업을 마친 후 뷰이름을 ModelAndView에 index.jsp로 설정하여 반환 
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return new ModelAndView("index.jsp");
	}

}
