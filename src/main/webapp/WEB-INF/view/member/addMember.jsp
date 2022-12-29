<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../resorces/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>addMember</title>
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
						<h1 class="h2">addMember</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">

								<form method="post" id="form" action="${pageContext.request.contextPath}/member/addMember">
									<table class="table">
										<tr>
											<th>ID</th>
											<td>
												<input type="text" name="memberId" id="id" class="form-control">
												<span id="idMsg" class="msg"></span>
											</td>
										</tr>
										<tr>
											<th>PW</th>
											<td>
												<input type="password" name="memberPw" id="pw" class="form-control">
												<span id="pwMsg" class="msg"></span>
											</td>
										</tr>
										<tr>
											<th>PWCheck</th>
											<td>
												<input type="password" id="pwCk" class="form-control">
											</td>
										</tr>
										<tr>
											<th>NAME</th>
											<td>
												<input type="text" name="memberName" id="name" class="form-control">
												<span id="nameMsg" class="msg"></span>
											</td>
										</tr>
									</table>
									<button type="button" name="btn" class="btn btn-secondary">회원가입</button>
								</form>
							
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
<script>
	// id입력 포커스
	$('#id').focus();
	// id유효성 체크
	$('#id').blur(function() {
		if($('#id').val().length == 0) {
			$('#idMsg').text('ID를 입력해 주세요');
			$('#id').focus();
		} else {
			console.log($('#id').val());
			$('#idMsg').text('');
			$('#pw').focus();
		}
	});
	// pw유효성 체크
	$('#pw').blur(function() {
		if($('#pw').val().length == 0) {
			$('#pwMsg').text('PW를 입력해 주세요');
			$('#pw').focus();
		} else {
			console.log($('#pw').val());
			$('#pwMsg').text('');
			$('#pwCk').focus();
		}
	});
	// pwCk유효성 체크
	$('#pwCk').blur(function() {
		if($('#pwCk').val() != $('#pw').val()) {
			$('#pwMsg').text('PW를 확인해 주세요');
			$('#pwCk').val('');
			$('#pw').focus();
		} else {
			console.log($('#pwCk').val());
			$('#pwMsg').text('');
			$('#name').focus();
		}
	}); 
	// name유효성 체크
	$('#name').blur(function() {
		if($('#name').val().length == 0) {
			$('#nameMsg').text('NAME를 입력해 주세요');
			$('#name').focus();
		} else {
			console.log($('#name').val());
			$('#nameMsg').text('');
		}
	});
	// buttn click
	$('#btn').click(function() {
		$('#form').submit();
	});
</script>
</body>
</html>