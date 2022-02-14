<%--
  Created by IntelliJ IDEA.
  User: OLEG
  Date: 14.02.2022
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Journals</title>
    </head>
    <body>
        <div class="section">
            <div class="section_container">
                <h1>List of journals</h1>
                <c:forEach items="${journal}" var="journali">
                    <div class="list_item">
                        <a href="<c:url value="/journal/item?id=${journali.id}"/>">
                            <span>${journali.name}</span>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <br/>
        <button onclick="window.location = 'create_journal.jsp'">Create a new journal</button>
    </body>
</html>
