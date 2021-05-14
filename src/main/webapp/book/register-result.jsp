<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/fragments/is-admin.jsp" %>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>등록 결과</title>
</head>
<body>
    <c:if test="${param.ok}">
        <p>등록 되었습니다.</p>
    </c:if>
    <c:if test="${not param.ok}">
        <p>등록 되지 않았습니다.</p>
    </c:if>
</body>
</html>
