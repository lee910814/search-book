<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/fragments/is-admin.jsp" %>
<%@ include file="/fragments/is-method-post.jsp" %>
<jsp:useBean id="bookManageDao" class="miniproject.book_management.dao.BookManageDao"/>
<%
    if (bookManageDao.save(Long.parseLong(request.getParameter("id")))) {
        response.sendError(HttpServletResponse.SC_OK);
    } else {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
%>