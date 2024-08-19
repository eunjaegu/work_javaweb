<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<style type="text/css">
	table tr td:first-child{
	text-align: center;
}
</style>
</head>
<body>
	<div align="center">
		<form action="">
			<table border="1" >
				<colgroup>
					<col width="">
					<col width="">
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
							<input type="text" name="">
						</td>
					</tr>
					
					<tr>
						<td>상품가격</td>
						<td>
							<input type="text" name="">원
						</td>
					</tr>
					
					<tr>
						<td>상품설명</td>
						<td>
							<textarea rows="15" cols="50"></textarea>
						</td>
					</tr>
					
					<tr>
						<td>상품수량</td>
						<td>
							<input type="text" name="">개
						</td>
					</tr>
					
					<tr>
						<td>상품이미지</td>
						<td>
							<img alt="" src="">
							<input type="file" name="">
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
</body>
</html>