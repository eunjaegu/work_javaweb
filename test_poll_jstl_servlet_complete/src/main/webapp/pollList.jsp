<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.beans.*,java.util.*"%>

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
		<br/>
		<h2>투표프로그램</h2>
		<hr width="600"/>
		<b>설문폼</b>
		
		<!--폴 리스트 폼 자리-->
		<jsp:include page="pollForm.jsp" />
		<hr width="600"/>
		
		
		<b>설문리스트</b>
		
		<!--폴 리스트 테이블 자리-->
		<table>
			<tr>
				<td>
					<table width="500" border="1">
						<tr>
							<td align="center"><b>번호</b></td>
							<td align="center"><b>제목</b></td>
							<td align="center"><b>시작일~종료일</b></td>
						</tr>
						
						<c:forEach var="plBean"  items="${alist }">
							<tr><td align='center'> ${plBean.getNum() } </td>
							<td><a href='${contextPath }/list.do?num=${plBean.getNum() }'> ${plBean.getQuestion() } </a></td>
							<td> ${plBean.getSdate() }  ~  ${plBean.getEdate() } </td></tr>
						</c:forEach>

					</table>
				</td>
			</tr>
			<tr>
				<td align="right"><a href="${contextPath }/pollInsert.jsp">설문 작성하기</a></td>
			</tr>
		</table>
	</div>
</body>
</html>