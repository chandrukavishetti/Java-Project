<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Error Page</title>
</head>
<body>

	<h2 style="color: red;">An Error Occurred</h2>

	<%
	String errorMsg = (String) request.getAttribute("error");
	if (errorMsg == null) {
		errorMsg = (String) session.getAttribute("error");
	}
	if (errorMsg == null && exception != null) {
		errorMsg = exception.getMessage();
	}
	if (errorMsg == null) {
		errorMsg = "Something went wrong. Please try again later.";
	}
	%>

	<h3><%=errorMsg%></h3>

	<br>
	<a href="dashboard">Go to Dashboard</a>
	<br>
	<a href="login">Go to Login</a>

</body>
</html>