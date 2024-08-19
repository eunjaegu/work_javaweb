<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminProductDetail.jsp</title>
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
	<table summary="사용자 상품 목록">
		<colgroup>
			<col width="40%" />
			<col width="40%" />
			<col width="" />
		</colgroup>
		<thead>
			<tr>
				<th colspan="3"><!-- 상품이름 --><c:out value = "${productModel.name }"></c:out></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><img src="${contextPath }/img/${productModel.img }" width= "100%"></td>
				<td>
				<table style="width: 100%;">
					<tr>
						<td>
						<b>상품이름 : </b>
						<c:out value= "${productModel.name }" />
						</td>
					</tr>
					<tr>
						<td>
						<b>가격 : </b>
						<c:out value= "${productModel.price }" />
						</td>
					</tr>
					<tr>
						<td>
						<b>입고날짜 : </b>
						<c:out value= "${productModel.date }" />
						</td>
					</tr>
					<tr>
						<td>
						<b>재고 : </b>
						<c:out value= "${productModel.stock }" />
						</td>
					</tr>
				</table>
				</td>
				<td align="left">
				<b>상세설명</b> <br><br>
				<span><c:out value="${productModel.detail }"/></span>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td align="center" colspan="3">
					<span onclick="location.href='<c:url value="/adminModifyProduct?num=${productModel.num}"/>'">수정하기</span> &nbsp;
					<span onclick= "location.href='<c:url value="/adminDeleteProduct?num=${productModel.num }"/> '">삭제하기</span>
				</td>
			</tr>
		</tfoot>
	</table>
</div>
	</div>
	
	<jsp:include page="/admin/adminBottom.jsp" flush="false"/>
</div>



</body>
</html>