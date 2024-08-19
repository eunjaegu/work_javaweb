<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
<script>
	function goList() {
		document.location = "boardList.jsp";
	}
	function goInsert() {
		document.location = "boardList.jsp";
	}
</script>
</head>
<body>
		<label>작성자</label>
		<input type="text" name="name" ><br>
		<label>제 목</label>
		<input type="text" name="title"  ><br>
		<label>내 용</label><br>
		<textarea rows="10" cols="50" name="content"></textarea><br>
		<input type="hidden" name="command" value="U" >
		<input type="hidden" name="idx"  >
		
	</form>

	</table>
	<tr>
	<input type="button" value="목록" onclick="goList()">
	<input type="button" value="수정하기" onclick="goList()">
	</tr>
</body>
</html>