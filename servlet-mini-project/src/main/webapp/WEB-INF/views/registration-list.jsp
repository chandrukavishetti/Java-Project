<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.studentcourse.model.Registration"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration List</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

.active {
	color: green;
	font-weight: bold;
}

.completed {
	color: blue;
	font-weight: bold;
}
</style>
</head>
<body>

	<h2>Student Course Registrations</h2>

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
	List<Registration> registrations = (List<Registration>) request.getAttribute("registrations");
	if (registrations != null && !registrations.isEmpty()) {
	%>
	<table>
		<thead>
			<tr>
				<th>Student ID</th>
				<th>Student Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Trainer</th>
				<th>Registration Date</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Registration r : registrations) {
			%>
			<tr>
				<td><%=r.getStudentId()%></td>
				<td><%=r.getStudentName()%></td>
				<td><%=r.getEmail()%></td>
				<td><%=r.getPhone()%></td>
				<td><%=r.getCourseId()%></td>
				<td><%=r.getCourseName()%></td>
				<td><%=r.getTrainerName()%></td>
				<td><%=r.getRegistrationDate()%></td>
				<td class="<%=r.getStatus()%>"><%=r.getStatus()%></td>
				<td>
					<form action="update-registration-status" method="post"
						style="display: inline;">
						<input type="hidden" name="studentId"
							value="<%=r.getStudentId()%>"> <input type="hidden"
							name="courseId" value="<%=r.getCourseId()%>"> <select
							name="status" onchange="this.form.submit()">
							<option value="active"
								<%=r.getStatus().equals("active") ? "selected" : ""%>>Active</option>
							<option value="completed"
								<%=r.getStatus().equals("completed") ? "selected" : ""%>>Completed</option>
						</select>
					</form> <a
					href="delete-registration?studentId=<%=r.getStudentId()%>&courseId=<%=r.getCourseId()%>"
					onclick="return confirm('Are you sure you want to delete this registration?')">Delete</a>
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
	<h3 style="color: red;">No registrations found</h3>
	<%
	}
	%>

	<br>
	<a href="dashboard">Back to Dashboard</a>

</body>
</html>