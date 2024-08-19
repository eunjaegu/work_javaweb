package com.ej.spring.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LazyTest {

	public static void main(String[] args) {
		// xml 문서 로딩 두 번째 방법
		// ApplicationContext
		// 1. new FileSystemXmlApplicationContext("~~.xml")
		ApplicationContext context = new FileSystemXmlApplicationContext("lazy.xml");
		
		// 2. ApplicationContext.getBean("객체명");
		System.out.println("Third 객체 요청");		// lazy.xml이 true 값이어서 호출해줘야함.
		context.getBean("thirdBean");
		

	}

}
