<html>

<head>
<title>First Web Application</title>
</head>

<body>
	<span th:text="${errorMessage}" th:style="'color: red;'"></span>
	<form method="post">
		Name : <input type="text" name="name" />
		Password : <input type="password" name="password" /> 
		<input type="submit" />
	</form>
</body>

</html>