<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>overlappedID.jsp</title>
<style>
	p {
		font-size: 15px;
	}
	div {
		display: flex;
    	justify-content: center;
    	align-items: center;
    	flex-direction: column;
   		width: 100%;
    	height: 100%;
	}
	#focus {
		cursor: pointer;
	}
</style>
</head>
<body>
	<div>
	<c:choose>
		<c:when test="${param.data eq 'not_usable' }">
			<span><b>${param.id }</b> 는 사용중인 ID 입니다.</span><br>
			<span id="focus" onclick="window.close();">닫기</span>
		</c:when>
		<c:otherwise>
			<span><b>${param.id }</b> 는 사용가능한 ID 입니다.</span><br>
			<span id="focus" onclick="window.close();">닫기</span>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>