<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL : el_basic1.jsp</title>
</head>
<body>
	${ "EL" }<br> <%-- EL을 문법을 이용한 출력 --%>
	<%= "EL" %><br>	 <%-- jsp 문법을 이용한 출력 --%>
	<%
		out.print("EL"); // JSP 내장객체인 out을 이용한 출력
					// out을 사용할 경우 println() 은 의마가 없다!!!
	%>			

</body>
</html>