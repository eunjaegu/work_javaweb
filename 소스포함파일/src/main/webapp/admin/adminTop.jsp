<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminTop</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/TopBottom.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	.th {
		cursor: pointer;
	}
</style>
</head>
<body>
	<table summary="관리자 include 화면">
		<colgroup>
			<col width="" />
			<col width="" />
			<col width="" />
			<col width="" />
			<col width="" />
		</colgroup>
		<tr>
			<th class="th" onclick="location.href='${contextPath}/btnLogout?value=no'"><b>홈</b></th>
			<th class="th" onclick="location.href='${contextPath}/btnLogout?value=no'"><b>로그아웃</b></th>
			<th class="th" onclick="location.href='${contextPath}/loginCheck?val=member'"><b>회원관리</b></th>
			<th class="th" onclick="location.href='${contextPath}/loginCheck?val=product'"><b>상품관리</b></th>
			<th class="th" onclick="location.href='${contextPath}/loginCheck?val=order'"><b>주문관리</b></th>
		</tr>
	</table>
</body>
</html>
