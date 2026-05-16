<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Add Student</title>
</head>
<body>

	<h2>Add Student</h2>

	<form action="student-add" method="post">

		Name: <input type="text" name="name"> <br> <br>
		Email: <input type="email" name="email"> <br> <br>
		Phone: <input type="text" name="phone"> <br> <br>
		Age: <input type="number" name="age"> <br> <br>
		City: <input type="text" name="city"> <br> <br>

		<button type="submit">Add Student</button>

	</form>

	<h3 style="color: red;">${error}</h3>

</body>
</html>