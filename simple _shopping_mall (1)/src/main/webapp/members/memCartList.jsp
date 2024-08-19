<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memCartList.jsp</title>
</head>
<body>
	<form action="">
	<table border="1" style="text-align: center;">
		<tr></tr>
			<colgroup>
				<col width="10%">
				<col width="15%">
				<col width="25%">	
				<col width="30%">
				<col width="10%">
			</colgroup>
		<thead>
			<tr>
				<th>제품</th>
				<th>수량</th>
				<th>가격</th>
				<th>수정/삭제</th>
				<th>조회</th>
			</tr>		
		</thead>
		<tbody>
			<tr>
			<td></td>
			<td><input name="num" value="" size="3">개</td>
			<td></td>
			<td>
				<input type="button" value="수정" onclick="">
				&#47;
				<input type="button" value="삭제" onclick="">
				</td>
			<td><span onclick="">상세보기</span></td>
			</tr>
			<tr>
			<td colspan="4">총 주문금액 : </td>
			<td><span onclick="">주문하기</span></td>
		</tbody>
	</table>
	
	<table border="1" style="text-align: center;">
		<tr></tr>
			<colgroup>
				<col width="10%">
				<col width="15%">
				<col width="25%">	
				<col width="30%">
				<col width="10%">
			</colgroup>
		<thead>
			<tr>
				<th>제품</th>
				<th>수량</th>
				<th>가격</th>
				<th>수정/삭제</th>
				<th>조회</th>
			</tr>		
		</thead>
		<tbody>
			<tr>
			<td colspan="5">장바구니는 비어 있습니다.</td>
		</tbody>
	</table>
	</form>
</body>
</html>