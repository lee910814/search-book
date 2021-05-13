<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>library</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">
</head>
<body>
<h1><b>회원가입</b></h1>

<form action="signup.jsp" method="post" id="join-form">
    <label for="username">아이디</label> <br>
    <input required type="text" name="username" id="username"><br>
    <label for="password">비밀번호</label> <br>
    <input required type="password" name="password" id="password"><br>
    <label for="password-check">비밀번호 확인</label> <br>
    <input required type="password" name="password2" id="password-check"><br>
    <label for="name">이름</label> <br>
    <input required type="text" name="name" id="name"><br>
    <label for="year">생년월일</label> <br>
    <input required type="number" name="year" class="year" id="year" min="1900" max="2021">
    <select name="month" id="month">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
        <option>10</option>
        <option>11</option>
        <option>12</option>
    </select>
    <input type="number" name="day" class="month" id="day" min="1" max="31" required><br>
    <button id="button"><a href="signup-result.jsp"><b>가입하기</b></a></button>
</form>
<script src="${pageContext.request.contextPath}/js/signUp.js"></script>
</body>
</html>