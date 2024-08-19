<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminOrderDetail.jsp</title>
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
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		var _state = "<c:out value='${orderModel.state}'/>"
		$('#state').val(_state).prop("selected",true);
	})
	
	function deleteOrder(){
		location.href = "${contextPath}/AdminDeleteServlet?no=${orderModel.no}"
	}
</script>
</head>
<body>
<div class="mainDiv">
	<jsp:include page="/admin/adminTop.jsp" flush="false"/>
	
	<div class="subDiv">
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
				<td><input type="text"  name="id" value="<c:out value="${orderModel.id}" />" readonly></td>
			</tr>
			<tr>
				<td>주문번호</td>
				<td><input type="text"  name="productNo" value="<c:out value="${orderModel.productno} " />" readonly></td>
			</tr>
			<tr>
				<td>제품번호</td>
				<td><input type="text"  name="no" value="<c:out value="${orderModel.no}" />" readonly></td>
			</tr>
			<tr>
				<td>제품이름</td>
				<td><input type="text"  name="name" value="<c:out value="${orderModel.productname}" />" readonly></td>
			</tr>			
			<tr>
				<td>제품가격</td>
				<td><input type="text"  name="price" value="<c:out value="${orderModel.price}" />" readonly></td>
			</tr>		
			<tr>
				<td>주문수량</td>
				<td><input type="text"  name="quantity" value="<c:out value="${orderModel.quantity}" />" readonly></td>
			</tr>
			<tr>
				<td>재고수량</td>
				<td><input type="text"  name="stock" value="<c:out value="${orderModel.stock}" />" readonly></td>
			</tr>
			<tr>
				<td>주문날짜</td>
				<td><input type="text"  name="date" value="<c:out value="${orderModel.date}" />" readonly></td>
			</tr>
			<tr>
				<td>금액</td>
				<td><input type="text"  name="price" value="<c:out value="${orderModel.price}" />" readonly></td>
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
	</div>
	
	<jsp:include page="/admin/adminBottom.jsp" flush="false"/>
</div>
</body>
</html>