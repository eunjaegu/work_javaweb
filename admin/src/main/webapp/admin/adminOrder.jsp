<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminOrder.jsp</title>
<style type="text/css">

	div{
		width:100%;
		height:100%;
	}
	table {
	        width: 800px; /* 테이블 너비 지정 */
	        margin: auto; /* 가운데 정렬 */
	  }
	  th, td {
	        border: 1px solid black; /* 테두리 스타일 지정 */
	   }
</style>
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
		<c:forEach var="order" items="${ OrderModel}">
			<tr>
				<td>
					<span name = "no"><c:out value="${order.no }" /></span>
				</td>
				<td>
					<span name = "id"><c:out value="${order.id }" /></span>
				</td>
				<td>
					<span name = "productname"><c:out value="${order.productname }" /></span>
				</td>
				<td>
					<span name = "quantity"><c:out value="${order.quantity }" /></span>
				</td>
				<td>
					<span name = "date"><c:out value="${order.date }" /></span>
				</td>
				<td>
					<span name = "status"><c:out value="${order.state }" /></span>
				</td>
			<td><span onclick="location.href='<c:url value="/AdminDetailServlet?no=${order.no }" />'" >상세보기</span></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</form>
</body>
</html>