<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
<%-- todo : 화면 꾸미기--%>
<form action="login.jsp" method="POST">
    <label for="username">아이디</label>
    <input type="text" name="username" id="username" placeholder="아이디" required>
    <label for="password"></label>
    <input type="password" name="password" id="password" placeholder="비밀번호" required>
    <button type="submit">로그인</button>
</form>
</body>
</html>
