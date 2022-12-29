<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../resorces/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>boardOne</title>
</head>
<body>
<main class="d-flex w-100">
	<div class="container d-flex flex-column">
		<div class="row pt-5">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
					<div class="text-center mt-2">
						<h1 class="h2">BOARD ONE</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">

								<table class="table">
									<tr>
										<th>title</th>
										<td>${board.boardTitle}</td>
									</tr>
									<tr>
										<th>content</th>
										<td>${board.boardContent}</td>
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
								<!-- 글입력ID와 세션로그인ID가 같으면 수정,삭제 노출 -->
								<c:if test="${board.memberId eq loginId}">
									<a class="btn btn-secondary" href="${pageContext.request.contextPath}/board/modifyBoard?boardNo=${boardNo}">수정</a>
									<a class="btn btn-secondary" href="${pageContext.request.contextPath}/board/removeBoard?boardNo=${boardNo}">삭제</a>
								</c:if>

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