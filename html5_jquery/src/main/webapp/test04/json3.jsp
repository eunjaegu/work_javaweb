<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 테스트 다양한 데이터(문자+숫자) : json3.jsp</title>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script>
		$(function(){	
			$("#checkJson").click(function(){	
				var jsonStr='{"name":"홍길동" ,"age":100, "gender":"남자" , "nickname":"hong"}';
				var jsonObj=JSON.parse(jsonStr);
				
				var output = "회원정보<hr>";
				
				output+="이름" + jsonObj.name +"<br>";
				output+="나이" + jsonObj.age +"<br>";
				output+="성별" + jsonObj.gender +"<br>";
				output+="별명" + jsonObj.nickname +"<br>";
				
				$("#output").html(output);
			});
		});
	</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a><br></br>
	<div id="output"></div>
</body>
</html>