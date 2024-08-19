<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.freeflux.guest.dto.Guest"%>
<%
List<Guest> glist = (List<Guest>) request.getAttribute("glist");
%>
<%=glist.size()%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<script>
	function goURL() {
		document.location = "write.jsp";
	}
</script>
</head>
<body>

	<table>
		<%
		if (glist.size() < 1) {
		%>
		<tr>
			<td>게시글이 없습니다..</td>
		</tr>
		<%
		} else {
		%>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<%
		for (Guest guest : glist) {
		%>
		<tr>
			<td><%=guest.getIdx()%></td>
			<td><td><a href="guest?status=detail&command=D&idx=<%=guest.getIdx()%>">
				<%=guest.getTitle()%></a></td></td>
			<td><%=guest.getName()%></td>
			<td><%=guest.getMoment()%></td>
			<td><%=guest.getHit()%></td>
		</tr>
		<%
		}

		}
		%>
	</table>

	<input type="button" value="글쓰기" onclick="goURL()">
</body>
</html>








