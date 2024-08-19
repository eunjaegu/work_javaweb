<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Jstl_import.jsp : import 태그</title>
</head>

<body>
	<h4>아래에 삽입 됨</h4>
	<c:import url="http://localhost:9000/action_jstl_core/jstl_set.jsp"></c:import>
	<h4>위에 삽입 됨</h4>
	
</body>
</html>