<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Jstl_url.jsp : url 태그</title>
</head>
<body>
	<c:url value="./images/pic.jpg" var="data"></c:url>
	<img src="${ data }" width="600"  height="300">
	<h3>${ data }</h3>
</body>
</html>