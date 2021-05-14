<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookDao" class="miniproject.book_management.dao.BookDao"/>
<%@ include file="/fragments/is-admin.jsp" %>

<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book.css">
    <title>검색 결과</title>
</head>
<body>
<div class="results">
    <c:forEach items="${bookDao.findByNameNotRegistered(param.name)}" var="book" varStatus="vs">
        <div class="result">
            <p>제목: ${book.name}</p>
            <p>저자: ${book.author}</p>
            <p>출판사: ${book.publisher}</p>
            <button type="submit" class="register-button" value="${book.id}">등록</button>
        </div>
    </c:forEach>
</div>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/js/bookAjax.js"></script>
</body>
</html>
