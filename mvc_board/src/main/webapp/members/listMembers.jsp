<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt" %>  

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 : listMembers.jsp</title>
</head>
<body>
	<p class="">회원정보 화면</p>
	<table>
		<tr>
			<td><b>아이디</b></td>
			<td><b>비밀번호</b></td>
			<td><b>이름</b></td>
			<td><b>이메일</b></td>
			<td><b>가입일</b></td>
			<td><b>수정</b></td>
			<td><b>삭제</b></td>
		</tr>
	
		<c:choose>
		<c:when test="${empty membersList}">
		<tr>	<!-- 회원정보가 없을 때 -->
			<td colspan="7">등록된 회원이 없습니다.</td>
		</tr>
		</c:when>
		
		<c:when test="${!empty membersList}">
		<c:forEach var="mem" items="${membersList}">
		<tr>	<!-- 회원정보가 있을 때 -->
			<td>${mem.id }</td> <!-- 아이디 -->
			<td>${mem.pwd }</td> <!-- 비밀번호 -->
			<td>${mem.name }</td> <!-- 이름 -->
			<td>${mem.email }</td> <!-- 이메일 -->
			<td>${mem.joindate }</td> <!-- 가입일 -->
			<td>
				<a href="${contextPath} }/member/memberForm.do?id=${mem.id }">수정</a>
			</td> <!-- 수정링크 -->
			<td>
				<a href="${contextPath} }/member/delMember.do?id=${mem.id }">삭제</a>
			</td> <!-- 삭제링크 -->
		</tr>
		</c:forEach>
		</c:when>
	</c:choose>
	</table>
	<a href="${contextPath}/member/memberForm.do"><p>회원가입</p></a>
</body>
</html>