<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<script>
	function goList() {
		document.location = "boardList.jsp";
	}
	function goUpdate() {
		document.location = "boardUpdate.jsp";
	}
	function goDelete() {
		document.location = "default.jsp";
	}
</script>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0">
	<th>제목</th>
	<th>동해물과 백두산이 마르고 닳도록</th>
	

	<tr>
	    <td colspan=3>작성자/조회수</td>
	</tr>
		<tr>
	    <td colspan=3>내용~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</td>
	</tr>

	</table>
	<tr>
	<input type="button" value="목록" onclick="goList()">
	<input type="button" value="수정" onclick="goUpdate()">
	<input type="button" value="삭제" onclick="goDelete()">
	</tr>
</body>
</html>