<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정</h1>
	<form method="post" action="${pageContext.request.contextPath}/board/modifyBoard">
		<input type="hidden" name="boardNo" value="${boardNo}">
		<table border="1">
			<tr>
				<th>title</th>
				<td><input type="text" name="title" value="${board.boardTitle}"></td>
			</tr>
			<tr>
				<th>content</th>
				<td><textarea rows="4" cols="50" name="content">${board.boardContent}</textarea></td>
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
		<button type="submit">수정</button>
	</form>
</body>
</html>