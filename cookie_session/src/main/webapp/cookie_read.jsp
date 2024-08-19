<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Cookie[] cookies = request.getCookies();
	//request.getCookies() 웹 브라우저에 있는 Cookie 객체들을 배열로 반환
	// 자바객체
	pageContext.setAttribute("idPage", getCookies(cookies, "id"));
	pageContext.setAttribute("namePage", getCookies(cookies, "name"));
	pageContext.setAttribute("agePage", getCookies(cookies, "age"));
%>
<%!	//JSP 내에 선언할 경우 사용
	private String getCookies(Cookie[] cookies, String cookieName){
		String value = null;
		
		if(cookies==null){
			return null;
		}
		
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(cookieName)){
				// cookie.getName() 쿠키 이름 반환
				return cookie.getValue();	// 쿠키 값을 반환
			}
		}
		
		return null;
}    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키 데이터 읽기</h3>
	<hr>
	기본 JSP 문법으로 읽기 <br>
	<hr>
	아이디 : ${ idPage }
	이름 : ${ namePage }
	나이 :  ${ agePage }
</body>
</html>