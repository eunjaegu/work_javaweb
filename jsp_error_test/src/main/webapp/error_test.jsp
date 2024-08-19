<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%-- 
    errorPage="error.jsp = 는 현재 페이지에서 오류가 발생했을 경우
    error.jsp로 이동
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 발생 페이지 : error_test.jsp</title>
</head>
<body>
	<h2>ERROR</h2>
	<h5>발생 페이지</h5>
	<hr>
	<%= 5/0 %>
</body>
</html>