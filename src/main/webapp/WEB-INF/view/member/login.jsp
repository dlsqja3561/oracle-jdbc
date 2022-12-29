<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../resorces/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>login</title>
<style>
	.msg {color : #FF0000;}
</style>
</head>
<body>
<main class="d-flex w-100">
	<div class="container d-flex flex-column">
		<div class="row pt-5">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
					<div class="text-center mt-2">
						<h1 class="h2">Login</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">

								<form method="post" id="form" action="${pageContext.request.contextPath}/member/login">
									<table class="table">
										<tr>
											<th>ID</th>
											<td>
												<input type="text" id="id" name="memberId" class="form-control">
												<span id="idMsg" class="msg"></span>
											</td>
										</tr>
										<tr>
											<th>PW</th>
											<td>
												<input type="password" id="pw" name="memberPw" class="form-control">
												<span id="pwMsg" class="msg"></span>
											</td>
										</tr>
									</table>
									<button type="button" id="btn" class="btn btn-secondary">로그인</button>
									<a class="btn btn-secondary" href="${pageContext.request.contextPath}/member/addMember">회원가입</a>
								</form>
	
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>

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