	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">
	<script src="http://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="${contextPath}/util/hobbyConverter.js"></script>
	<script>
		/** 아이디 중복 체크 **/
		function id_process() {
			let _id = $("#t_id").val();
			
			// 정규 표현식 : 한글 입력 불가
			const regExp = /[a-zA-Z0-9]/g;

			// 아이디 중복 체크
			if(regExp.test(_id)) {
				$.ajax({
					type:"get",
					async:false,
					url:"<c:url value='/memberJoin'/>",
					dataType:"text",
					data:{id: _id},
					success:function(data, status) {
						window.open("../util/overlappedID.jsp?data=" + data + "&id=" + _id, "_blank", "width=400, height=100");
						if(data == 'usable')
							 $('#btn_confirm').prop("disabled", false);
						else
							 $('#btn_confirm').prop("disabled", true);
					},
					error:function(xhr, status, error) {
						alert("잘못 입력 : " + error);
					}
				});
			} else  {
				swal.fire("영문 또는 숫자를 입력해주세요");
				 $('#btn_confirm').prop("disabled", true);
			} // if() end

		} // fn_process() end
		
		// 우편 찾기 팝업 호출
		function zip_process() {
			window.open('../util/postalCode.jsp', 'popupWindow', 'width=500, height=350');
		} // zip_process() end
		
		// 주소 데이터 수신 후 출력
		function receiveData(zipcode, area1, area2, area3) {
			$('#zipcode').val(zipcode);
			$('#address').val(area1 + " " + area2 + " " + area3);
		} // reciveData() end
		
		/** ready **/
		$(function() {
			 var chkVal = ["인터넷", "여행", "게임", "영화", "운동"];
			 var arr = ${member.hobby}.split("");
			 var out = "";
			 for(let i = 0; i < arr.length; i++) {
				 if(arr[i] == "1") {
					out += "<input type= \"radio\"  name=\"hobby\" value=\"" + chkVal[i] + "\">" + chkVal[i];
				 }
			 }
			 $('#checkbox').html(out);
			
			
			// 확인 완료 버튼 클릭 시
			$('#join').submit(function(event) {
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
                $("#sendHobby").val(result);
                var formData = $(this).serialize(); // 폼 데이터 가져오기
				$.ajax({
					url:"<c:url value='/memberJoin'/>",
					type:"post",
					async:false,
					data: formData,
					dataType: "text",
					success:function(data, status) {
						alert("성공");
						window.location.replace('${contextPath}/loginCheck');
					},
					error:function(xhr, status, error) {
						alert("잘못 입력 : " + error);
					}
				});
			});
		});
		
		
	</script>
<style>
	 table {
     	font-size: 11pt;
     	width: 100%;
        margin: auto; /* 가운데 정렬 */
    }
     th, td {
        border: 1px solid black; /* 테두리 스타일 지정 */
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
</head>
<body>
<div class="mainDiv">
	<jsp:include page="/members/memTop.jsp" flush="false"/>
	
	<div class="subDiv">
		<form id="join">
			<table border="1">
				<colgroup>
					<col width="">
					<col width="">
				</colgroup>
				<thead>
					<tr>
						<th colspan="2" id="title">회원님의 정보를 수정합니다</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>
							<input id="t_id" type="text" name="id" value="${member.id }" readonly>
							<input type="button" value="ID중복확인" onclick="id_process()">
						</td>
					</tr>
					
					<tr>
						<td>패스워드</td>
						<td>
							<input  name="pwd" id="pwd" type="password" value="${member.pw }" required>
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>
							<input  name="name" type="text" value="${member.name }" required>
						</td>
					</tr>
					
					<tr>
						<td>성별</td>
						<td>
							남<input type="radio" value="M" name="gender" <c:if test="${member.gender eq 'M' }" > checked="checked"</c:if> />
							여<input type="radio" value="F" name="gender" <c:if test="${member.gender eq 'F' }" > checked="checked" </c:if> />
						</td>
					</tr>
					
					<tr>
						<td>생년월일</td>
						<td>
							<input  class="input" type="text" maxlength="6" name="birthday" style="width: 70px;" value="${member.birthday }"  required>&nbsp;ex&#41;830815
						</td>
					</tr>
					
					<tr>
						<td>이메일</td>
						<td>
							<input  type="email" name="email" value="${member.email }" required>
						</td>
					</tr>
					
					<tr>
						<td>우편번호</td>
						<td>
							<input  id="zipcode" type="text"  name="zipcode" style="width: 40px;" value="${member.zipcode }" required>
							<input  type="button" value="우편번호찾기" onclick="zip_process()" >
						</td>
					</tr>
					
					<tr>
						<td>주소</td>
						<td>
							<input  id="address" type="text" name="address" style="width: 280px;" value="${member.address }" required>
						</td>
					</tr>
					
					<tr>
						<td>직업</td>
						<td>
							<select name="job" value="${member.job }" >
								<option selected="selected">선택하세요.</option>
								<option>회사원</option>
								<option>연구전문직</option>
								<option>교수학생</option>
								<option>일반자영업</option>
								<option>의료인</option>
								<option>법조인</option>
								<option>종교,언론/예술인</option>
								<option>농/축/수산/광업인</option>
								<option>주부</option>
								<option>무직</option>
								<option>기타</option>
							</select>					
						</td>
					</tr>
					
					<tr>
						<td>취미</td>
						<td id="checkbox">
							<input id="sendHobby" name="hobbys" type="hidden">
						</td>
					</tr>
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="3" style="text-align: center;">
							<input id="btn_confirm" type="submit" value="수정하기" style="margin-right: 60px;" />
							<input type="reset" value="다시쓰기" />
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
</div>
	
	<jsp:include page="/members/memBottom.jsp" flush="false"/>
</div>

</body>
</html>