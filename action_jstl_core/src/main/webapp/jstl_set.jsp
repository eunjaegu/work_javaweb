<%@page import="com.ej.beans.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	변수 설정 <br>
	<c:set var="msg" value="Hello"></c:set>
	\${ msg } = ${ msg }
	
	<c:set var="age">100</c:set>
	\${ age } = ${ age }
	
	<c:set var="add">100</c:set>
	\${ add } = ${ add }
	
	<c:set var="add" value="${ 10+5 }"></c:set>
	\${ add } = ${ add }
	
	<c:set var="flag" value="${ 10 > 5 }"></c:set>
	\${ flag } = ${ flag }
	
	<hr>
	<h4>MemberBean 객체 생성</h4>
	<c:set var="member" value="<%= new com.ej.beans.MemberBean() %>"></c:set>
	
	<c:set target="${ member }" property="name" value="구은재"></c:set>
	<%-- 			사용객체명			내부변수명	변수에 대입 --%>
	
	<c:set target="${ member }" property="userid">구은재</c:set>
	\${ member } = ${ member }
	<%-- toString() 자동 호출 --%>
	
</body>
</html>