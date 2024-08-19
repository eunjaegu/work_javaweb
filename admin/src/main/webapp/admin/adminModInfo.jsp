	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>

	<style>
			div{
		width:100%;
		height:100%;
	}
		table {
	        width: 800px; /* 테이블 너비 지정 */
	        margin: auto; /* 가운데 정렬 */
	    }
	     th, td {
	        border: 1px solid black; /* 테두리 스타일 지정 */
	    }
	</style>
</head>
<body>
<form action="<c:url value = '/AdminMemModServlet' />" method="post">
	<table border="1">
		<tbody>
			<tr>	
				<td colspan="4" align=center>회원님의 정보를 수정합니다</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text"  name="id" value="<c:out value="${adminmemOne.id }" />" readonly></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pwd" value="<c:out value="${adminmemOne.pwd }"/>" ></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type ="text" name= "name" value="<c:out value="${adminmemOne.name }"/>"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>남<input type="radio" value="M" name="rButton" <c:if test="${adminmemOne.gender eq 'M' }" > checked="checked"</c:if> />
					여<input type="radio" value="F" name="rButton" <c:if test="${adminmemOne.gender eq 'F' }" > checked="checked" </c:if> />
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type = "text" name="date" value="<c:out value="${adminmemOne.birthday }"/>"> ex)991111</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type= "email" name="email" value="<c:out value="${adminmemOne.email }"/>" ></td>
			</tr>
			<tr>
				<td>우편변호</td>
				<td><input type ="text" name="zipcode" value="<c:out value="${adminmemOne.zipcode }"/>">
				<input type = "Button" value="우편번호찾기"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type ="text" name="address" value="<c:out value="${adminmemOne.address }"/>"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
			<select name="hobby" value="<c:out value="${adminmemOne.job }"/>">
			<option value="1">선택하세요</option>
			<option value="2">회사원</option>
			<option value="3">연구전문직</option>
			<option value="4">교수학생</option>
			<option value="5">일반자영업</option>
			<option value="6">공무원</option>
			<option value="7">의료인</option>
			<option value="8">법조인</option>
			<option value="9">종교 언론/예술인</option>
			<option value="10">농/축/수산/광업인</option>
			<option value="11">주부</option>
			<option value="12">무직</option>
			<option value="13">기타</option>
			
		</select></td>
			</tr>
			<tr>
				<td>취미</td>
				<td><input type= "radio"  name="rButton" value="<c:out value="${adminmemOne.hobby }"/>">인터넷
						<input type= "radio" name="rButton" value="<c:out value="${adminmemOne.hobby }"/>">여행
						<input type= "radio"  name="rButton" value="<c:out value="${adminmemOne.hobby }"/>">게임
						<input type= "radio"  name="rButton" value="<c:out value="${adminmemOne.hobby }"/>">영화
						<input type= "radio"  name="rButton" value="<c:out value="${adminmemOne.hobby }"/>">운동
						</td>
			</tr>
			<tr >
				<td colspan="4" align=center>
					<input type="submit" value="수정완료" onclick="alert('성공')">
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type = "reset" value="다시쓰기">
				</td>
			</tr>
			
			
		
		</tbody>
	</table>
	</form>

</body>
</html>