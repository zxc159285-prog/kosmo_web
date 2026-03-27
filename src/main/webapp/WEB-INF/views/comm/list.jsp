<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 전달 사항</h1>
	
		<a href="/comm/create" >글 작성</a>
	<div>
		<table>
			<thead>
				<tr>
					<th>글번호</th> 
					<th><a href= "/comm/detail">제목</a></th>
					<th>작성자</th>
					<th>작성시간</th>
					<th>중요도</th>
				</tr>			
			</thead>
			<tbody>
			<c:forEach items="${list}" var="d">
					<tr>
				    <td>${d.num}</td>
                    <td><a href="/comm/detail?num=${d.num}">${d.title}</a></td>
                    <td>${d.name}</td>
                    <td>${d.date}</td>
                    <td>${d.star}</td>
                    </tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>