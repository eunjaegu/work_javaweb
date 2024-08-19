<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 	//쿠키의 값을 수정할 경우 : Mpa 처럼 동일한 이름에 새로운 값을 설정
 	response.addCookie(new Cookie("age", "55"));
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 수정 : cookie_update.jsp</title>
</head>
<body>
	age 쿠키의 값이 수정되었습니다..
</body>
</html>