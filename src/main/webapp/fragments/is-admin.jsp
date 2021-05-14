<%@ page import="miniproject.book_management.dao.MemberDao" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    MemberDao memberDao = new MemberDao();
    if (!memberDao.isAdmin(Long.parseLong((String) session.getAttribute("memberId")))) {
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
        return;
    }
%>