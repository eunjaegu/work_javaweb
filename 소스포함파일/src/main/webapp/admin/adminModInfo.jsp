	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script src="${contextPath}/util/hobbyConverter.js"></script>

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
	      body {
    background-color: #FFFFE0; /* 황금색 배경 */
    font-size: 14px;
   
  }

	.viewText {
		border: none; 
		background: transparent;
		outline: none;
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
<script>
 $(function() {
	 var chkVal = ["인터넷", "여행", "게임", "영화", "운동"];
	 var arr = ${adminmemOne.hobby}.split("");
	 var out = "";
	 for(let i = 0; i < arr.length; i++) {
		 if(arr[i] == "1") {
			out += "<input type= \"radio\"  name=\"hobby\" value=\"" + chkVal[i] + "\">" + chkVal[i];
		 }
	 }
	 $('#checkbox').html(out);
	 
	$('#form').submit(function(event) {
        event.preventDefault(); // 기본 이벤트 제거
        var hobbySelect = [];
        $('input[name="hobby"]:checked').each(function() { // 체크된 데이터 저장
            hobbySelect.push($(this).val());
        });
        var allHobby = [];
        $('input[type="checkbox"]').each(function() { // 체크박스의 모든 데이터
            allHobby.push($(this).val());
        });
        var conversionHobby = hobbyConverter(hobbySelect, allHobby).toString();
        var result = conversionHobby.replace(/,/g, "");
        $("#hobbys").val(result);
        var formData = new FormData(this);
		$.ajax({
			type:"post",
			async:false,
			url:"<c:url value='/AdminMemModServlet'/>",
			data: formData,
		    processData: false,
		    contentType: false,
			success:function(data, status) {
				alert("성공");
				window.location.replace('${contextPath}/AdminMemServlet');
			},
			error:function(xhr, status, error) {
				alert("잘못 입력 : " + error);
			}
		});
        
	});
 });
</script>
</head>
<body>
<div class="mainDiv">
	<jsp:include page="/admin/adminTop.jsp" flush="false"/>
	
	<div class="subDiv">
<form id="form">
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
				<td>남<input type="radio" value="M" name="gender" <c:if test="${adminmemOne.gender eq 'M' }" > checked="checked"</c:if> />
					여<input type="radio" value="F" name="gender" <c:if test="${adminmemOne.gender eq 'F' }" > checked="checked" </c:if> />
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
			<select name="job" value="<c:out value='${adminmemOne.job }'/>">
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
				<td id="checkbox">
						<input type="hidden" name="hobbys" id="hobbys">
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
	</div>
	
	<jsp:include page="/admin/adminBottom.jsp" flush="false"/>
</div>
</body>
</html>