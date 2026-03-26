<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>국가 등록</h3>
	
	<form action="/country/create" method="post">
		<div>
		<label>국가 ID</label>
		<input type="text" name="countryId">
		</div>
		
		<div>
		<label>국가명</label>
		<input type="text" name="countryName">
		</div>
		
		<div>
		<label>REGION ID</label>
		<input type="text" name="regionId">
		</div>
		<div>
		<button> 등록 </button>
		</div>
	</form>
	
</body>
</html>