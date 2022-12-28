<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>addMember</h1>
	<form method="post" action="${pageContext.request.contextPath}/member/addMember">
		<table border="1">
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="memberId">
				</td>
			</tr>
			<tr>
				<th>PW</th>
				<td>
					<input type="password" name="memberPw">
				</td>
			</tr>
			<tr>
				<th>NAME</th>
				<td>
					<input type="text" name="memberName">
				</td>
			</tr>
		</table>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>