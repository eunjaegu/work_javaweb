	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:choose>

</c:choose>

<style>
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
<form action="" >
	<table border="1" items="${ MemModel}">
		<tbody>
		<c:forEach var="mem">
			<tr>	
				<td colspan="4" align=center>회원님의 정보를 수정합니다</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="hidden" name="id" ></td>
				<c:out value="${mem.name }" /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="text" name="password">
				<c:out value="${mem.pwd }" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name">
				<td><c:out value="${mem.name }" /></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>	남<input type= "radio" value="M" name="rButton">
						여<input type= "radio" value="F" name="rButton"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type = "text" name="date"> ex)991111</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type= "email" name="email"  ></td>
			</tr>
			<tr>
				<td>우편변호</td>
				<td><input type ="text" name="postalCode">
				<input type = "submit" value="우편번호찾기"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type ="text" name="address"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
			<select name="selone">
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
				<td><input type= "radio"  name="rButton">인터넷
						<input type= "radio" name="rButton">여행
						<input type= "radio"  name="rButton">게임
						<input type= "radio"  name="rButton">영화
						<input type= "radio"  name="rButton">운동
						</td>
			</tr>
			<tr >
				<td colspan="4" align=center>
					<input type = "submit" value="수정완료">
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type = "reset" value="다시쓰기">
				</td>
			</tr>
			
			
		</c:forEach>
		</tbody>
	</table>
	</form>

</body>
</html>