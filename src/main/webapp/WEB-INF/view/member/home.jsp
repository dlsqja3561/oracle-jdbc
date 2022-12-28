<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<div>
			${loginMember.memberName}님
			<a href="${pageContext.request.contextPath}/member/memberOne">내정보</a>
			<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/board/boardList">게시판리스트</a>
		</div>
	
	
</body>
</html>