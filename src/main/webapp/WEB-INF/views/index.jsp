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
<!-- 꺽새 안에들어있는것들을 엘리먼트라고함 -->
<!-- 헤드에는 제작자,외부파일참조,타이틀 등 을 적는곳. 외부에 표시되지않음 -->
<!-- html은 엘리먼트들의 집합. 엘리먼트는 중첩이 가능. 태그네임은 대소문자를 구별하지않지만 소문자를 권장 -->
	<h1>Index Page</h1>
	<a href="/dept/list">부서관리</a>
	<a href="/country/list">나라관리</a>
	
	<c:if test="${empty dto}"> <!-- 엠티=데이터가 비어있다면 dto라는 속성명이 중요함-->
	<a href="/emp/login">Login</a>
	</c:if>
	<c:if test="${not empty dto}">
	<a href="/emp/logout">Logout</a>
	</c:if>
</body>
</html>