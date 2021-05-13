<%@ page import="miniproject.book_management.dao.MemberDao" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if (!request.getMethod().equalsIgnoreCase("POST")) {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        return;
    }
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memberDto" class="miniproject.book_management.dto.MemberDto"/>
<jsp:setProperty name="memberDto" property="*"/>
<%
    if (!request.getParameter("password2").equals(memberDto.getPassword())) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        return;
    }
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");

    memberDto.setBirthdayFromString(year, month, day);

    boolean ok = new MemberDao().save(memberDto);
    response.sendRedirect("signup-result.jsp?ok=" + ok);
%>