<%@ page import="miniproject.book_management.dao.MemberDao" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="is-logged-in.jsp" %>
<%
    MemberDao memberDao = MemberDao.getInstance();
    if (!memberDao.isAdmin((Long) session.getAttribute("memberId"))) {
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
        return;
    }
%>