<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookManageDao" class="miniproject.book_management.dao.BookManageDao"/>
<jsp:useBean id="rentalDao" class="miniproject.book_management.dao.RentalDao"/>

<%
    if (!request.getMethod().equalsIgnoreCase("POST")) {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        return;
    }
    if (session.getAttribute("memberId") == null) {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return;
    }
%>

<c:choose>
    <c:when test="${rentalDao.remove(sessionScope.memberId, param.id) and bookManageDao.returnBook(param.id)}">
        <%response.sendError(HttpServletResponse.SC_OK);%>
    </c:when>
    <c:otherwise>
        <%response.sendError(HttpServletResponse.SC_BAD_REQUEST);%>
    </c:otherwise>
</c:choose>
