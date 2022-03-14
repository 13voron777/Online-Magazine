<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 14.02.2022
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>${journal.name}</title>
        <style><%@include file="/CSS/common.css"%></style>
    </head>
    <body>
        <h1>${journal.name}</h1>
        <p>${journal.description}</p>
        <form method="post" action="${pageContext.request.contextPath}/journal/subscribe/${journal.id}">
            <button>Subscribe</button>
        </form>
        <form method="post" action="${pageContext.request.contextPath}/journal/unsubscribe/${journal.id}">
            <button>Unsubscribe</button>
        </form>

        <br/>
        <div class="section">
            <div class="section_container">
                <h2>List of articles</h2>
                <c:forEach items="${journal.articles}" var="articlei">
                    <div class="list_item">
                        <a href="<c:url value="/article/item?id=${articlei.id}"/>">
                            <span>${articlei.header}</span>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/journal/all'">Back</button>
        <button onclick="window.location = '${pageContext.request.contextPath}/firstPage'">To main</button>
    </body>
</html>
