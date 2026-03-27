<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DEPT Detail Page</h1>
	
	<h4>${dti.departmentId}</h4>
	<h4>${dti.departmentName}</h4>
	<h4>${dti.managerId}</h4>
	<h4>${dti.locationId}</h4>
	
	<a href="/dept/update?departmentId=${dti.departmentId}">수정</a> <!-- a태그는 get형식 -->
	<a href="/dept/delete?departmentId=${dti.departmentId}">삭제</a> <!-- a태그는 get형식 -->
	<form action="/dept/delete" method="get">
		<input type="hidden" name="departmentId" value="${dti.departmentId}"> <!-- 리드온리는 수정을못하게막음-->
		<button type="submit">DELETE</button>
	</form>
</body>
</html>