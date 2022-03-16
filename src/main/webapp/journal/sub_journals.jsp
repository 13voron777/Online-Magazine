<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 14.03.2022
  Time: 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Journals</title>
    <style><%@include file="/CSS/common.css"%></style>
</head>
<body>
<h1>List of journals</h1>
<c:forEach items="${journal}" var="journali">
    <a href="<c:url value="/journal/item?id=${journali.id}"/>">
        <span>${journali.name}</span><br/>
    </a>
</c:forEach>
<br/><br/>
<button onclick="window.location = '${pageContext.request.contextPath}/main'">Main</button>
</body>
</html>
