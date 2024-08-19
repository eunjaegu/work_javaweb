<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
 <c:set var="a" value="1" />
 <c:set var="b" value="${a +1}" />

<c:if test="${a == 1}">
<c:out value="true"></c:out>

</c:if>
 -->
<c:set var="count" value="10"></c:set>
<c:set var="ratio" value="(double) count / sum * 100)"></c:set>
<c:set var="ratio" value="Math.ceil((double) count / sum * 100))"></c:set>
<c:set var="d" value="(new Double(Math.ceil((double) count / sum * 100)))"></c:set>
<c:set var="sum" value="15"></c:set>
<c:out value="${d }" ></c:out>

<c:out value="${ratio }" ></c:out>
<!--  ratio = (new Double(Math.ceil((double) count / sum * 100))).intValue(); 
 <c:choose>
 	<c:when test="${b == 2 } ">
 		<c:out value="true"></c:out>
 	</c:when>
 	<c:otherwise>
 		<c:out value="false"></c:out>
 	</c:otherwise>
 </c:choose>
 -->
</body>
</html>