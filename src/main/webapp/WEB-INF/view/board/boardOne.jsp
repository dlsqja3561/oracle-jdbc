<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>title</th>
			<td>${board.title}</td>
		</tr>
		<tr>
			<th>content</th>
			<td>${board.content}</td>
		</tr>
		<tr>
			<th>createdate</th>
			<td>${board.createdate}</td>
		</tr>
		<tr>
			<th>updatedate</th>
			<td>${board.updatedate}</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/board/modifyBoard">수정</a>
	<a href="${pageContext.request.contextPath}/board/removeBoard">삭제</a>
</body>
</html>