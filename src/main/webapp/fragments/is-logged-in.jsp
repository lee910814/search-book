<%@ page contentType="text/html;charset=UTF-8" %>
<%
  if (session.getAttribute("memberId") == null) {
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    return;
  }
%>