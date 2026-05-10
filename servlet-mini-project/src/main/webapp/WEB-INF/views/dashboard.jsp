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
	<!-- 	this below code is going to display the message of student added successfully or not -->
	<%
	String message = (String) session.getAttribute("message");
	if (message != null) {
	%>
	<h3 style="color: green;"><%=message%></h3>
	<%
	session.removeAttribute("message");
	}
	%>

	<a href="student-form">Add Student</a>

	<br>
	<br>

	<a href="student-view">view all students</a>

	<br>
	<br>

	<a href="student-edit">update student</a>
	<br>
	<br>

	<a href="student-delete">delete student</a>

	<br>
	<br>

	<a href="add-course"> add course</a>

	<br>
	<br>

	<a href="update-course"> Update Course</a>
	<br>
	<br>


	<a href="registration-form">Register Student for Course</a>

	<br>
	<br>
	<a href="view-registrations">View Registrations</a>

	<br>
	<br>
	<a href="view-registrations"> delete registration</a>
	<br>
	<br>

	<a href="${pageContext.request.contextPath}/view-courses">View
		Courses</a>
	<br>
	<br>

	<a href="logout">Logout</a>

</body>
</html>