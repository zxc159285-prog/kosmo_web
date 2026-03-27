<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상세 보기</h2>
	<div>글번호: ${dto.num}</div>
	<div>제목: ${dto.title}</div>
	<div>작성자: ${dto.name}</div>
	<hr>
	<div>내용: ${dto.contents}</div>
	<a href="/comm/list">목록으로</a>
</body>
</html>