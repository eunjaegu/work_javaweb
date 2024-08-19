<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.*,java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  />

<link href="${contextPath }/css/style.css" rel="stylesheet" type="text/css">

<form method="post" action="${contextPath }/form.do">
	<table border="1" width="300">
		<tr>
			<td colspan="2">
				Q : ${plBean.getQuestion() }
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
			
			<c:forEach var="itemList" items="${tlist }" varStatus="status">
	 
	 			<c:if test="${plBean.getType() == 1}">
	 				<input type='checkbox' name='itemnum' value='${status.index }'>
	 			</c:if>
	 			
	 			<c:if test="${plBean.getType() == 0}">
	 				<input type='radio' name='itemnum' value='${status.index }'>
	 			</c:if>
	
				${tlist.get(status.index) }<br>
			</c:forEach>
	
			</td>
		</tr>
		
		<tr>
			<td>
				<c:if test="${plBean.getActive() == 1}">
	 				<input type='hidden' name='num' value='${plBean.getNum() }'>
					<input type='submit' value='투표'>
	 			</c:if>
	 			
	 			<c:if test="${plBean.getActive() == 0}">
	 				투표
	 			</c:if>
			</td>
			<td>
				<input type="button" value="결과"  onclick="javascript:window.open('view.do?num=${plBean.getNum() }', 'PollView','width=500, height=350')">
			</td>
		</tr>
	</table>

	<input type="hidden" name="num" value="${plBean.getNum() }">
</form>