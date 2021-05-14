<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>로그인 필요</title>
</head>
<body>
<h1>로그인이 필요합니다.</h1>
<a href="${pageContext.request.contextPath}/member/login-form.jsp">로그인</a>
</body>
</html>
