<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memListInfo.jsp</title>
<style>
	.viewText {
		border: none; 
		background: transparent;
		outline: none;
	}
	table { 
		border: 1px; solid;
		width: 600px;
	}
	td {
        text-align: left;
        vertical-align: top;
        border: 1px solid;
    }
    th {
    	border: 1px solid;
    }
</style>
</head>
<body>
<div align="center">
	<table summary="사용자 상품 목록">
		<colgroup>
			<col width="" />
			<col width="40%" />
			<col width="" />
		</colgroup>
		<thead>
			<tr>
				<th colspan="3"><!-- 상품이름 --></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><img src="">d</td>
				<td align="left">
					<form action="">
						<b>상품이름 : </b>
						<input class="viewText" type="text" readonly/> <br>
						<b>가격 : </b>
						<input class="viewText" type="text" readonly/> <br>
						<b>수량 : </b>
						<input type="text" value="1" style="width: 30px;" required/>개
						<br><br>
						<input type="submit" value="장바구니 담기" />
					</form>
				</td>
				<td align="left">
				<b>상세설명</b> <br><br>
				<span>상세설명란</span>
				</td>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>