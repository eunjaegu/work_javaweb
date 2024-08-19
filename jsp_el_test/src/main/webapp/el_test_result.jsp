<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_test_result.jsp</title>
</head>
<body>
	EL 방식 : \${ param.파라미터명} <br>
	${ empty param.email } <br>
	${ param.url.equals("test") } <br>
	<hr>
	EL 방식 : \${ param["파라미터명"] } <br>
	${ param["email"] } <br>
	${ param["url"] } <br>
</body>
</html>