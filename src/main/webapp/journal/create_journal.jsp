<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 14.02.2022
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Create journal</title>
    </head>
    <body>
    <form method="post" action="${pageContext.request.contextPath}/journal/add">
        <h3>Add new journal</h3>
        <input name="id" type="number" placeholder="Id ">
        <br/>
        <input name="name" type="text" placeholder="Name ">
        <br/>
        <textarea name="description" placeholder="Description " rows="10" cols="30">
                </textarea>
        <button>Add journal</button>
    </form>
    </body>
</html>
