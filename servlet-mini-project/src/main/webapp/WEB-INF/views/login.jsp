<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body>

	<h2>Admin Login</h2>

	<form action="login-action" method="post">

		Username: <input type="text" name="username"
			value="${rememberedUsername}" required> <br> <br>
		Password: <input type="password" name="password" required> <br>
		<br> Remember Username <input type="checkbox" name="remember">

		<br> <br>

		<button type="submit">Login</button>

	</form>

	<h3 style="color: red;">${error}</h3>

</body>
</html>