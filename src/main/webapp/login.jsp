<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 23.02.2022
  Time: 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
        <style><%@include file="/CSS/common.css"%></style>
    </head>
    <body>
        <h1>Login Page</h1>
        <h2>Enter your credentials</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <p>Login: </p>
            <input type="text" name="username"/><br/>
            <br/>
            <p>Password: </p>
            <input type="password" name="password">
            <br/>
            <input type="submit" value="Login">
        </form>
        <c:if test="${not empty param.error}">
            <div class="error">
                <p>Error! Try again!</p><br/>
            </div>
        </c:if>
        <button onclick="window.location = '${pageContext.request.contextPath}'">To main</button>
    </body>
</html>
