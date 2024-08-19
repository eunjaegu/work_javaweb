<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	div{
		width:100%;
		height:100%;
	}
</style>
</head>
<body>
	<form action="">
	<table border="1" style="text-align: center;">
		<tr></tr>
			<colgroup>
				<col width="10%">
				<col width="15%">
				<col width="10%">	
				<col width="5%">
				<col width="10%">	
				<col width="20%">	
				<col width="10%">	
				<col width="15%">	
			</colgroup>
		<thead>
			<tr>
				<th>회원이름</th>
				<th>회원아이디</th>
				<th>패스워드</th>
				<th>성별</th>
				<th>생년월일</th>
				<th>이메일</th>
				<th>수정</th>
				<th>이메일보내기</th>

			</tr>		
		</thead>
		<tbody>
		<c:forEach var="mem" items="${ MemModel}">
				<tr>
					<td>
						<c:out value="${mem.name }" />
					</td>
					<td>
						<c:out value="${mem.id }" />
					</td>
					<td>
						<c:out value="${mem.pwd }" />
					</td>
					<td>
						<c:out value="${mem.gender }" />
					</td>
					<td>
						<c:out value="${mem.birthday }" />
					</td>
					<td>
						<c:out value="${mem.email }" />
					</td>
					<td><span onclick="location.href='<c:url value="/AdminMemModServlet" />'" >수정하기</span></td>
					<td><span onclick="">메일보내기</span></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
</body>
</html>