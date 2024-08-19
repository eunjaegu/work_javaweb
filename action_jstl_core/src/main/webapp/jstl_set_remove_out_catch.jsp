<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="age" value="10" scope="page"></c:set>
	<h4>설정값 출력</h4>
	<c:out value="${ age }"></c:out>
	
	<c:remove var="age" scope="page"/>
	<h4>제거된 변수값 출력</h4>
	<c:out value="${ age }"></c:out>
	
	<h4>오류가 발생했을 경우 예외 처리</h4>
	<c:catch var="errMsg">
		예외 발생 전 <br>
		<%= 1/0 %>
		예외 발생 후 <br>
	</c:catch>
	<c:out value="${ errMsg }"></c:out>
		
</body>
</html>