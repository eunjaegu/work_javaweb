<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"> </c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> : json7.jsp</title>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script>
		$(function(){
			$("#checkJson").click(function(){
				$.ajax({
					type:"post",
					async: false,
					url:"${contextPath}/json3",
					
					success:function(data, textStatus){
						var jsonInfo = JSON.parse(data);
						
						var output ="회원들 정보<br>"
						output+="<hr>";
						
						for(var i in jsonInfo.members){
						output+= "이름 : "  + jsonInfo.members[i].name+"<br>";
						output+= "나이 : "  + jsonInfo.members[i].age+"<br>";
						output+= "성별 : "  + jsonInfo.members[i].gender+"<br>";
						output+= "별명 : "  + jsonInfo.members[i].nickname+"<br>";
						output+= "==========================================<br>";
						
					}

					for(var i in jsonInfo.books){
						output+= "제목 : "  + jsonInfo.books[i].title+"<br>";
						output+= "저자 : "  + jsonInfo.books[i].author+"<br>";
						output+= "금액 : "  + jsonInfo.books[i].price+"<br>";
						output+= "<img src=" + jsonInfo.books[i].image+" width='300px'/><br>";
						output+= "==========================================<br>";
					}
					$("#output").html(output);
					
					},
					error:function(data, textStatus){
						alert("에러 발생!!!");
						
					},
					complete:function(data, textStatus){
						alert("작업 완료~");
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