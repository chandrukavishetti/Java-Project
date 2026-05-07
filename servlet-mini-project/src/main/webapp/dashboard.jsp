<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>

	<h1>Welcome Admin</h1>

	<h3>Logged In User : ${sessionScope.loggedInUser}</h3>

	<hr>

	<a href="student-form">Add Student</a>

	<br>
	<br>

	<a href="logout">Logout</a>

</body>
</html>