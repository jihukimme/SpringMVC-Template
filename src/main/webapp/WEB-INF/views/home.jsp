<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="loginOutLink" value="${sessionScope.id==null ? '/login' : '/logout'}"/>
<c:set var="loginOut" value="${sessionScope.id==null ? '로그인' : '로그아웃'}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jihu's Spring MVC web</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/menu.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
</head>
<body>
<div id="menu">
	<ul>
		<li id="logo">Blog</li>
		<li><a href="<c:url value='/'/>">홈</a></li>
		<li><a href="<c:url value='/user/info'/>">회원정보</a></li>
		<li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
		<li><a href="<c:url value='/register/add'/>">회원가입</a></li>
		<li><a href=""><i class="fas fa-search small"></i></a></li>
	</ul>
</div>
<div style="text-align:center">
	<h1>This is HOME</h1>
</div>
</body>
</html>