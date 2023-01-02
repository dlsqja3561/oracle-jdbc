<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../resorces/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>boardList</title>
<!-- script -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#rowPerPage').change(function() {
			$('#pageForm').submit();
		});
	});
</script>
</head>
<body>
<main class="d-flex w-100">
	<div class="container d-flex flex-column">
		<div class="row pt-5">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
					<div class="text-center mt-2">
						<h1 class="h2">BOARD LIST</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">

								<form id="pageForm" method="get" action="${pageContext.request.contextPath}/board/boardList">
									<select name="rowPerPage" id="rowPerPage" class="form-select form-select-sm w-50">
										<c:if test="${rowPerPage == 10}">
											<option value="10" selected="selected">10</option>
											<option value="20">20</option>
											<option value="30">30</option>
										</c:if>
										<c:if test="${rowPerPage == 20}">
											<option value="10">10</option>
											<option value="20" selected="selected">20</option>
											<option value="30">30</option>
										</c:if>
										<c:if test="${rowPerPage == 30}">
											<option value="10">10</option>
											<option value="20">20</option>
											<option value="30" selected="selected">30</option>
										</c:if>
									</select>
								</form>
								<br>
								<div style="text-align:right">
									<a class="btn btn-secondary" href="${pageContext.request.contextPath}/board/addBoard">추가</a>
								</div>
								<table class="table">
									<tr>
										<th>boardNo</th>
										<th>boardTitle</th>
										<th>createdate</th>
										<th>updatedate</th>
									</tr>
									<c:forEach var="b" items="${boardList}">
										<tr>
											<td>${b.boardNo}</td>
											<td><a class="text-info" href="${pageContext.request.contextPath}/board/boardOne?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
											<td>${b.createdate}</td>
											<td>${b.updatedate}</td>
										</tr>
									</c:forEach>
								</table>
								<!-- 페이징 -->
								<div>
									<c:if test="${currentPage == 1}">
										<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=1">이전</a>
									</c:if>
									<c:if test="${currentPage > 1}">
										<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}">이전</a>
									</c:if>
									<span>${currentPage}/${lastPage}</span>
									<c:if test="${currentPage == lastPage}">
										<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${lastPage}">이전</a>
									</c:if>
									<c:if test="${currentPage < lastPage}">
										<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}">다음</a>
									</c:if>
								</div>
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