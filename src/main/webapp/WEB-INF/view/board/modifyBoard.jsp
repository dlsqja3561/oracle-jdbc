<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../resorces/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- script -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>modifyBoard</title>
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
						<h1 class="h2">MODIFY BOARD</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">

								<form method="post" id="form" action="${pageContext.request.contextPath}/board/modifyBoard">
									<input type="hidden" name="boardNo" value="${boardNo}">
									<table class="table">
										<tr>
											<th>title</th>
											<td>
												<input type="text" name="title" id="title" value="${board.boardTitle}" class="form-control">
												<span id="tiMsg" class="msg"></span>	
											</td>
										</tr>
										<tr>
											<th>content</th>
											<td>
												<textarea rows="4" cols="50" name="content" id="content" class="form-control">${board.boardContent}</textarea>
												<span id="coMsg" class="msg"></span>	
											</td>
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
									<button type="button" id="btn" class="btn btn-secondary">수정</button>
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
	// title입력 포커스
	$('#title').focus();
	// title유효성 체크
	$('#title').blur(function() {
		if($('#title').val().length == 0) {
			$('#tiMst').text('title을 입력해 주세요');
			$('#title').focus();
		} else {
			$('#tiMst').text('');
			$('#content').focus();
		}
	});
	// content유효성 체크
	$('#content').blur(function() {
		if($('#content').val().length == 0) {
			$('#coMsg').text('content를 입력해 주세요');
			$('#content').focus();
		} else {
			$('#coMsg').text('');
		}
	});
	// button click
	$('#btn').click(function() {
		$('form').submit();
	});
</script>
</body>
</html>