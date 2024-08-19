<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memOrder.jsp</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">
<style type="text/css">
  * {
    margin: 0;
    padding: 0;
    font-family: 'Gulim', sans-serif;
  }
  
  body {
    background-color: #FFFFE0; /* 황금색 배경 */
    font-size: 14px;
   
  }

  table {
    width: 100%; /* 테이블 너비를 화면에 맞게 조정 */
    border-collapse: collapse; /* 셀 사이 간격 없애기 */
    margin: 20px 0; /* 상하 여백 */
    background-color: #FFFFE0; /* 연한 황금색 배경 */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); /* 그림자 효과 */
     border: 3px solid #FFD700; /* 황금색 가장자리 테두리 */
  }

  th, td {
    border: 1px solid #DAA520; /* 셀 테두리 */
    padding: 10px; /* 셀 안쪽 여백 */
    text-align: center; /* 텍스트 가운데 정렬 */
  }

  th {
    background-color: #a95e13; /* 갈색 배경 */
    color: #FFFFFF; /* 텍스트 색상 흰색 */
  }

  tr {
    background-color: #FFD700; /* 행 배경 황금색 */
  }

  td {
    background-color: #FFFACD; /* 셀 배경 연한 황금색 */
  }

  input[type="text"], input[type="number"] {
    width: 60%; /* 입력 필드 너비 */
    padding: 5px; /* 입력 필드 안쪽 여백 */
  }

  input[type="button"], input[type="submit"] {
    background-color: #DAA520; /* 버튼 배경 갈색 */
    color: white; /* 텍스트 색상 흰색 */
    border: none; /* 테두리 없앰 */
    padding: 5px 10px; /* 버튼 안쪽 여백 */
    cursor: pointer; /* 커서 포인터 모양 */
  }

  input[type="button"]:hover, input[type="submit"]:hover {
    background-color: #A0522D; /* 버튼 호버 시 색상 변경 */
  }
.total-amount {
    text-align: right; /* 내용을 왼쪽으로 정렬 */
    padding-right: 10px; /* 왼쪽 여백을 주어 내용과 테두리 사이에 공간을 만듬 */
  }
</style>
</head>
<body>

<div class="mainDiv">
<jsp:include page="/members/memTop.jsp" flush="false"/>

<div class="subDiv">

	<form action="">
	<table border="1" style="text-align: center;">
		<tr></tr>
			<colgroup>
				<col width="10%">
				<col width="15%">
				<col width="15%">	
				<col width="15%">
				<col width="10%">
			</colgroup>
		<thead>
			<tr>
				<th>주문번호</th>
				<th>제품</th>
				<th>주문수량</th>
				<th>주문날짜</th>
				<th>주문상태</th>
			</tr>		
		</thead>
		<tbody>
			<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			</tr>
		</tbody>
	</table>
	</form>
	</div>

<jsp:include page="/members/memBottom.jsp" flush="false"/>
</div>

	
</body>
</html>