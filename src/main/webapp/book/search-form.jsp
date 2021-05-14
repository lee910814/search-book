<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/fragments/is-admin.jsp" %>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>책 검색</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@ include file="/fragments/header.jsp" %>

<section>
    <h2>
        <a href="${pageContext.request.contextPath}/"><span>l</span><span>i</span><span>b</span><span>r</span><span>a</span><span>r</span><span>y</span></a>
    </h2>
    <h3>도서 등록</h3>

    <form action="${pageContext.request.contextPath}/book/search-result.jsp" method="get">
        <%--    <select>
                <option>저자명</option>
                <option>도서명</option>
                <option>도서번호</option>
            </select>--%>
        <input id="bookName" type="text" name="name" placeholder="검색어를 입력해주세요">
        <button id="search" type="submit">검색</button>
    </form>
</section>

</body>
</html>
