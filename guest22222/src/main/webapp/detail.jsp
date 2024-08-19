<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
	<script >
		function gotoModify() {
			alert("수정화면 버튼 클릭");
			
			document.location="guest?command=D&idx=1&status=modify.jsp"
		}

		function gotoList() {
			alert("목록 버튼 클릭");
		
			document.location="main.jsp"
		}
		function gotoDelete() {
			alert("글삭제 버튼 클릭");
		
			document.location="guest?command=DEL&idx=1"
		}
	</script>

</head>
<body>
	<input type="button" value="수정화면이동" onclick="gotoModify()" > 
	<!-- modify.jsp(수정화면) => 현재 보여지는 모든 데이터 전송 -->
	
	<input type="button" value="목록으로이동" onclick="gotoList()" >
	<!-- main.jsp로 이동 -->
	
	<input type="button" value="글삭제" onclick="gotoDelete()" >
	<!-- guest?command=DEL&idx=1(글번호1) -->
	
</body>
</html>