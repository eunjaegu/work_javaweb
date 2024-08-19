<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 테스트 복합 데이터 : json4.jsp</title>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script>
		$(function(){	
			$("#checkJson").click(function(){	
				var jsonStr='{"members":[{"name":"홍길동" ,"age":100, "gender":"남자" , "nickname":"hong"},{"name":"홍길동" ,"age":100, "gender":"남자" , "nickname":"hong"},{"name":"홍길동" ,"age":100, "gender":"남자" , "nickname":"hong"}]}';
				var jsonObj=JSON.parse(jsonStr);
				
				var output="회원들 정보<hr>";
				for(var i in jsonObj.members){
					output+= "이름:" + jsonObj.members[i].name + "<br>";
					output+= "나이:" + jsonObj.members[i].age + "<br>";
					output+= "성별:" + jsonObj.members[i].gender + "<br>";
					output+= "별명:" + jsonObj.members[i].nickname + "<br>";
					output+="=============================<br>";
				}
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