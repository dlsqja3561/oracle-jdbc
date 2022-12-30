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
<title>Insert title here</title>
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
			<div class="col-sm-10 col-md-8 col-lg-12 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
					<div class="text-center mt-2">
						<h1 class="h2">MEMBER LIST</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">

								<form id="pageForm" method="get" action="${pageContext.request.contextPath}/admin/memberList">
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
								<table class="table">
									<tr>
										<th>rowNum</th>
										<th>memberName</th>
										<th>memberLevel</th>
										<th>updatedate</th>
										<th>createdate</th>
										<th>등급변경</th>
										<th>강제탈퇴</th>
									</tr>
									<c:forEach var="m" items="${memberList}">
										<tr>
											<td>${m.rowNum}</td>
											<td>${m.memberName}</td>
											<td>${m.memberLevel}</td>
											<td>${m.updatedate}</td>
											<td>${m.createdate}</td>
											<td>
												<a href="${pageContext.request.contextPath}/admin/modifyMemberLevel?memberId=${m.memberId}">변경</a>
											</td>
											<td>
												<a href="${pageContext.request.contextPath}/admin/removeMember?memberId=${m.memberId}">강퇴</a>
											</td>
										</tr>
									</c:forEach>
								</table>
								<div>
									<a href="${pageContext.request.contextPath}/admin/memberList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}">이전</a>
									<a href="${pageContext.request.contextPath}/admin/memberList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}">다음</a>
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