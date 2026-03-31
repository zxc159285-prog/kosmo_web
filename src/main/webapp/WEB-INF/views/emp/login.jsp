<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/emp/login" method="post">
		
	<label>아이디</label>
	<div>
	<input type="text" name="employeeId">  <!-- 네임은 dto의 setter이름과 동일하게 -->
	</div>
	
	<label>비밀번호</label>
	<div>
	<input type="text" name="password">
	</div>
	
	<button type="submit">로그인</button>
	</form>
</body>
</html>