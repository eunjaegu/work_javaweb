<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminMain.jsp</title>
<style>
	b {
		font-size: 12pt;
	}
	div {
		display: flex;
		justify-content: center;
		align-items: center;
		width: 100%;
		height: 700px;
	}
	table {
		width: 900px;
		border: 1px solid;
	}
	table tr th, table tr td {
		border: 1px solid;
	}
</style>
</head>
<body>
<div>
	<table summary="관리자 include 화면">
		<colgroup>
			<col width="" />
			<col width="" />
			<col width="" />
			<col width="" />
			<col width="" />
		</colgroup>
		<thead>
			<tr>
				<th><b>홈</b></th>
				<th><b>로그아웃</b></th>
				<th><b>회원관리</b></th>
				<th><b>상품관리</b></th>
				<th><b>주문관리</b></th>
			</tr>
		</thead>
		<tbody>
			<tr style="height: 500px;">
				<td align="center" colspan="5" >
				include 화면
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td align="center" colspan="5">
					<b>Simple Shopping Mall 관리자 페이지 입니다.</b>
				</td>
			</tr>
		</tfoot>
	</table>
</div>
</body>
</html>