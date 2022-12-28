<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<h1>insertBoardForm</h1>
	<form method="post" id="form" action="${pageContext.request.contextPath}/board/addBoard">
		<table border="1">
			<tr>
				<th>TITLE</th>
				<td>
					<input type="text" id="boardTitle" name="boardTitle">
					<span id="tiMsg"></span>
				</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>
					<textarea id="boardContent" name="boardContent" rows="4" cols="50"></textarea>
					<span id="coMsg"></span>
				</td>
			</tr>
		</table>
		<button type="button" id="btn">입력</button>
	</form>
</body>
<script>
	// id 입력 포커스
	$('#boardTitle').focus();
	// 아이디 확인
	$('#boardTitle').blur(function() {
		if($('#boardTitle').val().length == 0) {
			$('#tiMsg').text('TITLE을 입력해주세요');
			$('#boardTitle').focus();
		} else {
			$('#tiMsg').text('');
			$('#boardContent').focus();
		}
	});
	// 비밀번호 확인
	$('#boardContent').blur(function() {
		if($('#boardContent').val().length == 0) {
			$('#coMsg').text('CONTENT를 입력해주세요');
			$('#boardContent').focus();
		} else {
			$('#coMsg').text('');
		}
	});
	// 버튼 클릭
	$('#btn').click(function() {
		$('form').submit();
	});
</script>
</html>