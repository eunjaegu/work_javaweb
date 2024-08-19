<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 객체 ajax 이용하여 servlet으로 전달 : json5.jsp</title>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script>
		$(function(){
			$("#checkJson").click(function(){
			var jsonStr='{"name":"홍길동" ,"age":100, "gender":"남자" , "nickname":"hong"}';
			$.ajax({
				type:"post",
				async:false,
				url:"${contextPath}/json1",
				data:{jsonInfo:jsonStr},
				
				success:function(){
					//~~~할일 없음
				},
				error:function(){
					alert("에러발생");
				},
				complete:function(){
					alert("작업 종료");
				}
			});	
		});
	});
	</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a><br></br>
	<div id="output"></div>
</body>
</html>