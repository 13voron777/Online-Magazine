<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 13.02.2022
  Time: 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Create article</title>
        <style><%@include file="/CSS/common.css"%></style>
    </head>
    <body>
        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <form method="post" action="${pageContext.request.contextPath}/article/add/${journal.id}">
                <h3>Add new article</h3>
                <input name="header" type="text" placeholder="Header ">
                <br/>
                <textarea name="content" placeholder="Content " rows="10" cols="30"></textarea>
                <br/><br/>
                <button>Add article</button>
            </form>
        </sec:authorize>
        <a href="<c:url value="/journal/item?id=${journal.id}"/>">
            <button>Back</button>
        </a>
        <button onclick="window.location = '${pageContext.request.contextPath}/main'">
            Main
        </button>
    </body>
</html>
