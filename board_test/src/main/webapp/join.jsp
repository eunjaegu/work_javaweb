<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
<form action="main">
	<fieldset>
		<legend>로그인 체크</legend>
		<label>아이디</label>
		<input type="text" name="id" placeholder="영문8글자" required>
		<br> 
		<label>비밀번호</label>
		<input type="password" name="pw" placeholder="영문8글자" required>
		<br>
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
	</fieldset>
</form>
<div>

</div>
</body>
</html>