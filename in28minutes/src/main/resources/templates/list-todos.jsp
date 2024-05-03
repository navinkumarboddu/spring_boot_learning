<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Todo's for ${name}</title>
	<link rel="stylesheet" th:href="@{/webjars/bootstrap/5.3.3/css/bootstrap.min.css}"/>
</head>
</head>

<body>
	<div class="container">
    <table class="table table-striped">
        <caption>Your todos are</caption>
        <br/>
        <thead>
	        <tr>
	            <th>Description</th>
	            <th>Target Date</th>
	            <th>Is it Done?</th>
	            <th></th>
	        </tr>
        </thead>
        <tbody>
        <tr th:each="todo : ${todos}">
            <td th:text="${todo.desc}">Description</td>
            <td th:text="${todo.targetDate}">Target Date</td>
            <td th:text="${todo.done}">Is it Done?</td>
             <td><a type="button" class="btn btn-warning" th:href="@{/delete-todo(id=${todo.id})}">Delete</a></td>
		</tr>
        </tbody>
    </table>
    <div><a class="button" href="/add-todo">Add a Todo</a></div>
	<!-- Include jQuery and Bootstrap JS from WebJars -->
	<script th:src="@{/webjars/jquery/3.7.1/jquery.min.js}"></script>
	<script th:src="@{/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js}"></script>
</div>
</body>

</html>
