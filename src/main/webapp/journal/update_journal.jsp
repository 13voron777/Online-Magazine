<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 15.03.2022
  Time: 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update Journal</title>
        <style><%@include file="/CSS/common.css"%></style>
    </head>
    <body>
        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <form method="post" action="${pageContext.request.contextPath}/journal/update/${journal.id}">
                <h3>Update journal ${journal.name}</h3>
                <input name="name" type="text" placeholder="Name ">
                <br/>
                <textarea name="description" placeholder="Description " rows="10" cols="20"></textarea>
                <br/><br/>
                <button>Update journal</button>
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
