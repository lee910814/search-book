<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<%-- todo : 화면 꾸미기--%>
<div class="login">
    <h1><b>로그인</b></h1>
    <form action="login.jsp" method="POST">
        <%--        <label for="username">아이디</label>--%>
        <input type="text" name="username" id="username" placeholder="아이디" required><br>
        <%--        <label for="password">비밀번호</label>--%>
        <input type="password" name="password" id="password" placeholder="비밀번호" required><br>
        <button type="submit"><b>로그인</b></button>
    </form>
</div>
</body>
</html>
