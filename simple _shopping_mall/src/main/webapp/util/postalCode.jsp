<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>postalCode.jsp</title>
<style>
	span {
		font-size: 15px;
	}
	#one {
		display: flex;
		flex-direction: column;
    	align-items: center;
   		width: 100%;
    	height: 50vh;
    	gap: 20px;
	}
	form {
		display: flex;
		flex-direction: row;
	}
	p {
		font-size: 15px;
	}
</style>
</head>
<body>
	<div id="one">
		<form action="">
			도로명 입력 : &nbsp;<input type="text" required>&nbsp;
			<input type="submit" value="검색">
		</form>
		<div>
			※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.
			<p>d</p>
			<p>d</p>
		</div>
	</div>
</body>
</html>