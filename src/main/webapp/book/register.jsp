<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/fragments/is-method-post.jsp" %>
<jsp:useBean id="bookManageDao" class="miniproject.book_management.dao.BookManageDao"/>
<c:redirect url="register-result.jsp?ok=${bookManageDao.save(param.id)}"/>