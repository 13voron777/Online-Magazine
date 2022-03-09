<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 25.02.2022
  Time: 4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h2>Online magazine user registration</h2>
    <form method="POST" action="${pageContext.request.contextPath}/register">
        <table>
            <tr>
                <td><label for="user_id">Id</label></td>
                <td><input type="number" name="user_id" id="user_id"/></td>
            </tr>
            <tr>
                <td><label for="login">Login</label></td>
                <td><input type="text" name="login" id="login"/></td>
            </tr>
            <tr>
                <td><label for="password">Password</label></td>
                <td><input type="password" name="password" id="password"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Register">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
