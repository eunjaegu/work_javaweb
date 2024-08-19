<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Cookie cookie = new Cookie("job","developer");
	cookie.setMaxAge(3);	//초단위 입력 3초후에 사라진다 이거 실행시 localhost로 실행됨
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>