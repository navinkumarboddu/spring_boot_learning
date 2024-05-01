<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <title>First Web Application</title>
</head>

<body>
	<div class="container">
    <table class="table table-striped">
        <caption>Your todos are</caption>
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is it Done?</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="todo : ${todos}">
            <td th:text="${todo.desc}">Description</td>
            <td th:text="${todo.targetDate}">Target Date</td>
            <td th:text="${todo.done}">Is it Done?</td>
        </tr>
        </tbody>
    </table>
    <div><a class="button" href="/add-todos">Add a Todo</a></div>
</div>
</body>

</html>
