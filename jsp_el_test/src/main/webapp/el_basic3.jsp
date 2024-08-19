<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_basic3.jsp : 간단한 연산 결과도 가능</title>
</head>
<body>
	\${ 5+8 } : ${ 5+8 } <br>
	\${ 5/8 } : ${ 5/8 } <br>
	\${ 5 mod 8 } : ${ 5 mod 8 } <br>
	\${ 5 > 8 } : ${ 5 > 8 } <br>
	\${ 5 gt 8 } : ${ 5 gt 8 } <br>
	\${ (5 > 8) || ( 2 > 10 ) } : ${ (5 > 8) || ( 2 > 10 ) } <br>
	\${ (5 > 8) ? 5 : 2 } : ${ 5 > 8) ? 5 : 2 } <br>
	
	<%
		String input = null;
	%>
	\${ empty input } : ${ empty input } <br>
	
	<%
		int n=0;
		if(n<10){
			n=5;
		}else{
			n=20;
		}
		out.print(n);
	%>
	
	<%
		int k = 0;
		k = (k<10) ? 5 : 20;
		out.print(k);
	%>
</body>
</html>