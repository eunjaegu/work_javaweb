<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminOrder.jsp</title>
</head>
<body>
	<form action="">
	<table border="1" style="text-align: center;">
		<tr></tr>
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="10%">	
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="15%">		
			</colgroup>
		<thead>
			<tr>
				<th>주문번호</th>
				<th>주문자</th>
				<th>제품</th>
				<th>주문수량</th>
				<th>주문날짜</th>
				<th>주문상태</th>
				<th>상세보기</th>		
			</tr>		
		</thead>
		<tbody>
			<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><span onclick="location.href='<c:url value="/AdminDetailServlet" />'" >상세보기</span></td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>