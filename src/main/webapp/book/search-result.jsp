<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookDao" class="miniproject.book_management.dao.BookDao"/>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book.css">
    <title>검색 결과</title>
</head>
<body>
<div class="results">
    <c:forEach items="${bookDao.findByName(param.name)}" var="book" varStatus="vs">
        <form action="register.jsp" method="post" class="result">
            <input type="number" name="id" value="${book.id}" hidden readonly>
            <p>제목: ${book.name}</p>
            <p>저자: ${book.author}</p>
            <p>출판사: ${book.publisher}</p>
            <button type="submit">등록</button>
        </form>
    </c:forEach>
</div>

</body>
</html>
