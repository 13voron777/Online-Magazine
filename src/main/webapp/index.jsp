<html>
<body>
<h2>Hello World!</h2>
<c:forEach items="${articles}" var="article">
    <div class="list_item">
        <span>${article.id}</span>
        <span>${article.header}</span>
        <span>${article.content}</span>
    </div>
</c:forEach>
</body>
</html>
