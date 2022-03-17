<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 14.02.2022
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Journals</title>
        <style><%@include file="/CSS/common.css"%></style>
    </head>
    <body>
        <h1>Journals</h1>
        <c:forEach items="${journal}" var="journali">
                <a href="<c:url value="/journal/item?id=${journali.id}"/>">
                    <span>${journali.name}</span><br/>
                </a>
        </c:forEach>
        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/main'">Main</button>
        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <button onclick="window.location = 'create_journal.jsp'">Create a new journal</button>
        </sec:authorize>
    </body>
</html>
