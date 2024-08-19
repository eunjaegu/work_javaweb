<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 메시지 출력 페이지 : error.jsp</title>
</head>
<body>
	<h2>처리 중 문제가 발생했습니다.~~</h2>
	
	<table>
		<tr bgcolor="beige">
			<td width="500">
				관리자에게 문의 해주세요~<br>
				빠른 시일 내에 복구하겠습니다..<br>
				어떤 숫자를 0으로 나루 수는 없습니다..~~
				<hr>
				<%= exception.toString() %>
				<!-- exception : JSP 내장 객체 -->
				<hr>
			</td>		
		</tr>
	</table>
</body>
</html>