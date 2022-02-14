<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 12.02.2022
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Articles</title>
    </head>
    <body>
        <div class="section">
            <div class="section_container">
                <h1>List of articles</h1>
                <c:forEach items="${article}" var="articlei">
                    <div class="list_item">
                        <a href="<c:url value="/article/item?id=${articlei.id}"/>">
                            <span>${articlei.header}</span>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <br/>
        <button onclick="window.location = 'create_article.jsp'">Create a new article</button>
    </body>
</html>