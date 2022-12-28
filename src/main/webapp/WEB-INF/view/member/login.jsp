<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<h1>LoginForm</h1>
	<form method="post" id="form" action="${pageContext.request.contextPath}/member/login">
		<table border="1">
			<tr>
				<th>ID</th>
				<td>
					<input type="text" id="id" name="memberId">
					<span id="idMsg" class="msg"></span>
				</td>
			</tr>
			<tr>
				<th>PW</th>
				<td>
					<input type="password" id="pw" name="memberPw">
					<span id="pwMsg" class="msg"></span>
				</td>
			</tr>
		</table>
		<button type="button" id="btn">로그인</button>
		<a href="${pageContext.request.contextPath}/member/addMember">회원가입</a>
	</form>
</body>
<script>
	// id 입력 포커스
	$('#id').focus();
	// 아이디 확인
	$('#id').blur(function() {
		if($('#id').val().length == 0) {
			$('#idMsg').text('ID를 입력해주세요');
			$('#id').focus();
		} else {
			$('#idMsg').text('');
			$('#pw').focus();
		}
	});
	// 비밀번호 확인
	$('#pw').blur(function() {
		if($('#pw').val().length == 0) {
			$('#pwMsg').text('PW를 입력해주세요');
			$('#pw').focus();
		} else {
			$('#pwMsg').text('');
		}
	});
	// 버튼 클릭
	$('#btn').click(function() {
		$('form').submit();
	});
</script>
</html>