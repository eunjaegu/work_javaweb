<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  />

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Poll</title>
<link href="${contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#FFFFCC">

	<div align="center">
		<br />
		
		<h2>투표프로그램</h2>
		<hr width="600" />
		<b>설문작성</b>
		<hr width="600" />
		
		<form method="post" action="insert.do">
			<table border="1" width="500">
				<tr>
					<td><b>질문</b></td>
					<td colspan="2"><input name="question" size="30"></td>
				</tr>
				<tr>
					<td rowspan="10"><b>항목</b></td>
					<c:forEach var="i" begin="1" end="4" >
						<tr>
							<td> ${i * 2 - 1 } : <input type="text" name='item'></td>
							<td> ${i * 2 } : <input type="text"  name='item'></td>
						</tr>
					</c:forEach>

				<tr>
					<td>시작일</td>
					<td colspan="2">
						<input type="date" id="sDate" max="" min=""  name="sDate">
	
					</td>
				</tr>
				<tr>
					<td>종료일</td>
					<td colspan=2>
						<input type="date" id="eDate" max="" min=""  name="eDate">

					</td>
				</tr>
				<tr>
					<td>복수투표</td>
					<td colspan=2>
						<input type="radio" name="type" value="1" checked>yes 
						<input type="radio" name="type" value="0">no
					</td>
				</tr>
				<tr>
					<td colspan=3>
						<input type="submit" value="작성하기"> 
						<input type="reset" value="다시쓰기"> 
						<input type="button" value="리스트" onClick="javascript:location.href='default.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>