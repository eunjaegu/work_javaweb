<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">
<style>
    div form table {
        width: 300px;
        margin-top: 20px;
        margin-bottom: 20px;
	  	align-content: center;
	  	width: 100%;
	  	height: 100%;
    }
    th, td {
        border: 1px solid black; /* 테두리 스타일 지정 */
        padding: 8px; /* 셀 안의 여백 지정 */
        text-align: center; /* 텍스트 가운데 정렬 */
    }
    body {
    background-color: #FFFFE0; /* 황금색 배경 */
    font-size: 14px;
   
  }
	table { 
    border-collapse: collapse; /* 셀 사이 간격 없애기 */
   
    background-color: #FFFFE0; /* 연한 황금색 배경 */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); /* 그림자 효과 */
     border: 3px solid #FFD700; /* 황금색 가장자리 테두리 */
	}
	td {
	
        
        vertical-align: top;
        border: 1px solid;
    }
    th {
    
    	border: 1px solid;
    }
     thead tr {
    background-color: #a95e13; /* 테이블 머리글 배경색 */
    color: #fff; /* 텍스트 색상 */
  }
</style>
	<script src="http://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		/** 로그인 확인 **/
		$(function() {
			// 로그인 데이터 전송
			 $("#login").submit(function(event){
	                event.preventDefault(); // 기본 이벤트 제거
	                var formData = $(this).serialize(); // 폼 데이터 가져오기
	                $.ajax({
	                    url: "<c:url value='/memLogin'/>",
	                    type: "post",
	                    data: formData,
	                    dataType: "text",
	                    success: function(data){
	                    	if(data == "success")
	                    		window.location.replace("${contextPath}/loginCheck");
	                    	else if(data == "fail")
	                    		window.location.href = "${contextPath}/util/loginFail.jsp";
	                    	else if(data =="already"){
	                    		Swal.fire("이미 로그인 중입니다.");
	                    		window.location.replace("${contextPath}/members/memHome.jsp");
	                    	} else {
	                    		Swal.fire("비정상 접근입니다.");
	                    		window.location.replace("${contextPath}/loginCheck");
	                    	}
	                    },
	                    error: function(xhr, status, error){
	                        console.log("Error: " + error);
	                    }
	                });
	            });
		});
	</script>
</head>
<body>
<div class="mainDiv">
	<jsp:include page="/members/memTop.jsp" flush="false"/>
	
<div class="subDiv">
	<form id="login" >
	<table border="1">
		<tbody>
			<tr>
				<td colspan="4" align=center>로그인</td>
			</tr>
			<tr>
				<td>ID</td><td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Password</td><td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="4" align=center><input type="submit"  value="login">
					<input type="hidden" name="val" value="no">
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="password">
				</td>
			</tr>
		</tbody>
	</table>
	</form>	
</div>
	
	<jsp:include page="/members/memBottom.jsp" flush="false"/>
</div>
</body>
</html>