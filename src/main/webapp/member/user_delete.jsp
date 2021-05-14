<%@page import="miniproject.book_management.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    String id =request.getParameter("id");
    String pw = request.getParameter("pw");

    MemberDao member = MemberDao.getInstance();
    int check = member.checkpw(id,pw);

    if(check ==1){
        member.deleteUser(id);
        session.invalidate();
    }
%>
<!DOCTYPE>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>회원탈퇴</title>
</head>
<body>
<h4>회원 정보 삭제</h4>
<%-- 잘못된 속성 --%>
<div aline="center">
    회원정보가 삭제되었습니다.<br>
<%-- onclick 대신 javascript의 addEventListener() 쓰기  --%>
    <input type="button" value="확인"onclick="location.href=''">
</div>
</body>
</html>
<%-- 잘못된 괄호 --%>
<%}else{%>


<%-- javascript 분리하기 --%>
<script>
//    todo: alert 바꾸기
    alert("비밀번호가 틀렸습니다.");
    history.go(-1);  //이전 페이지로 가기
</script>
<%}%>


