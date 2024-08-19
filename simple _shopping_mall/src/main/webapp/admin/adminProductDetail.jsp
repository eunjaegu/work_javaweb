<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminProductDetail.jsp</title>
<style>
	.viewText {
		border: none; 
		background: transparent;
		outline: none;
	}
	table { 
		border: 1px solid;
		width: 600px;
	}
	tbody tr td {
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
				<th colspan="3"><!-- 상품이름 -->dd</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><img src="">d</td>
				<td>
				<table style="width: 100%;">
					<tr>
						<td>
						<b>상품이름 : </b>
						</td>
					</tr>
					<tr>
						<td>
						<b>가격 : </b>
						</td>
					</tr>
					<tr>
						<td>
						<b>입고날짜 : </b>
						</td>
					</tr>
					<tr>
						<td>
						<b>재고 : </b>
						</td>
					</tr>
				</table>
				</td>
				<td align="left">
				<b>상세설명</b> <br><br>
				<span>상세설명란</span>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td align="center" colspan="3">
					<span>수정하기</span> &nbsp;
					<span>삭제하기</span>
				</td>
			</tr>
		</tfoot>
	</table>
</div>
</body>
</html>