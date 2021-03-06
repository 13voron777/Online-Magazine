<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 24.02.2022
  Time: 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>First Page</title>
        <style><%@include file="/CSS/common.css"%></style>
    </head>
    <body>
        <h2>Welcome, <sec:authentication property="name"/>!</h2>
        <button onclick="window.location = '${pageContext.request.contextPath}/article/sub_articles'">
            Tape
        </button>
        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/journal/sub_journals'">
            Subscribes
        </button>
        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/journal/all'">
            Journals
        </button>
        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/article/all'">
            Articles
        </button>
        <br/><br/>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button onclick="window.location = '${pageContext.request.contextPath}'">
                Log out
            </button>
        </form>
    </body>
</html>
