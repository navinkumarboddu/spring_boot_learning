<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
<title>Add Todo Page</title>
<link rel="stylesheet"
	th:href="@{/webjars/bootstrap/5.3.3/css/bootstrap.min.css}" />
</head>

<body>
	<div class="container">

		<form th:action="@{/add-todos}" method="post" th:object="${todo}">
			<fieldset class="form-group">
				<label>Description</label>
				<input type="text" th:field="*{desc}" class="form-control" required="required" />
				<!-- Add Thymeleaf validation error message -->
				<small class="form-text text-warning" th:if="${#fields.hasErrors('desc')}" th:errors="*{desc}"></small>
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form>

	</div>

	<!-- Include jQuery and Bootstrap JS from WebJars -->
	<script th:src="@{/webjars/jquery/3.7.1/jquery.min.js}"></script>
	<script th:src="@{/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js}"></script>

</body>

</html>
