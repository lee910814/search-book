<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookManageDao" class="miniproject.book_management.dao.BookManageDao"/>

<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>검색 결과</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book.css">
</head>
<body>
<c:forEach items="${bookManageDao.findByName(param.name)}" var="book">
    <div class="result">
        <p>제목: ${book.name}</p>
        <p>저자: ${book.author}</p>
        <p>출판사: ${book.publisher}</p>
        <c:if test="${book.available}">
            <button class="rental-button" value="${book.id}">대여하기</button>
        </c:if>
    </div>
</c:forEach>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/js/rental.js"></script>
</body>
</html>
