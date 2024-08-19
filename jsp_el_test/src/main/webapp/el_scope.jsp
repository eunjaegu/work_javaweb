<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    // JPS에서 내장 객체를 통한 변수 선언 위치 (범위)
    // 내장객체의 setAttribute("키", 데이터);
    pageContext.setAttribute("nave","feeflux");
    // => 현재 페이지에서만 사용 가능 한 변수		//사용범위 가장 작음
    
    request.setAttribute("list", "ArrayList");
    // request 객체 내부에 선언
    
    session.setAttribute("id", "freeflux");
    // 웹 서버(프로젝트 내부) 선언 : 단, session은 개발자에 의해 제거할 수 있다..자동소멸도 가능.
    //(프로젝트 종료전까지 계속 살아있음), 몇 초 후 자동 로그아웃됩니다.
    
    application.setAttribute("listener", "init data");
    // 구동중인 앱 내부에 선언../ 서버가 중지 될 때까지 사용 가능, 사용범위 가장 큼
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_scope.jsp : 변수의 범위</title>
</head>
<body>
	내장객체를 이용하여 선언된 변수의 값을 추출하는 방법<br>
	<hr>
	
	pageContext : ${ name }<br>
	request : ${ requestScope.list }<br>
	session: ${ session }<br>
	application : ${ applicationScope.listener }<br>
	
	외부로부터 전달 받은 데이터(name 속성을 이용하여...)
	param : ${ param.name }<br> 
</body>
</html>