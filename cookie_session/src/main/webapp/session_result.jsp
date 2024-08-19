<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String result = request.getParameter("result");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session_result.jsp : 가입 결과</title>
</head>
<body>
	<h3>회원 가입 결과</h3>
	<% 
		if(result.equals("SUCCESS")){
			out.print("축하!!!");
		}else{
			out.print("아쉽네요~");
		}
	%>

</body>
</html>