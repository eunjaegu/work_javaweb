<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<% 
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<c:set var="file1" value="${param.param1}"></c:set>
	<c:set var="file2" value="${param.param2}"></c:set>
	
	<title>이미지 파일 출력 : first.jsp=> FileDownload (download.do)</title>
</head>
<body>
	<pre>
		1. 이미지 파일 표시창에서 <img> 태그의 src속성에
		다운로드 할 요청 url pattern 명(download.do)을 이용하여 요청
		파일이름을 get 방식으로 전송
		2. 다운로드한 이미지 파일을 <img> 태그에 출력
		3. <a href=""></a>를 이용하려 사용자가 이미지를 클릭 했을 때 다운로드할 수 있도록...
		4. 파일 전체를 로컬 PC의 다운로드 폴더에 저장
		
		1. 다운로드할 파일 이름을 추출
		2. 파일 이름으로 서블릿에서 이미지를 다운로드하여 출력
		2. 파일 이름으로 서블릿에서 이미지를 다운로드하여 출력(이미지2개시)
		4. 이미지 파일 다운로드...
	</pre>
	<!-- 1. -->
	파라미터 1 : <c:out value="${file1}"></c:out>
	파라미터 2 : <c:out value="${file2}"></c:out>
	
	<!-- 2. -->
	<c:if test="${not empty file1}">
		<img src="${contextPath}/download.do?fileName=${file1}" width="300" height=""><br>
	</c:if>
	
	<!-- 3. -->
	<c:if test="${not empty file2}">
		<img src="${contextPath}/download.do?fileName=${file2}" width="300" height=""><br>
	</c:if>
	
	<!-- 4. -->
	파일 다운로드 : <br>
	<a href="${contextPath}/download.do?fileName=${file1}">파일1 내려받기"</a>
	<a href="${contextPath}/download.do?fileName=${file2}">파일2 내려받기"</a>
</body>
</html>






