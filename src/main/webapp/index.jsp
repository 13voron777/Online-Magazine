<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <h2>Welcome to Online Magazine App!</h2>
        <button onclick="window.location = '${pageContext.request.contextPath}/login'">
            Sign in
        </button>
        <br/><br/>
        <button onclick="window.location = '${pageContext.request.contextPath}/registration'">
            Sign up (in development)
        </button>
    </body>
</html>
