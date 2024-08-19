<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//1. 쿠키 생성 : new Cookie("쿠키명", "문자열 데이터");
	//2. 생성된 쿠키는 웹 브라우저에게 전송(내보내기response)
	// response.addCookie(쿠키 객체);
	Cookie cookie = new Cookie("id", "ej");
	response.addCookie(cookie);
	response.addCookie(new Cookie("name", "구은재"));
	response.addCookie(new Cookie("age", "비밀"));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키가 저장되었습니다.</h1>
</body>
</html>