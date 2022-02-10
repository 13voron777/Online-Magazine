<html>
<body>
<h2>Hello World!</h2>
<div class="list_container">
    <c:forEach items="${articles}" var="article">
        <div class="list_item">
            <span>${article.id}</span>
            <b>${article.header}</b>
            <p>${article.content}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
