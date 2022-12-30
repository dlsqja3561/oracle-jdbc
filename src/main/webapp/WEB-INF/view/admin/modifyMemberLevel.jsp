<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../resorces/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>modifyMemberLevel</title>
</head>
<body>
<main class="d-flex w-100">
	<div class="container d-flex flex-column">
		<div class="row pt-5">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
					<div class="text-center mt-2">
						<h1 class="h2">modifyMemberLevel</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">

								<form method="post" action="${pageContext.request.contextPath}/admin/modifyMemberLevel">
									<table class="table">
										<tr>
											<th>memberId</th>
											<td>
												<input type="text" name="memberId" class="form-control" value="${memberId}" readonly="readonly">
											</td>
										</tr>
										<tr>
											<th>memberLevel</th>
											<td>
												<input type="radio" name="memberLevel" value="일반" class="form-control" checked="checked">일반
												<input type="radio" name="memberLevel" value="관리자" class="form-control">관리자
											</td>
										</tr>
									</table>
									<button type="submit" class="btn btn-secondary">변경</button>
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

</html>