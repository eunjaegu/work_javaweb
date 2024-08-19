<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memTop</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/TopBottom.css">
<style>	
	table tr th {
		cursor: pointer;
	}
</style>
</head>
<body>
	<table summary="회원 include">
		<colgroup>
			<col width="" />
			<col width="" />
			<col width="" />
			<col width="" />
			<col width="" />
		</colgroup>
		<tr>
			<c:choose>
				<c:when test="${sessionScope.id != null }">
						<th onclick="location.href='${contextPath}/btnLogout?value=no'"><b>로그아웃</b></th>
						<th onclick="location.href='${contextPath}/memModify'"><b>회원수정</b></th>
				</c:when>
				<c:otherwise>
						<th onclick="location.href='${contextPath}/members/memLogin.jsp'"><b>로그인</b></th>
						<th onclick="location.href='${contextPath}/members/memJoin.jsp'"><b>회원가입</b></th>
				</c:otherwise>
			</c:choose>
			<th onclick="location.href='${contextPath}/loginCheck?val=product'"><b>상품목록</b></th>
			<th onclick="location.href='${contextPath}/loginCheck?val=wish'"><b>장바구니</b></th>
			<th onclick="location.href='${contextPath}/loginCheck?val=order'"><b>구매목록</b></th>
		</tr>
	</table>
</body>
</html>