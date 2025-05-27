<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--&lt;%&ndash;<%@ page session="false" %>&ndash;%&gt;--%>
<%--<html>--%>
<%--<head>--%>
<%--	<meta charset="UTF-8">--%>
<%--	<title>Home</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Hello world!</h1>--%>
<%--<p>The time on the server is ${serverTime}.</p>--%>
<%--<p>로그인 상태 : ${loginUserId}</p>--%>
<%--</body>--%>
<%--</html>--%>


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>Hello world!</h1>
<p>The time on the server is ${serverTime}.</p>

<!-- 로그인 상태 확인 -->
<c:choose>
	<c:when test="${not empty loginUser}">
		<p>사용자 아이디 : ${loginUser.id}</p>
		<p>사용자 비밀번호 : ${loginUser.password}</p>
		<form action="${pageContext.request.contextPath}/logout" method="get">
			<button type="submit">로그아웃</button>
		</form>
	</c:when>
	<c:otherwise>
		<p>로그인 상태가 아닙니다.</p>
		<form action="${pageContext.request.contextPath}/login" method="get">
			<button type="submit">로그인 페이지로 이동</button>
		</form>
	</c:otherwise>
</c:choose>

</body>
</html>
