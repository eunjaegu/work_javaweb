<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 상품 관리</title>
</head>
<body>
	<div align="center">
		<table border="1" style="text-align: center;">
			<colgroup>
				<col width="50px">
				<col width="100px">
				<col width="200px">
				<col width="50px">
				<col width="150px">
			</colgroup>
			<thead>
				<!-- 글 제목 -->
				<tr>
					<td>이름</td>
					<td>가격</td>
					<td>날짜</td>
					<td>재고</td>
					<td></td>
				</tr>
				<!-- 글 목록의 데이터 부분 -->
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<a href="#">상세보기</a>
					</td>
				</tr>
				
			</thead>
				
			<tbody>
				<tr>
					<td colspan="5">
						<a href="#">상품등록</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>