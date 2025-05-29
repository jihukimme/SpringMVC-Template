<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--	<meta charset="UTF-8">--%>
<%--	<title>Home</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Hello world!</h1>--%>
<%--<p>The time on the server is ${serverTime}.</p>--%>

<%--<!-- 로그인 상태 확인 -->--%>
<%--<c:choose>--%>
<%--	<c:when test="${not empty loginUser}">--%>
<%--		<p>사용자 아이디 : ${loginUser.id}</p>--%>
<%--		<p>사용자 비밀번호 : ${loginUser.password}</p>--%>
<%--		<form action="${pageContext.request.contextPath}/logout" method="get">--%>
<%--			<button type="submit">로그아웃</button>--%>
<%--		</form>--%>
<%--	</c:when>--%>
<%--	<c:otherwise>--%>
<%--		<p>로그인 상태가 아닙니다.</p>--%>
<%--		<form action="${pageContext.request.contextPath}/login" method="get">--%>
<%--			<button type="submit">로그인 페이지로 이동</button>--%>
<%--		</form>--%>
<%--	</c:otherwise>--%>
<%--</c:choose>--%>

<%--</body>--%>
<%--</html>--%>



<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="loginOutLink" value="${sessionScope.id==null ? '/login' : '/logout'}"/>
<c:set var="loginOut" value="${sessionScope.id==null ? 'Login' : 'Logout'}"/>
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
		<li id="logo">web</li>
		<li><a href="<c:url value='/'/>">Home</a></li>
		<li><a href="<c:url value='/board/list'/>">Board</a></li>
		<li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
		<li><a href="<c:url value='/register/add'/>">Sign in</a></li>
		<li><a href=""><i class="fas fa-search small"></i></a></li>
	</ul>
</div>
<div style="text-align:center">
	<h1>This is HOME</h1>
	<h1>This is HOME</h1>
	<h1>This is HOME</h1>
</div>
</body>
</html>