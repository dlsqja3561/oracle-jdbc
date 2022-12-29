<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="./resorces/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- script -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>addBoard</title>
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
						<h1 class="h2">ADD BOARD</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">

								<form method="post" id="form" action="${pageContext.request.contextPath}/board/addBoard">
									<table class="table">
										<tr>
											<th>TITLE</th>
											<td>
												<input type="text" id="boardTitle" name="boardTitle" class="form-control">
												<span id="tiMsg" class="msg"></span>
											</td>
										</tr>
										<tr>
											<th>CONTENT</th>
											<td>
												<textarea id="boardContent" name="boardContent" rows="4" cols="50" class="form-control"></textarea>
												<span id="coMsg" class="msg"></span>
											</td>
										</tr>
									</table>
									<button type="button" id="btn" class="btn btn-secondary">입력</button>
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
	// title입력 포커스
	$('#boardTitle').focus();
	// title유효성 체크
	$('#boardTitle').blur(function() {
		if($('#boardTitle').val().length == 0) {
			$('#tiMsg').text('TITLE을 입력해주세요');
			$('#boardTitle').focus();
		} else {
			console.log($('#boardTitle').val());
			$('#tiMsg').text('');
			$('#boardContent').focus();
		}
	});
	// content유효성 체크
	$('#boardContent').blur(function() {
		if($('#boardContent').val().length == 0) {
			$('#coMsg').text('CONTENT를 입력해주세요');
			$('#boardContent').focus();
		} else {
			console.log($('#boardContent').val());
			$('#coMsg').text('');
		}
	});
	// 버튼 클릭
	$('#btn').click(function() {
		$('form').submit();
	});
</script>
</html>