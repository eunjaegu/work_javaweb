package com.ej.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		// 1. XML 문서 로딩
		// xmlBeanFactory() => new FileSystemResource() => "person.xml" 
		 BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		 //factory 객체가 "person.xml"파일에서 지정된 구성에 따라 빈 인스턴스를 생성하고 관리함.
		 
		// 2. 스프링 컨테이너가 생성한 빈 객체 요청
		//factory.getBean(id명);
		 PersonService person = (PersonService)factory.getBean("personService");
		 
		 //생성자를 통한 DI
		 //PersonService person = (PersonService)factory.getBean("personService2");
		 
		 //생성자를 통한 DI
		// PersonService person = (PersonService)factory.getBean("personService3");
		 
		 
		// 3. sayHello() 를 통해 확인.
		person.sayHello();
		
		
		
		
		//생성자를 통한 DI(의존성주입)는 객체를 생성할 때 해당 객체가 의존하는 
		//다른 객체를 생성자를 통해 받아오는 방식을 의미합니다. 
		//이를 통해 객체 간의 결합도를 낮추고 유연성을 높일 수 있음.
		

	}

}
