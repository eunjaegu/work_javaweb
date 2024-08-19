<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
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
		
		function restart() {
            $('.input').prop("disabled", false);		// input 값 변경 가능
            $('.input').prop("color", "#000");			// input 글씨색
            $("table tbody tr td._td").show();			// 설명란 보이기
            var checkboxes = document.querySelectorAll('input[type="checkbox"]');
           	for (var i = 0; i < checkboxes.length; i++) {
                if (!checkboxes[i].checked) {
                    $("table tbody tr td input.chk"+i).show();
                    $("table tbody tr td label.chk"+i).show();
                }		
           	}
            $('#btn_submit').hide();
            $('#btn_confirm').show();
            $('#btn_submit').val("회원가입");
            $('#title').html("회원가입");
		}
		
		/** ready **/
		$(function() {
            $('#btn_submit').hide();
			// 암호확인 기능 구현
			$('#pwd_confirm').keyup(function() {
				if($('#pwd').val() != $('#pwd_confirm').val()) {
					$('#pwd_message').text('');
					$('#pwd_message').html("<b>비밀번호가 틀립니다.</b>");
					$('#btn_confirm').prop("disabled", true);
				}else {
					$('#pwd_message').text('');
					$('#pwd_message').html("<b>비밀번호가 맞습니다.</b>");
					$('#btn_confirm').prop("disabled", false);
				}
			});
			
			// 회원가입 버튼 클릭 시
			$('#btn_confirm').click(function(event) {
                event.preventDefault(); // 기본 이벤트 제거
                var formData = new FormData(document.getElementById("join"));
                var checkboxes = document.querySelectorAll('input[type="checkbox"]');
				
                // 선택안된 체크박스 숨기기
               	for (var i = 0; i < checkboxes.length; i++) {
                    if (!checkboxes[i].checked) {
                        $("table tbody tr td input.chk"+i).hide();
                        $("table tbody tr td label.chk"+i).hide();
                    }		
				}
                $('.input').prop("readonly", true);			// input 값 변경 불가
                $('.input').prop("color", "#999");			// input 글씨색
                
                var rows = document.querySelectorAll('table tbody tr');
               
                $("table tbody tr td._td").hide();
                $('#btn_confirm').hide();
                $('#btn_submit').show();
                $('#title').html(formData.get('name')+ " 회원님이 작성하신 내용입니다. 확인해주세요.");
                $('#btn_reset').click(function() {
                    restart();
                });
				$('#pwd_message').text('');
			});
			
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
					<col width="">
				</colgroup>
				<thead>
					<tr>
						<th colspan="3" id="title">회원 가입</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>
							<input class="input" id="t_id" type="text" name="id" required>
							<input type="button" value="ID중복확인" onclick="id_process()">
						</td>
						<td class="_td">아이디를 적어 주세요.</td>
					</tr>
					
					<tr>
						<td>패스워드</td>
						<td>
							<input class="input" name="pwd" id="pwd" type="password" required>
						</td>
						<td class="_td">패스워드를 적어주세요.</td>
					</tr>
					
					<tr>
						<td>패스워드 확인</td>
						<td>
							<input class="input" id="pwd_confirm" name="pwd_confirm" type="password" required>
							<span id="pwd_message"></span>
						</td>
						<td class="_td">패스워드를 확인합니다.</td>
					</tr>
					
					<tr>
						<td>이름</td>
						<td>
							<input class="input" name="name" type="text" required>
						</td>
						<td class="_td">고객실명을 적어주세요.</td>
					</tr>
					
					<tr>
						<td>성별</td>
						<td>
							<input class="input" type="radio" name="gender" value="M" checked="checked">남자
							<input class="input" type="radio" name="gender" value="F" >여자
						</td>
						<td class="_td">성별을 선택하세요.</td>
					</tr>
					
					<tr>
						<td>생년월일</td>
						<td>
							<input class="input" class="input" type="text" maxlength="6" name="birthday" style="width: 70px;" required>&nbsp;ex&#41;830815
						</td>
						<td class="_td">성별을 선택하세요.</td>
					</tr>
					
					<tr>
						<td>이메일</td>
						<td>
							<input class="input" type="email" name="email" required>
						</td>
						<td class="_td">이메일을 적어주세요.</td>
					</tr>
					
					<tr>
						<td>우편번호</td>
						<td>
							<input class="input" id="zipcode" type="text"  name="zipcode" style="width: 40px;" required>
							<input class="input" type="button" value="우편번호찾기" onclick="zip_process()" >
						</td>
						<td class="_td">우편번호를 검색하세요.</td>
					</tr>
					
					<tr>
						<td>주소</td>
						<td>
							<input class="input" id="address" type="text" name="address" style="width: 280px;" required>
						</td>
						<td class="_td">주소를 적어주세요.</td>
					</tr>
					
					<tr>
						<td>직업</td>
						<td>
							<select class="input" name="job">
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
						<td class="_td">직업을 선택하세요.</td>
					</tr>
					
					<tr>
						<td>취미</td>
						<td>
							<input class="input chk0" id="check1" name="hobby" type="checkbox" value="인터넷"><label class="chk0" for="check1">인터넷</label>
							<input class="input chk1" id="check2" name="hobby" type="checkbox" value="여행"><label class="chk1" for="check2">여행</label>
							<input class="input chk2" id="check3" name="hobby" type="checkbox" value="게임"><label class="chk2" for="check3">게임</label>
							<input class="input chk3" id="check4" name="hobby" type="checkbox" value="영화"><label class="chk3" for="check4">영화</label>
							<input class="input chk4" id="check5" name="hobby" type="checkbox" value="운동"><label class="chk4" for="check5">운동</label>
							<input id="sendHobby" name="hobbys" type="hidden">
						</td>
						<td class="_td">취미를 선택하세요.</td>
					</tr>
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="3" style="text-align: center;">
							<input id="btn_confirm" type="button" value="회원가입" style="margin-right: 60px;" disabled/>
							<input id="btn_submit" type="submit" value="확인완료" style="margin-right: 60px;" />
							<input id="btn_reset" type="reset" value="다시쓰기" />
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