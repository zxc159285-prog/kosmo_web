<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>부서 등록 페이지</h3>
	
	<form action="/dept/create" method="post">
	
		<div>
		<label>부서명</label>
		<input type="text">
		</div>
		
		<div>
		<label>관리자코드</label>
		<input type="text">
		</div>
		
		<div>	
		<label>지역코드</label>
		<input type="text">
		</div>
		
		<div>
		<button type="submit">버튼</button>  <!-- 버튼타입을 안적으면 기본값이 서브밋 -->
		<input type="submit" value="create">
		<input type="button" value="등록">
		<input type="reset" value="리셋">
		</div>
		
	</form>
</body>
</html>