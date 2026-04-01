<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/temp/nav.jsp"></c:import>
		
		<section class="py-5">
			<div class="container px-5 mb-5">
				<div class="text-center mb-5">
                        <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Projects</span></h1>
                </div>
                
                <div class="row gx-5 justify-content-center">
                	<div class="card" style="width: 18rem;">
  <div class="card-header">
    상세페이지
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">부서번호 :${dti.departmentId}</li>
    <li class="list-group-item">부서명 :${dti.departmentName}</li>
    <li class="list-group-item">관리자아이디 : ${dti.managerId}</li>
    <li class="list-group-item">지역코드 :${dti.locationId}</li>
  </ul>
</div>
                <a href="/dept/update?departmentId=${dti.departmentId}">수정</a> <!-- a태그는 get형식 -->
	<a href="/dept/delete?departmentId=${dti.departmentId}">삭제</a> <!-- a태그는 get형식 -->
	<form action="/dept/delete" method="get">
		<input type="hidden" name="departmentId" value="${dti.departmentId}"> <!-- 리드온리는 수정을못하게막음-->
		<button type="submit">DELETE</button>
	</form>
                </div>        
			</div>
		</section>		
	</main>
	<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>