<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>책 검색</title>
</head>
<body>

<form action="search-result.jsp" method="get">
    <input type="text" name="name" placeholder="책 이름" required/>
    <button type="submit">검색</button>
</form>

</body>
</html>
