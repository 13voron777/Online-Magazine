<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 14.03.2022
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles</title>
    <style><%@include file="/CSS/common.css"%></style>
</head>
<body>
<div class="section">
    <div class="section_container">
        <h1>Tape</h1>
        <c:forEach items="${article}" var="articlei">
            <div class="list_item">
                <a href="<c:url value="/article/item?id=${articlei.id}"/>">
                    <span>${articlei.header}</span>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
<br/><br/>
<button onclick="window.location = '${pageContext.request.contextPath}/main'">Main</button>
</body>
</html>
