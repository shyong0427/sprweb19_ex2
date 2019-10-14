<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr><th>부서번호</th><th>부서명</th><th>부서전화</th><th>부서위치</th></tr>
		<tr>
			<td>${data.buser_no}</td>
			<td>${data.buser_name}</td>
			<td>${data.buser_tel}</td>
			<td>${data.buser_loc}</td>
		</tr>
	</table>
</body>
</html>