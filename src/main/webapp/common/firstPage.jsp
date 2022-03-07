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
    </head>
    <body>
        <h2>Welcome, <sec:authentication property="name"/>!</h2>
        <button onclick="window.location = '${pageContext.request.contextPath}/journal/all'">
            To journals
        </button>
        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/journal/all'">
            To subscribed journals (in develop)
        </button>
        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/article/all'">
            To articles
        </button>
        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/article/all'">
            To subscribed journal's articles (in develop)
        </button>
        <br/><br/>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button onclick="window.location = '${pageContext.request.contextPath}'">
                Log out
            </button>
        </form>
    </body>
</html>
