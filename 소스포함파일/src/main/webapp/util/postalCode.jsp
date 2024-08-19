<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>postalCode.jsp</title>
<style>
	span {
		font-size: 15px;
	}
	#zero {
		flex-direction: column;
		display: flex;
    	justify-content: center;
    	align-items: center;
		font-size: 12pt;
	}
	#one {
		display: flex;
    	justify-content: center;
    	align-items: center;
   		width: 100%;
    	height: 100%;
    	gap: 10px;
	}
	form {
		display: flex;
    	gap: 10px;
		flex-direction: row;
	}
	#two {
		width: 450px;
		height: 250px;
		overflow: auto;
	}
	.focus {
		cursor: pointer;
	}
</style>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		function addr_process() {
			let addrInput = document.getElementById("_addr");
			// 값이 유효한지 체크
			if (!addrInput.checkValidity()) {
	            // 주소 입력란이 유효하지 않으면
	            addrInput.reportValidity(); // 브라우저에 기본 유효성 검사 메시지 표시
	            return false; // 폼 제출을 중지함
       		}
			
			// 영어 입력 불가
			const regExp = /[a-zA-Z]/g;
			
			if(!regExp.test(addrInput.value)) { 
				let hiddenDiv = document.getElementById("two");
				hiddenDiv.removeAttribute("hidden");
				
				$.ajax({
					type:"get",
					async:false,
					url:"<c:url value='/findAddress'/>",
					dataType:"text",
					data:{addr: addrInput.value},
					success:function(data, status) {
						let jsonAddr = JSON.parse(data);
						let out = $('#two').val();
						let zipcode = "";
						for(let i in jsonAddr.addrList) {
							zipcode = jsonAddr.addrList[i].zipcode;
							let area1 = jsonAddr.addrList[i].area1;
							let area2 = jsonAddr.addrList[i].area2;
							let area3 = jsonAddr.addrList[i].area3;
							out += "<p class=\"focus\"";
							out += "onclick=\"sendData('" + zipcode + "','" + area1 + "','" + area2 + "','" + area3 + "')\"";
							out += ">";
							out += jsonAddr.addrList[i].zipcode	+ " ";
							out += jsonAddr.addrList[i].area1 + " ";
							out += jsonAddr.addrList[i].area2 + " ";
							out += jsonAddr.addrList[i].area3 + " ";
							out += "</p>";
						}
						$('#two').html(out);
					},
					error:function(xhr, status, error){
						alert("잘못 입력 : " + error);
					}
				});
				
			} else 
				swal.fire("한글 또는 숫자를 입력해주세요");
		}
		
		function sendData(zipcode, area1, area2, area3) {
			window.opener.receiveData(zipcode, area1, area2, area3);
			window.close();
		}
	</script>
</head>
<body>
<div id="zero">
	<div id="one">
			도로명 입력 :<input id="_addr" type="text" required>
			<input type="submit" value="검색" onclick="addr_process()">
	</div>
	<div id="two" hidden>
			※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.
	</div> <br>
	<span class="focus" onclick="window.close();">닫기</span>
</div>
</body>
</html>