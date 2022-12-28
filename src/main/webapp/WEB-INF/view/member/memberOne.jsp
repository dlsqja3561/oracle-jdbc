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
			<th>memberName</th>
			<th>createdate</th>
			<th>updatedate</th>
		</tr>
		<tr>
			<td>${member.memberName}</td>
			<td>${member.createdate}</td>
			<td>${member.updatedate}</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/member/modifyMember?memberId=${memberId}">수정</a>
	<a href="${pageContext.request.contextPath}/member/removeMember?memberId=${memberId}">삭제</a>
</body>
</html>