<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body>
	
	<table border="1" width="100%" cellspacing="0" cellpadding="0" margin="0" padding="0">
		<tr><th>INDEX</th><th>COUNT</th><th>TITLE</th></tr>
		
		<!-- forEach : 자바의 for(	:	) 과 동일 items="다중값"  -->
		<c:forEach var="movie" items="${movieList}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${status.count}</td>
			<td>${movie}</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>