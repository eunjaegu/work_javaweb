<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinResult.jsp</title>
<style>
	b {
		font-size: 15px;
	}
	div {
		display: flex;
    	justify-content: center;
    	align-items: center;
    	flex-direction: column;
   		width: 100%;
    	height: 100%;
	}
	span {
		cursor: pointer;
	}
</style>
</head>
<body>
	<div>
		<b>회원가입을 축하 드립니다.</b><br>
		<span onclick="location.href='${contextPath}/members/memLogin.jsp'">로그인</span>
	</div>
</body>
</html>