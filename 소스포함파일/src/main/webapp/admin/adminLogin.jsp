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
	                    url: "<c:url value='/adminLogin'/>",
	                    type: "post",
						async:false,
	                    data: formData,
	                    dataType: "text",
	                    success: function(data){
	                    	if(data == "success")
	                    		window.location.replace("${contextPath}/loginCheck");
	                    	else if(data == "fail")
	                    		window.location.href = "${contextPath}/util/loginFail.jsp";
	                    	else if(data =="already"){
	                    		Swal.fire("이미 로그인 중입니다.");
	                    		window.location.replace("${contextPath}/admin/adminHome.jsp");
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
<style>
	div {
		display: flex;
	    justify-content: center; /* 가로 중앙 정렬 */
	    align-items: center; /* 세로 중앙 정렬 */
	    margin-top: 70px; /* 상단과 하단에 여백 추가 */
	    flex-direction: column;
	    width: 100%;
	    height: 50vh;
	}
	table {
		width: 70vh;
		height: 30vh;
	}
	
</style>
</head>
<body>
<div>
	<form id="login" style="height: 100%;">
		<table  border="1">
			<tbody>
				<tr>
					<td colspan="4" align=center>관리자로그인</td>
				</tr>
				<tr>
					<td>Admin ID</td><td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Admin Password</td><td><input type="password" name="pw"></td>
				</tr>
				<tr>
					
					<td colspan="4" align=center><input type="hidden" name="val" value="no"><input type="submit" value="login">
					
					  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="reset">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>