<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/fragments/is-method-post.jsp" %>
<%@ include file="/fragments/is-logged-in.jsp" %>
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

