<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memListInfo.jsp</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">
<style>
  body {
    background-color: #FFFFE0; /* 황금색 배경 */
    font-size: 14px;
   
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
<jsp:include page="/members/memTop.jsp" flush="false"/>

<div class="subDiv">
<div align="center">
	<table summary="사용자 상품 목록">
		<colgroup>
			<col width="" />
			<col width="40%" />
			<col width="" />
		</colgroup>
		<thead>
			<tr>
				<th colspan="3"><!-- 상품이름 --></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><img src="">d</td>
				<td align="left">
					<form action="">
						<b>상품이름 : </b>
						<input class="viewText" type="text" readonly/> <br>
						<b>가격 : </b>
						<input class="viewText" type="text" readonly/> <br>
						<b>수량 : </b>
						<input type="text" value="1" style="width: 30px;" required/>개
						<br><br>
						<input type="submit" value="장바구니 담기" />
					</form>
				</td>
				<td align="left">
				<b>상세설명</b> <br><br>
				<span>상세설명란</span>
				</td>
			</tr>
		</tbody>
	</table>
</div>

</div>

<jsp:include page="/members/memBottom.jsp" flush="false"/>
</div>



</body>
</html>