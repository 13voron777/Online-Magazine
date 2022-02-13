<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 13.02.2022
  Time: 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Create article</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/article/add">
            <h3>Add new article</h3>
            <input name="id" type="number" placeholder="Id ">
            <br/>
            <input name="header" type="text" placeholder="Header ">
            <br/>
            <textarea name="content" placeholder="Content " rows="10" cols="30">
            </textarea>
            <button>Add article</button>
        </form>
    </body>
</html>
