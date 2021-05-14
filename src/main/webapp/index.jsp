<%@ page import="miniproject.book_management.dao.MemberDao" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="memberDao" value="<%=MemberDao.getInstance()%>"/>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>Library</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>

<%@ include file="fragments/header.jsp" %>

<section>
    <h2>
        <a href="${pageContext.request.contextPath}/"><span>l</span><span>i</span><span>b</span><span>r</span><span>a</span><span>r</span><span>y</span></a>
    </h2>

    <form action="${pageContext.request.contextPath}/rental/search-result.jsp" method="get">
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