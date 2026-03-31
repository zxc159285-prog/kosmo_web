<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 화면</h1>
	<form action="<c:url value='/userinfo/login'/>" method="post">
	<div>
	<label>아이디</label>
	<input type="text" name="id">
	</div>
	
	<div>
	<label>비밀번호</label>
	<input type="text" name="pw">
	</div>
	<button type="submit">로그인</button>
	<a href="/userinfo/signup">
    <button type="button">회원가입</button>
</a>
</form>
</body>
</html>