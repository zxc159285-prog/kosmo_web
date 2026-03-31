<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="/userinfo/signup" method="post">
	
	<div>
	<label>아이디</label>
	<input type="text" name="id">
	</div>
	
	<div>
	<label>비밀번호</label>
	<input type="text" name="pw">
	</div>
	
	<div>
	<label>이름</label>
	<input type="text" name="name">
	</div>
	
	<div>
	<label>이메일</label>
	<input type="text" name="email">
	</div>
	
	<button type="submit">가입하기</button>
	</form>

</body>
</html>