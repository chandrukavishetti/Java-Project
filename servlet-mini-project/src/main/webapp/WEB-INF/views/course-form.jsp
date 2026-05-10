<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>
</head>
<body>

	<h2>Add Course</h2>

	<%
	String error = (String) request.getAttribute("error");
	if (error != null) {
	%>
	<h3 style="color: red;"><%=error%></h3>
	<%
	}
	%>

	<form action="add-course" method="post">

		Course Name: <input type="text" name="name" required> <br>
		<br> Duration (in days): <input type="number" name="duration"
			required> <br>
		<br> Fees: <input type="number" step="0.01" name="fees" required>
		<br>
		<br> Trainer Name: <input type="text" name="trainer_name"
			required> <br>
		<br>

		<button type="submit">Add Course</button>

	</form>

	<br>
	<a href="dashboard">Back to Dashboard</a>

</body>
</html>