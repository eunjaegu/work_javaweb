<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.freeflux.guest.dto.Guest" %>    
<%
	List<Guest> glist = (List<Guest>)request.getAttribute("glist"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
	<script>
		function goURL(){
			document.location="write.jsp";
		}
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
			
	
	<table border="1" cellpadding="5" cellspacing="0">>
	<% if(glist.size() < 1) { %>
		<tr><td>게시글이 없습니다..</td></tr>
	<% }else{ %>
			<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			</tr>
			<% for(Guest guest : glist){%>
				<tr>
				<td><%= guest.getIdx() %></td>
				<td>
				<a href="guest?command=D&status=detail&idx=<%= guest.getIdx() %>" >
					<%= guest.getTitle() %>
				</a>
				</td>
				<td><%= guest.getName() %></td>
				<td><%= guest.getMoment() %></td>
				<td><%= guest.getHit() %></td>
				</tr>
			<%}%>
	 <%} %>
	</table>
		<tr>
	    <td><이전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 2 3 4 5 6 7 8&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;다음></td>
	    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td colspan="6"><input type="button" value="목록" onclick="goList()"></td>
		<input type="button" value="글쓰기" onclick="goURL()">
	</tr>
		
</body>
</html>








