<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memBottom</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/TopBottom.css">
</head>
<body>
	<table>
		<tr>
			<td align="center" colspan="4">
				<b>Simple Shopping Mall 에 오신 것을 환영합니다.</b>
			</td>
			<td style="cursor: pointer;" align="center" onclick="location.href='${contextPath}/btnLogout?value=adminLogin'">
				<b>관리자<!-- 클릭 시 /btnLogout?value=adminLogin 전송 필요 --></b>	
			</td>
		</tr>
	</table>
</body>
</html>