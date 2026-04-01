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
                	<ul class="list-group">
  <li class="list-group-item">국가 상세정보</li>
  
 
  
  <li class="list-group-item list-group-item-success">국가코드 : ${dti.countryId}</li>
  <li class="list-group-item list-group-item-danger">국가명 : ${dti.countryName}</li>
  <li class="list-group-item list-group-item-warning">지역코드 : ${dti.regionId}</li>
  
</ul>
<form action="/country/delete" method="get">
		<input type="hidden" name="countryId" value="${dti.countryId}">
		<button>DELETE</button>
	</form>
                
                </div>        
			</div>
		</section>		
	</main>
	<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>