<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자료</h1>
	<table border="1">
		<tr><th>사번</th><th>이름</th><th>부서명</th><th>직급</th><th>입사시기</th></tr>
		<c:forEach var="s" items="${data}">
			<tr>
				<td>${s.jikwon_no}</td>
				<td>${s.jikwon_name}</td>
				<td><a href="buser?num=${s.buser_num}" target="f">${s.buser_name}</a></td>
				<td>${s.jikwon_jik}</td>
				<td>${s.jikwon_ibsail}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" style="text-align: center;">인원수 : <c:out value="${fn:length(data)}"></c:out></td>
		</tr>
		<tr>
			<td colspan="5" style="text-align: center;">
				<form action="searchBuser">
					부서별 자료보기 : 
					<select name="buser_num">
	  					<option value="all">전체</option>
	  					<option value="10">총무부</option>
	  					<option value="20">영업부</option>
	  					<option value="30">전산부</option>
	  					<option value="40">관리부</option>
					</select>
					<input type="submit" value="검색">
				</form> 
			</td>
		</tr>
	</table>
	
	<iframe name="f" width="500" height="300"></iframe>
</body>
</html>