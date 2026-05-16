<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.studentcourse.model.Student"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Edit Student</title>
</head>
<body>

	<h2>Edit Student</h2>

	<%
	String error = (String) session.getAttribute("error");
	if (error != null) {
	%>
	<h3 style="color: red;"><%=error%></h3>
	<%
	session.removeAttribute("error");
	}
	%>

	<%
	Student student = (Student) request.getAttribute("student");
	if (student != null) {
	%>
	<form action="student-update" method="post">
		<input type="hidden" name="id" value="<%=student.getId()%>">

		Name: <input type="text" name="name" value="<%=student.getName()%>"
			required> <br> <br> Email: <input type="email"
			name="email" value="<%=student.getEmail()%>" required> <br>
		<br> Phone: <input type="text" name="phone"
			value="<%=student.getPhone()%>" required> <br> <br>
		Age: <input type="number" name="age" value="<%=student.getAge()%>"
			required> <br> <br> City: <input type="text"
			name="city" value="<%=student.getCity()%>" required> <br>
		<br>

		<button type="submit">Update Student</button>
	</form>
	<%
	}
	%>

	<br>
	<a href="student-view">Back to Student List</a>

</body>
</html>