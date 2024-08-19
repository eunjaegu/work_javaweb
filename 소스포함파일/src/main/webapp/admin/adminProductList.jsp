<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 상품 관리</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">
<style>
 
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

	<div align="center">
		<table border="1" style="text-align: center;">
			<colgroup>
				<col width="15%">
				<col width="20%">
				<col width="35%">
				<col width="10%">
				<col width="15%">
			</colgroup>
			<thead>
				<!-- 글 제목 -->
				<tr>
					<td>이름</td>
					<td>가격</td>
					<td>날짜</td>
					<td>재고</td>
					<td></td>
				</tr>
			</thead>
			
				<!-- 글 목록의 데이터 부분 -->
			<tbody>
				<c:choose>
					<c:when test="${totalCount == 0 }">
						<tr>
							<td colspan="5">등록된 상품이 없습니다.</td>
						</tr>
					</c:when>
					
					<c:otherwise>
						<c:forEach var="product" items="${ productModel}" varStatus="status">
							<tr>
								<td><c:out value="${product.name }"></c:out></td>
								<td><c:out value="${product.price }"></c:out></td>
								<td><c:out value="${product.date }"></c:out></td>
								<td><c:out value="${product.stock }"></c:out></td>
								<td>
									<span id = "detail" onclick="location.href='<c:url value="/adminProductDetail?num=${product.num }" />'">상세보기</span>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<tr>
					<td colspan="5">
						<span onclick="location.href='<c:url value="/admin/adminAddProduct.jsp" />'">상품등록</span>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	</div>
	
	<jsp:include page="/admin/adminBottom.jsp" flush="false"/>
</div>

	
</body>
</html>