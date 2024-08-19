<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="guest">
		<label>작성자</label>
		<input type="text" name="name" ><br>
		<label>제 목</label>
		<input type="text" name="title" ><br>
		<label>내 용</label><br>
		<textarea rows="10" cols="50" name="content"></textarea><br>
		<input type="hidden" name="command" value="W" >
		<input type="submit" value="신규저장" >
	</form>
</body>
</html>