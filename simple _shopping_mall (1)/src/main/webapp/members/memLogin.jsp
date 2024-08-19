<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    table {
      
        width: 300px; /* 테이블 너비 지정 */
        margin: auto; /* 가운데 정렬 */
    }
    th, td {
        border: 1px solid black; /* 테두리 스타일 지정 */
        padding: 8px; /* 셀 안의 여백 지정 */
        text-align: center; /* 텍스트 가운데 정렬 */
    }
  
</style>
</head>
<body>
<form action="" >
<table border="1">
	<tbody>
		<tr>
			<td colspan="4" align=center>로그인</td>
		</tr>
		<tr>
			<td>ID</td><td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>Password</td><td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td colspan="4" align=center><input type="submit"  value="login">
			
			  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="password">
			</td>
		</tr>
	</tbody>
</table>
</form>
</body>
</html>