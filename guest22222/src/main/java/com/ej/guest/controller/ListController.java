package com.ej.guest.controller;

//1.MySQL DB접속 
//2. state 객체생성 
//3.해당쿼리로 실행
//4.결과값 resultSet
//5.while문 result set 이용해 next문으로 꺼내기
//6.꺼낼떄마다 하나의 레코드를 객체로 만들기
//7.arraylist에 추가, arraylist return

// 1. MySQL 접속 => Connection (MySQL DB접속)
// 2. Connection => Statettment (state 객체생성)
// 3. select (필드명...) from guest order by desc (해당쿼리로 실행)
// 4. ResultSet = Statetment.executeQuery(쿼리) (결과값 resultSet)
// 5. ResultSet에 레코드 여부 확인 (while문 result set이용해 next문으로 꺼내기)
// 6. 레코드가 없으면 : 게시글 된 글이 없습니다..
// 7. 레코드 존재 : while(ResultSet.next()){}
// 8. while문 내부
// 8-1. 레코드를 하나의 객체로...
// 8-2. 객체를 ArrayList에 추가

public class ListController {

	public ListController() {

	}

	public void list() {	
		System.out.println("ListController => list()");
	}
}
