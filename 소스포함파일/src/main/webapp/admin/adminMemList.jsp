<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">

<style type="text/css">

	div{
		width:100%;
		height:100%;
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
					<td><span onclick="location.href='<c:url value="/AdminMemModServlet?id=${mem.id }" />'" >수정하기</span></td>
					<td><span onclick="">메일보내기</span></td>
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