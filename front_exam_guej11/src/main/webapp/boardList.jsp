<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
	<script>
		function goList() {
			document.location = "boardList.jsp";
		}
	</script>
	<script>
		function goURL() {
			document.location="boardInsert.jsp";
		
	</script>
</head>
<body>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<select name="selone">
				<option value="1">전체</option>
				<option value="2">번호</option>
				<option value="3">제목</option>
				<option value="4">작성자</option>
				<option value="5">등록일</option>
				<option value="6">조회</option>
			</select> 
			<input type="text" name="ID" required="required" />
			<input type="button" value="검색" onclick="">
			</tr>
			

	<table border="1" cellpadding="5" cellspacing="0">

	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>등록일</th>
	<th>조회</th>
	<tr>
	
	    <td><center>1</center></td>
	    <td><a href="http://localhost:9000/front_exam_guej11/boardDetail.jsp">동해물과 백두산이 마르고 닳도록 하느님이...</td>
	    <td>김연석</td>
	    <td>2013.06.19</td>
	    <td><center>100</center></td>
	</tr>
	<tr>
	    <td><center>2</center></td>
	    <td><a href="http://localhost:9000/front_exam_guej11/boardDetail.jsp">동해물과 백두산이 마르고 닳도록 하느님이...</td>
	    <td>홍길동</td>
	    <td>2013.06.19</td>
	    <td><center>90</center></td>
	</tr>
	<tr>
	    <td><center>3</center></td>
	    <td><a href="http://localhost:9000/front_exam_guej11/boardDetail.jsp">동해물과 백두산이 마르고 닳도록 하느님이...</td>
	    <td>김수지</td>
	    <td>2013.06.19</td>
	    <td><center>80</center></td>
	</tr>
	<tr>
	    <td><center>4</center></td>
	    <td><a href="http://localhost:9000/front_exam_guej11/boardDetail.jsp">동해물과 백두산이 마르고 닳도록 하느님이...</td>
	    <td>김동구</td>
	    <td>2013.06.19</td>
	    <td><center>70</center></td>
	</tr>
	<tr>
	    <td><center>5</center></td>
	    <td><a href="http://localhost:9000/front_exam_guej11/boardDetail.jsp">동해물과 백두산이 마르고 닳도록 하느님이...</td>
	    <td>.</td>
	    <td>.</td>
	    <td>.</td>
	</tr>
	<tr>
	    <td><center>6</center></td>
	    <td><a href="http://localhost:9000/front_exam_guej11/boardDetail.jsp">..........</td>
	    <td>.</td>
	    <td>.</td>
	    <td>.</td>
	</tr>
	<tr>
	    <td><center>7</center></td>
	    <td><a href="http://localhost:9000/front_exam_guej11/boardDetail.jsp">....................</td>
	    <td>.</td>
	    <td>.</td>
	    <td>.</td>
	</tr>
	<tr>
	    <td><center>8</center></td>
	    <td><a href="http://localhost:9000/front_exam_guej11/boardDetail.jsp">............</td>
	    <td>.</td>
	    <td>.</td>
	    <td>.</td>
	</tr>
	<tr>
	    <td><center>9</center></td>
	    <td><a href="http://localhost:9000/front_exam_guej11/boardDetail.jsp">..............................</td>
	    <td>.</td>
	    <td>.</td>
	    <td>.</td>
	</tr>
	<tr>
	    <td><center>10</center></td>
	    <td><a href="http://localhost:9000/front_exam_guej11/boardDetail.jsp">......................</td>
	    <td>.</td>
	    <td>.</td>
	    <td>.</td>
	</tr>
	
	 
	 </table>
	
	<tr>
	    <td><이전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 2 3 4 5 6 7 8&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;다음></td>
	    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td colspan="6"><input type="button" value="목록" onclick="goList()"></td>
		<input type="button" value="글쓰기" onclick="goURL()">
	</tr>
</body>

</html>