<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%
String[] movieList = { "시민덕희", "파묘", "윙카", "위시", "밥말리" };
//movieList 는 현재 페이지에서만 사용 가능하도록....
pageContext.setAttribute("movieList", movieList);
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>foreach_movie.jsp : forEach</title>
</head>
<body>
	<ul>	<!-- 목록화 태그 / ol tag : <li></li> -->
	<!-- li 태그는 자동 줄바꿈 기능이 내장 -->
	<!-- forEach : 자바의 for(	:	) 과 동일 items="다중값"  -->
	<c:forEach var="movie" items="${movieList}" varStatus="status">
		<c:choose>
			<c:when test="${status.first}">	<!-- if() -->
				<li style="color:red; font-weight:bold;">${movie}</li>
			</c:when>
			<c:otherwise>					<!-- else -->
				<li>${movie}</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	</ul>
	
	<c:forEach var="movie" items="${movieList}" varStatus="status">
		${movie}
		 <c:if test="${not status.last}">, </c:if>
	</c:forEach>
</body>
</html>