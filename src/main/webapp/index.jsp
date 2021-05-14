<%@ page import="miniproject.book_management.dao.MemberDao" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="memberDao" value="<%=MemberDao.getInstance()%>"/>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>Library</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>

<header>
    <div class="nav--login">
        <c:if test="${empty sessionScope.memberId}">
            <a href="${pageContext.request.contextPath}/member/login-form.jsp" class="login">로그인</a>
            <a href="${pageContext.request.contextPath}/member/signup-form.jsp" class="join">회원가입</a>
        </c:if>
        <c:if test="${not empty sessionScope.memberId}">
            <a href="${pageContext.request.contextPath}/member/logout.jsp" class="login">로그아웃</a>
        </c:if>
    </div>

    <c:if test="${memberDao.isAdmin(sessionScope.memberId)}">
        <div class="header--dropdown">
            <i class="fas fa-align-justify fa-2x"></i>
            <div class="header--dropdown__content">
                <a href="${pageContext.request.contextPath}/book/search-form.jsp">도서 등록</a>
                <a href="#">도서 구매</a>
                <a href="#">도서 후기</a>
            </div>
        </div>
    </c:if>
</header>

<section>
    <h2>
        <a href="${pageContext.request.contextPath}/"><span>l</span><span>i</span><span>b</span><span>r</span><span>a</span><span>r</span><span>y</span></a>
    </h2>

    <form action="${pageContext.request.contextPath}/rental/search-result.jsp" method="get">
        <%--    <select>
                <option>저자명</option>
                <option>도서명</option>
                <option>도서번호</option>
            </select>--%>
        <input id="bookName" type="text" name="name" placeholder="검색어를 입력해주세요">
        <button id="search" type="submit">검색</button>
    </form>
</section>
</body>
</html>