<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글 등록 페이지</h3>
		
		<form action="/comm/create" method="post">
		
			<div>
			<label>제목</label>
			<!-- DTO의 setter이름과 동일하게 -->
			<input type="text" name="title">
			</div>
			
			<div>
			<label>내용</label>
			<input type="text" name="contents">
			</div>
			
			<div>	
			<label>작성자</label>
			<input type="text" name="name">
			</div>
			
			<div>	
			<label>중요도</label>
			<input type="text" name="star">
			</div>
			
			<div>
			<button type="submit">등록</button>  <!-- 버튼타입을 안적으면 기본값이 서브밋 -->
			</div>
			
		</form>
</body>
</html>