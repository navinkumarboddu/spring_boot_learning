<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <title>First Web Application</title>
</head>

<body>
	ADD TODO PAGE for <span th:text="${name}"></span>
	
<form method="post">
	Description : <input name="desc" type="text"/> 
	<input type="submit"/>	
</form>
</body>

</html>
