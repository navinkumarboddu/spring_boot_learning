<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Todo Form</title>
</head>
<body>
    <h2>Todo Form</h2>
    <form action="#" th:object="${todo}" method="post">
        <label for="targetDate">Target Date</label>
        <!-- Populate the input field with the formatted date -->
        <input type="date" id="targetDate" th:value="${formattedDate}" required="required"/>
        <br/>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
