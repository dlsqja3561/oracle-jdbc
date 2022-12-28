<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>아이디 삭제</h1>
	<form method="post" action="${pageContext.request.contextPath}/member/removeMember">
		<table border="1">
			<tr>
				<th>비밀번호입력</th>
				<td><input type="password" name="memberPw"></td>
			</tr>
		</table>
		<button type="submit">삭제</button>
	</form>
</body>
</html>