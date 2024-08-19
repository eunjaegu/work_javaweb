<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정 : modMemberForm.jsp</title>

</head>
<body>
	<form action="">
	<p>회원수정화면</p>
		<table>
			<tr>
				<td>아이디</td> <!-- 아이디 수정 불가! -->
				<td>
					<input type="text" name="id" value="" disabled >
				</td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pwd" value="">
				</td>
			</tr>	
		
			
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" value="">
				</td>
			</tr>
			
			<tr>
				<td>이메일</td>
				<td>
					<input type="email" name="email" value="">
				</td>
			</tr>
			
			<tr>
				<td><input type="submit" value="수정"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		
		
		</table>
	
	</form>
</body>
</html>