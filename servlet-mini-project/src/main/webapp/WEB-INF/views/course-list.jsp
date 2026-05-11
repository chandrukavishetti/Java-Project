<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.studentcourse.model.Course"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Courses List</title>
</head>
<body>

	<h2>Course List</h2>

	<%
	String message = (String) session.getAttribute("message");
	if (message != null) {
	%>
	<h3 style="color: green;"><%=message%></h3>
	<%
	session.removeAttribute("message");
	}
	%>

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
	List<Course> courses = (List<Course>) request.getAttribute("courses");
	if (courses != null && !courses.isEmpty()) {
	%>
	<table border="1" cellpadding="10">
		<thead>
			<tr>
				<th>ID</th>
				<th>Course Name</th>
				<th>Duration (Days)</th>
				<th>Fees</th>
				<th>Trainer Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Course c : courses) {
			%>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getName()%></td>
				<td><%=c.getDuration()%></td>
				<td><%=c.getFees()%></td>
				<td><%=c.getTrainer()%></td>
				<td><a href="course-edit?id=<%=c.getId()%>">Edit</a> | <a
					href="course-delete?id=<%=c.getId()%>"
					onclick="return confirm('Are you sure you want to delete this course?')">Delete</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	} else {
	%>
	<h3 style="color: red;">No courses found</h3>
	<%
	}
	%>

	<br>
	<a href="dashboard">Back to Dashboard</a>

</body>
</html>