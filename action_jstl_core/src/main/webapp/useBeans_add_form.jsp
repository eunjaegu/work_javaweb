<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="useBeans_result.jsp" method="post">
	
		<table>
		<h2>입력된 값을 member 객체로부터 추출</h2>
			<tr>
				<td>이름</td>
				<td><input type="text"  name="name" size="20" /></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text"  name="userid" size="20" /></td>
			</tr>
			<tr>
				<td>별명</td>
				<td><input type="text"  name="nickname" size="20" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password"  name="pwd" size="20" /></td>
			</tr>	
			<tr>
				<td>이메일</td>
				<td><input type="email"  name="email" size="20" /></td>
			</tr>	
			<tr>
				<td>연락처</td>
				<td><input type="text"  name="phone" size="20" /></td>
			</tr>		
			
			<tr>
				<td><input type="submit" value="전송" /></td>
				<td><input type="reset" value="입력취소" /></td>
			</tr>
		</table>
	</form>
</body>
</html>