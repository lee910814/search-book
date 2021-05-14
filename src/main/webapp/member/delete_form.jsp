<%@ page import="miniproject.book_management.dao.MemberDao" %><%--
  Created by IntelliJ IDEA.
  User: 이의정
  Date: 2021-05-14
  Time: 오후 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");

    String id = (String) session.getAttribute("username");
    String pw = request.getParameter("pw");

    MemberDao memberDao = MemberDao.getInstance();
    if (!memberDao.checkId(id)) {

%>
<script>
    alert("비밀번호가 틀렸습니다.");
    location.href = "";
</script>
<%
} else {
    if (memberDao.deleteUser(id)) {
        session.invalidate();
%>
<script>
    alert("회원탈퇴가 정상 처리 되었습니다.")
    location.href = "";
</script>
<%} else {%>
<script>
    alert("회원 탈퇴에 실패했습니다.")
    location.href = "";
</script>
<%
        }
    }
%>