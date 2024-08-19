<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminOrderDetail.jsp</title>
</head>
<body>
	<div align="center">
	<form action="">
	<table border="1" style="text-align: center;" >
		<tr></tr>
			<colgroup>
				<col width="40%">
				<col width="60%">		
			</colgroup>
	
		<thead>
			<tr>
				<th colspan="2">주문상세내역</th>
			</tr>		
		</thead>
		
		<tbody>
			
			<tr>
				<td>고객아이디</td>
				<td></td>
			</tr>
			<tr>
				<td>주문번호</td>
				<td></td>
			</tr>
			<tr>
				<td>제품번호</td>
				<td></td>
			</tr>
			<tr>
				<td>제품이름</td>
				<td></td>
			</tr>			
			<tr>
				<td>제품가격</td>
				<td></td>
			</tr>		
			<tr>
				<td>주문수량</td>
				<td></td>
			</tr>
			<tr>
				<td>재고수량</td>
				<td></td>
			</tr>
			<tr>
				<td>주문날짜</td>
				<td></td>
			</tr>
			<tr>
				<td>금액</td>
				<td></td>
			</tr>		
			<tr>
				<td>주문상태</td>
				<td>
				<select>
				<option value="" selected="selected">접수중</option>
				<option value="" >접수</option>
				<option value="" >입금확인</option>
				<option value="" >배송준비</option>
				<option value="" >배송중</option>
				<option value="" >완료</option>
				</select>
				</td>
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="">
					&#47;
					<input type="button" value="삭제" onclick="">
				</td>
				
			</tr>	
		</tfoot>
	</table>
	</form>
	</div>
</body>
</html>