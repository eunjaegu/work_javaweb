<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memHome.jsp</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	p {
		margin-top: 15vh;
		margin-bottom: 15vh; 
	}
	  body {
    background-color: #FFFFE0; /* 황금색 배경 */
    font-size: 14px;
   
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
	<p align="center">${sessionScope.id }님 방문해 주셔서 감사합니다.</p>
</div>

<jsp:include page="/members/memBottom.jsp" flush="false"/>
</div>
</body>
</html>