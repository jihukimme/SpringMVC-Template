<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <style>
        body {
            font-family: sans-serif;
            margin: 50px;
        }
        .login-form {
            max-width: 300px;
            margin: auto;
        }
        .login-form label,
        .login-form input {
            display: block;
            width: 100%;
            margin-bottom: 10px;
        }
        .login-form button {
            width: 100%;
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="login-form">
    <h2>Login</h2>

    <!-- 실패 메시지 표시 -->
    <c:if test="${not empty errorMsg}">
        <p style="color: red;">${errorMsg}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required />

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required />

        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>