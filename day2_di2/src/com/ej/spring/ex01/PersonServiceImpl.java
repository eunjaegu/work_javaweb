package com.ej.spring.ex01;

public class PersonServiceImpl implements PersonService {
	private String name;
	private	int age;
	
	public PersonServiceImpl() {
		
	}
	
	public PersonServiceImpl(String name) {
		super();
		this.name = name;
	}

	public PersonServiceImpl(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void sayHello() {
		System.out.println("이름 : " + this.name );
		System.out.println("나이 : " + this.age );
		
	}
	

}
