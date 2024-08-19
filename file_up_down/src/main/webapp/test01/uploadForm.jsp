<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%-- EL 표기법을 안정되게 사용하려면 page 지시자에 isELIgnored 속성을 false 로 설정.--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt" %>

<%-- 파일 업로드 (JSP에서 할 일)
	1. 요청 경로 확인 pageContext.request.contextPath
	
	2. 요청 경로를 저장 <c:set var="" value=""></c:set> 를 이용
	
	3. form태그의 속성 중 encType의 값을 multipart/form-data 로 설정
	
	4. input 태그의 type 속성을 file 로 설정
	
	5. 전송 버튼을 이용하여 서블릿에 전달
--%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<% 
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 화면</title>
</head>
<body>
	<form action="${contextPath}/Upload.do" method="post" enctype="multipart/form-data">
		업로드 파일 선택 1 : <input type="file" name="file1"><br>
		업로드 파일 선택 2 : <input type="file" name="file2">
		매개변수 1 : <input type="text" name="param1"><br>
		매개변수 2 : <input type="text" name="param2"><br>
		매개변수 3 : <input type="text" name="param3"><br>
		<input type="submit" value="파일 업로드">
	</form>
</body>
</html>


