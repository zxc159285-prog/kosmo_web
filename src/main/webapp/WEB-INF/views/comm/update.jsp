<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시글 수정</h3>
	<form action="/comm/update" method="post">
	<input type="hidden" name="num" value="${dto.num}">
        
        <table>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value="${dto.title}"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="name" value="${dto.name}"></td>
            </tr>
            <tr>
                <th>내용</th>
                    <td><input type="text" name="contents" value="${dto.contents}"></td>
            </tr>
            <tr>
                <th>중요도</th>
                <td>
                    <input type="text" name="star" value="${dto.star}">
                </td>
            </tr>
        </table>
        
        <button>수정 완료</button>
	

</body>
</html>