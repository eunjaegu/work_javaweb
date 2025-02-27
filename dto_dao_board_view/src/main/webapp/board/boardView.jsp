<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세보기</title>

<style type="text/css">
	*{font-size: 9pt;}
	.btn_align {width: 600px; text-align: right;}
	table tbody tr th {background-color: gray;}
</style>
</head>

<body>
	<table bordr="1" summary="게시판 상세조회">
		<caption>게시판 상세조회</caption>	
		<colgroup>
			<col width="100"/>
			<col width="500"/>
		</colgroup>
		<tbody>
			<tr>
				<th align="center">제목</th>
				<td><c:out value="${boardModel.subject}"/></td>
			</tr>
			<tr>
				<th align="center">작성자/조회수</th>
				<td><c:out value="${boardModel.writer}"/>
						<c:out value="${boardModel.hit}"/>
				</td>
			</tr>
			<tr>
				<th align="center">등록 일시</th>
				<td><c:out value="${boardModel.regDate}"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<c:out value="${boardModel.contents}" escapeXml="false"/>
				</td>
			</tr>
		</tbody>
	</table>
	<p class="btn_align">
		<input type="button" value="목록"
		onclick="location.href='<c:out value="/board/boardListServlet?pageNum=${boardModel.pageNum}$amp;searchType=${boardModel.searchType}&amp;searchText=${boradModel.searchText}"/>'">
		
		<input type="button" value="수정"
		onclick="location.href='<c:out value="/board/boardListServlet?pageNum=${boardModel.num}$pageNum=${boardModel.pageNum}&amp;searchType=${boradModel.searchType}&amp;searchText=${boradModel.searchText}"/>'">
		
		<input type="button" value="삭제"
		onclick="location.href='<c:out value="/board/boardListServlet?pageNum=${boardModel.num}$pageNum=${boardModel.pageNum}&amp;searchType=${boradModel.searchType}&amp;searchText=${boradModel.searchText}"/>'">
	</p>
</body>
</html>