<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memMian.jsp</title>
<style>
	b {
		font-size: 12pt;
	}
	div {
		display: flex;
		justify-content: center;
		flex-direction: column;
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
	<table summary="회원 include">
		<colgroup>
			<col width="" />
			<col width="" />
			<col width="" />
			<col width="" />
			<col width="" />
		</colgroup>
		<thead>
			<tr>
				<th><b>로그인</b></th>
				<th><b>회원가입</b></th>
				<th><b>상품목록</b></th>
				<th><b>장바구니</b></th>
				<th><b>구매목록</b></th>
			</tr>
		</thead>
		<tbody>
			<tr style="height: 500px;">
				<td align="center" colspan="5" >
				include 화면
				</td>
			</tr>
		</tbody>
	</table>
	<table>
		<tr>
			<td align="center" colspan="4">
				<b>Simple Shopping Mall 에 오신 것을 환영합니다.</b>
			</td>
			<td align="center">
				<b>관리자</b>	
			</td>
		</tr>
	</table>
</div>
</body>
</html>