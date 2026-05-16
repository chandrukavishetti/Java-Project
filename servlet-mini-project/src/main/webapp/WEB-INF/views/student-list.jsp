<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.studentcourse.model.Student"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Student List</title>
</head>
<body>

	<h2>Student List</h2>
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
	List<Student> students = (List<Student>) request.getAttribute("students");
	if (students != null && !students.isEmpty()) {
	%>
	<table border="1" cellpadding="10">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Age</th>
				<th>City</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Student s : students) {
			%>
			<tr>
				<td><%=s.getId()%></td>
				<td><%=s.getName()%></td>
				<td><%=s.getEmail()%></td>
				<td><%=s.getPhone()%></td>
				<td><%=s.getAge()%></td>
				<td><%=s.getCity()%></td>
				<td><a href="student-edit?id=<%=s.getId()%>">Edit</a> | <a
					href="student-delete?id=<%=s.getId()%>"
					onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
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
	<h3 style="color: red;">No students found</h3>
	<%
	}
	%>

	<br>
	<a href="dashboard">Back to Dashboard</a>

</body>
</html>