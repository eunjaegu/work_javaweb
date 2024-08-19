<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt" %> 
<jsp:useBean id="member" class="com.ej.beans.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="member"></jsp:setProperty>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전달된 파라미터 명과 MemberBean의 멤버 변수를 자동으로 매핑</title>
</head>
<body>
<!-- 멤버 명과 파라매터 명이 같기 때문에 *로 불러올 수 있음 -->
			
			<table>
			<tr>
				<td>이름</td>
				<td><jsp:getProperty property="name" name="member"/></td>
				
			</tr>
			<tr>
				<td>아이디</td>
				<td><jsp:getProperty property="userid" name="member"/></td>
			</tr>
			<tr>
				<td>별명</td>
				<td><jsp:getProperty property="nickname" name="member"/></td>
				
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><jsp:getProperty property="pwd" name="member"/></td>
			</tr>	
			<tr>
				<td>이메일</td>
				<td><jsp:getProperty property="email" name="member"/></td>
			</tr>	
			<tr>
				<td>연락처</td>
				<td><jsp:getProperty property="phone" name="member"/></td>
			</tr>		
			
		</table>
	${member}
</body>
</html>