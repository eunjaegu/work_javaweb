<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Poll:수정</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#FFFFCC">
	<div align="center">
		<table border="1" width="350">
			<tr>
				<td colspan="4"><b>Q :${plBean.getQuestion() }</b></td>
			</tr>
			
			<tr>
				<td colspan="3"><b>총 투표자 :  ${sum } 명</b></td>
				<td width="40">count</td>
			</tr>
			
			<c:forEach var="piBean" items="${alist }" varStatus="status">
				<tr>
						<td width="20" align="center">${status.count }</td>
						
						<c:set var="item" value="${piBean.getItem() }"></c:set>
						
						<td width="120">${item[0] }</td>
						<td>
								<table width="${piBean.getRatio() }" height="15">
									<tr>
										<td bgcolor="${piBean.gethRGB() }"></td>
									</tr>
								</table>
						</td>
						<td width="40">${piBean.getCount() }</td>
					</tr>
			</c:forEach>
			
		</table>
		
		<p />
		<a href="javascript:window.close()">닫기</a>
	</div>
</body>
</html>