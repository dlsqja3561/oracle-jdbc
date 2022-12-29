<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../resorces/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>memberOne</title>
</head>
<body>
<main class="d-flex w-100">
	<div class="container d-flex flex-column">
		<div class="row pt-5">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
					<div class="text-center mt-2">
						<h1 class="h2">memberOne</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">

								<table class="table">
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
								<a class="btn btn-secondary" href="${pageContext.request.contextPath}/member/modifyMember?memberId=${memberId}">수정</a>
								<a class="btn btn-secondary" href="${pageContext.request.contextPath}/member/removeMember?memberId=${memberId}">삭제</a>
	
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