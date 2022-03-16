<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 13.02.2022
  Time: 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>${article.header}</title>
        <style><%@include file="/CSS/common.css"%></style>
    </head>
    <body>
        <h1>${article.header}</h1>
        <p>${article.content}</p>
        <a href="<c:url value="/article/getupdate?id=${article.id}"/>">
            <button>Update Article</button>
        </a>
        <form method="post" action="${pageContext.request.contextPath}/article/remove/${article.id}">
            <button>Delete Article</button>
        </form>

        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/article/all'">Articles</button>
        <button onclick="window.location = '${pageContext.request.contextPath}/main'">Main</button>
    </body>
</html>
