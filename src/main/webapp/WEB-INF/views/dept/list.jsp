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
	
	<%-- <% ArrayList<DepartmentDTO> ar =  request.getAttribute("list"); %> --%>
	${list[0].departmentName}
	<h1>부서 리스트</h1>
</body>
</html>