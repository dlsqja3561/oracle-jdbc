<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../resorces/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>modifyMember</title>
</head>
<body>
<main class="d-flex w-100">
	<div class="container d-flex flex-column">
		<div class="row pt-5">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
					<div class="text-center mt-2">
						<h1 class="h2">modifyMember</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">

								<form method="post" id="form" action="${pageContext.request.contextPath}/member/modifyMember">
									<table class="table">
										<tr>
											<th>변경할이름</th>
											<td>
												<input type="text" id="name" name="memberName" class="form-control">
												<span id="msg" style="color:#FF0000;"></span>
											</td>
										</tr>
									</table>
									<button type="button" id="btn" class="btn btn-secondary">변경</button>
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
	// name 입력 포커스
	$('#name').focus();
	// 입력확인
	$('#name').blur(function() {
		if($('#name').val().length == 0) {
			$('#msg').text('이름을 입력해주세요');
			$('#name').focus();
		} else {
			$('#msg').text('');
		}
	});
	// 버튼 클릭
	$('#btn').click(function() {
		$('form').submit();
	});
</script>
</html>