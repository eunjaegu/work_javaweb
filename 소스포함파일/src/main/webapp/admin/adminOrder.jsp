<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminOrder.jsp</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">
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
	     body {
    background-color: #FFFFE0; /* 황금색 배경 */
    font-size: 14px;
   
  }

	.viewText {
		border: none; 
		background: transparent;
		outline: none;
	}
	table { 
		 width: 50%; /* 테이블 너비를 화면에 맞게 조정 */
    border-collapse: collapse; /* 셀 사이 간격 없애기 */
   
    background-color: #FFFFE0; /* 연한 황금색 배경 */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); /* 그림자 효과 */
     border: 3px solid #FFD700; /* 황금색 가장자리 테두리 */
	}
	td {
	
        
        vertical-align: top;
        border: 1px solid;
    }
    th {
    
    	border: 1px solid;
    }
     thead tr {
    background-color: #a95e13; /* 테이블 머리글 배경색 */
    color: #fff; /* 텍스트 색상 */
  }
</style>
</head>
<body>
<div class="mainDiv">
	<jsp:include page="/admin/adminTop.jsp" flush="false"/>
	
	<div class="subDiv">
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
	</div>
	
	<jsp:include page="/admin/adminBottom.jsp" flush="false"/>
</div>
</body>
</html>