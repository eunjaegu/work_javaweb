<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.guest.dto.Guest" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
글수정 
<hr>
	<form action="guest">
		<label>작성자</label>
		<input type="text" name="name" value=" ${guest1.getName()}" readOnly><br>
		<label>제 목</label>
		<input type="text" name="title" value="${guest1.getTitle()}"><br>
		<label>내 용</label><br>
		<textarea rows="10" cols="50" name="content">${ guest1.getTitle()}</textarea><br>
		<input type="hidden" name="command" value="U" >
		<input type="hidden" name="idx" value="${ guest1.getIdx()}" >
		<input type="submit" value="수정저장" >
	</form>
</body>
</html>