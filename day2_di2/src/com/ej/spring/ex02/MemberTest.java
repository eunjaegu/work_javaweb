package com.ej.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MemberTest {

	public static void main(String[] args) {
		// 1. XML 문서 로딩
		// xmlBeanFactory() => new FileSystemResource() => "member.xml" 
		 BeanFactory factory = new XmlBeanFactory(new FileSystemResource("member.xml"));
		//factory 객체가 "person.xml"파일에서 지정된 구성에 따라 빈 인스턴스를 생성하고 관리함. 
		 
		// 2. 스프링 컨테이너가 생성한 빈 객체 요청
		//factory.getBean(id명);
		//생성자를 통한 DI
		 MemberService service = (MemberService)factory.getBean("memberService");
		// 3. sayHello() 를 통해 확인.
		 service.listMembers();
	}

}
