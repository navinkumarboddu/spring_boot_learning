<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <title>First Web Application</title>
</head>

<body>
    <p>Welcome <span th:text="${name}"></span>!!</p>
    <a href="/list-todos">Click here to manage your todos</a>
</body>

</html>
