<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List, com.freeflux.guest.dto.Guest"%>
<%
List<Guest> gdetail = (List<Guest>) request.getAttribute("gdetail");
%>   
<%=gdetail.size() %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<script>
	function gotoModify() {
		document.location="guest?command=D&idx=1&status=modify";
	}
	function gotoList() {
		document.location="main.jsp";
	}
	function gotoDelete() {
		document.location="guest?command=DEL&idx=1";
	}
	
</script>
</head>
<body>
글상세 <br>
	<%=gdetail.get(0).getIdx()%>
	<%=gdetail.get(0).getTitle()%>
	<%=gdetail.get(0).getName()%>
	<%=gdetail.get(0).getContent()%>
	<%=gdetail.get(0).getMoment()%>
	<%=gdetail.get(0).getHit()%> 
	<br>
	
	<input type="button" value="수정화면이동" onclick="gotoModify()" >
	<!-- modify.jsp => 현재 보여지는 모든 데이터 전송 -->
	
	<input type="button" value="목록화면이동" onclick="gotoList()"  >
	<!-- main.jsp -->
	
	<input type="button" value="글삭제" onclick="gotoDelete()"  >
	<!-- guest?command=DEL&idx=1 -->
	<br>
</body>
</html>






