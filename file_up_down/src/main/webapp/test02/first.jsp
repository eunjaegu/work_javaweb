<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<% 
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드 요청 : first.jsp=> result.jsp</title>
</head>
<body>
	<form action="result.jsp" method="post">
		<input type="hidden" value="my_mbit.jpg" name="param1">
		<input type="hidden" value="my_character.jpg" name="param2">
		<input type="submit" value="요청">
	</form>
</body>
</html>










