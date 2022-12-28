<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<form method="post" id="form" action="${pageContext.request.contextPath}/member/modifyMember">
		<table border="1">
			<tr>
				<th>변경할이름</th>
				<td>
					<input type="text" id="name" name="memberName">
					<span id="msg"></span>
				</td>
			</tr>
		</table>
		<button type="button" id="btn">변경</button>
	</form>
</body>

</html>