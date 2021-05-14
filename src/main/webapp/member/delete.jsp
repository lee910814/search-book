<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form action="user-delete.jsp" method="post">

    <input type="password" name="check_pw" placeholder="비밀번호를 입력해주세요">

    <input type="submit" value="회원탈퇴">
    <input type="button" value="취소 " onclick="location.href='index.jsp'">

</form>

</body>
</html>
