<%@ page import="miniproject.book_management.dao.MemberDao" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if (!request.getMethod().equalsIgnoreCase("POST")) {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        return;
    }
%>
<jsp:useBean id="memberDto" class="miniproject.book_management.dto.MemberDto"/>
<jsp:setProperty name="memberDto" property="*"/>
<%
    long id = new MemberDao().login(memberDto);
    if (id == 0) {
        response.sendRedirect("login-form.jsp");
        return;
    }

    session.setAttribute("memberId", id);
    response.sendRedirect("/");
%>