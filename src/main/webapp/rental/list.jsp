<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/fragments/is-logged-in.jsp" %>
<jsp:useBean id="rentalDao" class="miniproject.book_management.dao.RentalDao"/>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>대여한 책</title>
</head>
<body>
<c:forEach items="${rentalDao.findById(sessionScope.memberId)}" var="rentalBook">
    <div class="result">
        <p>${rentalBook.bookName}</p>
        <p>${rentalBook.publisher}</p>
        <p>${rentalBook.author}</p>
        <p>반납기한: ${rentalBook.expireDate}</p>
        <button type="submit" class="return-button" value="${rentalBook.bookId}">반납하기</button>
    </div>
</c:forEach>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/js/bookAjax.js"></script>
</body>
</html>
