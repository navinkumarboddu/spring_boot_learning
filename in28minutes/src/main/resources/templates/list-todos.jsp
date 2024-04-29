<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <title>First Web Application</title>
</head>

<body>
	<p>Here are the list of your todos: <span th:text="${todos}"></span></p>
    <ul>
        <li th:each="todo : ${todos}" th:text="${todo}"></li>
    </ul>
    <p>Your Name is: <span th:text="${name}"></span></p>
</body>

</html>
