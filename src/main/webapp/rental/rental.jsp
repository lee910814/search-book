<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if (!request.getMethod().equalsIgnoreCase("POST")) {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        return;
    }
    if (session.getAttribute("memberId") == null) {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인 필요");
        return;
    }
%>
<jsp:useBean id="bookManageDao" class="miniproject.book_management.dao.BookManageDao"/>
<jsp:useBean id="rentalDao" class="miniproject.book_management.dao.RentalDao"/>
<jsp:useBean id="rentalDto" class="miniproject.book_management.dto.RentalDto"/>
<jsp:setProperty name="rentalDto" property="memberId" value="${sessionScope.memberId}"/>
<jsp:setProperty name="rentalDto" property="bookId" value="${param.id}"/>
<%

    if (bookManageDao.rental(rentalDto.getBookId()) && rentalDao.save(rentalDto)) {
        response.sendError(HttpServletResponse.SC_OK);
    } else {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
%>

