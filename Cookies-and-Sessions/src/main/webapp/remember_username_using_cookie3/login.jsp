<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.Cookie"%>

<%
String savedUsername = "";

Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie c : cookies) {
		if ("username".equals(c.getName())) {
	savedUsername = c.getValue();
	break; // No need to continue looping
		}
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<h2>Login Page</h2>

	<form action="${pageContext.request.contextPath}/login" method="post">
		Username: <input type="text" name="username"
			value="<%=savedUsername%>"> <br>
		<br> Password: <input type="password" name="password"> <br>
		<br> Remember Username: <input type="checkbox" name="remember">
		<br>
		<br> <input type="submit" value="Login">
	</form>

	<%
	String msg = request.getParameter("msg");
	if ("success".equals(msg)) {
	%>
	<h3 style="color: green;">Login Successful!</h3>
	<%
	}
	%>

	<br>
	<a href="${pageContext.request.contextPath}/delete-cookie">Delete
		Saved Username</a>

</body>
</html>