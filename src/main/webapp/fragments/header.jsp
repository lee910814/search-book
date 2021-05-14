<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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