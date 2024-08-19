<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/styles.css">
<style type="text/css">
  * {
    margin: 0;
    padding: 0;
    font-family: 'Gulim', sans-serif;
  }
  
  body {
    background-color: #FFFFE0; 
    font-size: 12px;
  }

  table {
    border-collapse: collapse;
    width: 700px; /* 테이블의 너비 */
    margin: 50px auto; /* 페이지 중앙에 테이블 배치 */
    background-color: #FFFFE0; /* 연한 황금색 배경 */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); /* 그림자 효과 */
    border-radius: 10px; /* 둥근 모서리 */
    border: 3px solid #FFD700; /* 황금색 가장자리 테두리 */
  }

  thead tr {
    background-color: #a95e13; /* 테이블 머리글 배경색 */
    color: #fff; /* 텍스트 색상 */
  }

  thead td {
    padding: 10px 0;
    font-weight: bold;
  }

  tbody td {
 
    padding: 8px 0;
  }

  tbody tr:nth-child(even) {
    background-color: #FFFACD;
  }

  tbody td input[type='text'],
  tbody td input[type='password'],
  tbody td input[type='email'] {
    width: 50%; /* 입력 필드 너비 */
    border: 1px solid #DAA520; /* 입력 필드 테두리 */
    padding: 5px;
    border-radius: 5px; /* 둥근 모서리 */
  }

  tbody td input[type='button'],
  tbody td input[type='submit'],
  tbody td input[type='reset'] {
    background-color: #DAA520;
    border: 1px solid #DAA520; /* 버튼 테두리 */
    color: #fff;
    padding: 5px 10px;
    border-radius: 5px; /* 둥근 모서리 */
    cursor: pointer; /* 마우스 오버 시 커서 변경 */
  }

  tbody td input[type='button']:hover,
  tbody td input[type='submit']:hover,
  tbody td input[type='reset']:hover {
    background-color: #B8860B;
  }

  tbody td input[type='radio'],
  tbody td input[type='checkbox'] {
    margin-right: 5px;
  }

  tfoot td {
    text-align: center;
    padding: 10px 0;
    background-color:  #FFFFE0; /* 푸터 배경색 */
  }

  select {
    border: 1px solid #DAA520;
    padding: 5px;
    border-radius: 5px; /* 둥근 모서리 */
  }
</style>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#submit').submit(function(event) {
			event.preventDefault(); // 폼 기본 이벤트 제거
			let formData = new FormData(this); // FormData 객체 생성
			$.ajax({
				type: "post",
				async: false,
				url: "<c:url value='/adminAddProduct' />",
				data: formData,
				processData: false,
				contentType: false,
				success:function() {
					alert("등록하였습니다.");
					window.location.replace("${contextPath}/adminProduct");
				},
				error:function() {
					alert("등록을 실패하였습니다");
				}
			}); 
		});
	});
</script>
<style type="text/css">
	table tr td:first-child{
	text-align: center;
}
</style>
</head>
<body>

<div class="mainDiv">
<jsp:include page="/members/memTop.jsp" flush="false"/>

<div class="subDiv">
	<div align="center">
		<form id="submit" enctype="multipart/form-data">
			<table border="1" >
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
				<thead>
					<tr>
						<td colspan="2">상품 등록</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>상품이름</td>
						<td>
							<input type="text" name="name" >
						</td>
					</tr>
					
					<tr>
						<td>상품가격</td>
						<td>
							<input type="text" name="price">원
						</td>
					</tr>
					
					<tr>
						<td>상품설명</td>
						<td>
							<textarea rows="15" cols="50" name="detail"></textarea>
						</td>
					</tr>
					
					<tr>
						<td>상품수량</td>
						<td>
							<input type="text" name="stock">개
						</td>
					</tr>
					
					<tr>
						<td>상품이미지</td>
						<td>
							<input type="file" name = "file">
						</td>
					</tr>
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="상품등록" style="margin-right: 20px">
							<input type="reset" value="다시쓰기">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	
</div>

<jsp:include page="/members/memBottom.jsp" flush="false"/>
</div>

	
</body>
</html>