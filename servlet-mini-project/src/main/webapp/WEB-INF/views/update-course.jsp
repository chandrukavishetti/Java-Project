<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.studentcourse.model.Course"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Edit Course</title>
</head>
<body>

	<h2>Edit Course</h2>

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
	Course course = (Course) request.getAttribute("course");
	if (course != null) {
	%>
	<form action="update-course" method="post">
		<input type="hidden" name="id" value="<%=course.getId()%>">

		Course Name: <input type="text" name="name"
			value="<%=course.getName()%>" required> <br> <br>
		Duration (Days): <input type="number" name="duration"
			value="<%=course.getDuration()%>" required> <br> <br>
		Fees: <input type="number" step="0.01" name="fees"
			value="<%=course.getFees()%>" required> <br> <br>
		Trainer Name: <input type="text" name="trainername"
			value="<%=course.getTrainer()%>" required> <br> <br>

		<button type="submit">Update Course</button>
	</form>
	<%
	}
	%>

	<br>
	<a href="view-courses">Back to Courses List</a>

</body>
</html>