<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>COUNTRY Detail Page</h1>
	
	<h4>${dti.countryId}</h4>
	<h4>${dti.countryName}</h4>
	<h4>${dti.regionId}</h4>
	
	<form action="/country/delete" method="get">
		<input type="hidden" name="countryId" value="${dti.countryId}">
		<button>DELETE</button>
	</form>
</body>
</html>