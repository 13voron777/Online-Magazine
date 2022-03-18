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
        <style><%@include file="/CSS/common.css"%></style>
    </head>
    <body>
        <div class="section">
            <div class="section_container">
                <h1>Articles</h1>
                <br/>
                <c:forEach items="${article}" var="articlei">
                    <div class="list_item">
                        <a href="<c:url value="/article/item?id=${articlei.id}"/>">
                            <h3>${articlei.header}</h3>
                        </a>
                        <span>${articlei.content}</span>
                        <br/>
                    </div>
                </c:forEach>
            </div>
        </div>
        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/main'">Main</button>
    </body>
</html>
