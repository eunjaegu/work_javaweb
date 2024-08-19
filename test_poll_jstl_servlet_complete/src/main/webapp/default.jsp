<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<%-- <c:set var="contextPath" value="request.pageContext" /> --%>
<%-- <c:redirect url="${contextPath }/list.do" />     --%>

<c:redirect url="list.do" /> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hidden Main Page</title>
</head>
<body>
                                                                                                     --> 투표 () 
                                                                           --> 설문폼 (pollForm.jsp) --> 결과 (pollView.jsp)
web.xml --> default.jsp --> PollListProc("/poll/list.do") --> pollList.jsp --> 설문리스트 ->  설문제목 (pollList.jsp?num=4)
                                                                           --> 설문 작성하기 (pollInsert.jsp)
</body>
</html>