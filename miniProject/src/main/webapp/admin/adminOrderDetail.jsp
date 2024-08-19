<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminOrderDetail.jsp</title>
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
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		var _state = "<c:out value='${adminorderOne.state}'/>"
		$('#state').val(_state).prop("selected",true);
	})
	
	function deleteOrder(){
		location.href = "${contextPath}/AdminDeleteServlet?no=${adminorderOne.no}"
	}
</script>
</head>
<body>
	<div align="center">
	<form action="<c:url value = '/AdminOrderModServlet' />" method="post">
	<table border="1" style="text-align: center;" >
		<tr></tr>
			<colgroup>
				<col width="40%">
				<col width="60%">		
			</colgroup>
	
		<thead>
			<tr>
				<th colspan="2">주문상세내역</th>
			</tr>		
		</thead>
		
		<tbody>	
			<tr>
				<td>고객아이디</td>
				<td><input type="text"  name="id" value="<c:out value="${adminorderOne.id}" />" readonly></td>
			</tr>
			<tr>
				<td>주문번호</td>
				<td><input type="text"  name="productNo" value="<c:out value="${adminorderOne.productno} " />" readonly></td>
			</tr>
			<tr>
				<td>제품번호</td>
				<td><input type="text"  name="no" value="<c:out value="${adminorderOne.no}" />" readonly></td>
			</tr>
			<tr>
				<td>제품이름</td>
				<td><input type="text"  name="name" value="<c:out value="${adminorderOne.productname}" />" readonly></td>
			</tr>			
			<tr>
				<td>제품가격</td>
				<td><input type="text"  name="price" value="<c:out value="${adminorderOne.price}" />" readonly></td>
			</tr>		
			<tr>
				<td>주문수량</td>
				<td><input type="text"  name="quantity" value="<c:out value="${adminorderOne.quantity}" />" readonly></td>
			</tr>
			<tr>
				<td>재고수량</td>
				<td><input type="text"  name="stock" value="<c:out value="${adminorderOne.stock}" />" readonly></td>
			</tr>
			<tr>
				<td>주문날짜</td>
				<td><input type="text"  name="date" value="<c:out value="${adminorderOne.date}" />" readonly></td>
			</tr>
			<tr>
				<td>금액</td>
				<td><input type="text"  name="price" value="<c:out value="${adminorderOne.price}" />" readonly></td>
			</tr>		
			<tr>
				<td>주문상태</td>
				<td>
				<select id="state" name="state">
				<option value="1" >접수중</option>
				<option value="2" >접수</option>
				<option value="3" >입금확인</option>
				<option value="4" >배송준비</option>
				<option value="5" >배송중</option>
				<option value="6" >완료</option>
				</select>
				</td>
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" onclick="alert('성공')">
					&#47;
					<input type="button" value="삭제" onclick="deleteOrder();">
				</td>
				
			</tr>	
		</tfoot>
	</table>
	</form>
	</div>
</body>
</html>