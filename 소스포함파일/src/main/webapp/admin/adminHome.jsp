<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminHome.jsp</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">
<style>
	p {
		margin-top: 15vh;
		margin-bottom: 15vh; 
	}
</style>
</head>
<body>
<div class="mainDiv">
	<jsp:include page="/admin/adminTop.jsp" flush="false"/>
	
	<div class="subDiv">
		<p align="center">관리자 화면입니다.</p>
	</div>
	
	<jsp:include page="/admin/adminBottom.jsp" flush="false"/>
</div>
</body>
</html>