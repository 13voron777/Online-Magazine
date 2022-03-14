<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 13.02.2022
  Time: 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Create article</title>
        <style><%@include file="/CSS/common.css"%></style>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/article/add">
            <h3>Add new article</h3>
            <input name="header" type="text" placeholder="Header ">
            <br/>
            <textarea name="content" placeholder="Content " rows="10" cols="30"></textarea>
            <br/>
            <input name="journal_id" type="number" placeholder="Journal_id ">
            <br/><br/>
            <button>Add article</button>
        </form>
        <button onclick="window.location = '${pageContext.request.contextPath}/article/all'">Back</button>
        <button onclick="window.location = '${pageContext.request.contextPath}/firstPage'">To main</button>
    </body>
</html>
