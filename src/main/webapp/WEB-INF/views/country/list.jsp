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
	
	<h1>국가 리스트</h1>
	
	<div>
		<table>
			<thead>
				<tr>
					<th>국가번호</th> 
					<th>국가명</th>
				</tr>			
			</thead>
			<tbody>
				<c:forEach items="${list}" var="d">
				<tr>
					<td>${d.countryId}</td>
					<td><a href="/country/detail?countryId=${d.countryId}">${d.countryName}</a></td>
				</tr>
					<!-- getter의 이름을 쓴다 getter메서드에서 get을뺴고 ()빼고 나온 결과물의 첫글자를 소문자로 바꾼것 -->
					
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>