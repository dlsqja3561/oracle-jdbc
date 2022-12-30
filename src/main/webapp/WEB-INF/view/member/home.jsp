<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="./resorces/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>home</title>
</head>
<body>

<main class="d-flex w-100">
	<div class="container d-flex flex-column">
		<div class="row pt-5">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
					<div class="text-center mt-2">
						<h1 class="h2">HOME</h1>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-5 text-center">
							
								<div class="h4">
									<span><strong class="text-info">${loginMember.memberName}</strong>님 반갑습니다.</span>
								</div>
								<div>
									<a class="btn btn-secondary" href="${pageContext.request.contextPath}/member/memberOne">내정보</a>
									<a class="btn btn-secondary" href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
								</div>
								<br>
								<div>
									<a class="btn btn-secondary" href="${pageContext.request.contextPath}/board/boardList">게시판리스트</a>
									<!-- memberLevel 1일때만 멤버리스트 링크 노출 -->
									<c:if test="${loginMember.memberLevel eq '관리자'}">
										<a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/memberList">멤버리스트</a>
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