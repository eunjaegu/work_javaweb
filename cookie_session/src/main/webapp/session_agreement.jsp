<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	//POST 방식으로 전송되면 한글이 깨지기 때문에...읽기전에 Eencoding
	
	//JSP 내장 객체인 session에 전달된 값을 저장
	session.setAttribute("id", request.getParameter("id"));
	session.setAttribute("pw", request.getParameter("pw"));
	session.setAttribute("name", request.getParameter("name"));
	//서블릿에서 세션객체를 만들어줘야함
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>약관</h3>
	<hr>
	1. 회원정보는 웹 운영에만~~~
	2. 웹 운영 차질 => 강제 탈퇴!!
	<hr>
	
	위의 약관에 동의???
	<form action="session_subscribe.jsp">
		<input type="radio" name="agree" value="YES"> 동의 <br>
		<input type="radio" name="agree" value="NO"> 동의하지 않음 <br>
		 <br>
		<input type="submit" value="확인">
	
	</form>
	
</body>
</html>