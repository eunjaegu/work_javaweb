<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
	<script>
		function goURL() {
			alert("글쓰기 버튼 클릭");
			
			
			
			document.location="write.jsp";
		}
	</script>
</head>
<body>
	<a href="guest?command=D&status=detail">title1:글제목</a>
	 
	 <input type="button" value="글쓰기" onclick="goURL()">
</body>
</html>