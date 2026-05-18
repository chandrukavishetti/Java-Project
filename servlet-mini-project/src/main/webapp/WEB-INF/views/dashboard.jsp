<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Dashboard</title>
</head>
<body>

	<div class="dashboard-container">

		<header class="dashboard-header" style="text-align: center;">
			<h1>Welcome Admin</h1>
			<h3>Logged In User : ${sessionScope.loggedInUser}</h3>
		</header>

		<hr>

		<div class="alert-section">
			<%
			String message = (String) session.getAttribute("message");
			if (message != null) {
			%>
			<h3 style="color: green; text-align: center;"><%=message%></h3>
			<%
			session.removeAttribute("message");
			}
			%>
		</div>

		<main class="dashboard-grid">

			<section class="nav-card">
				<h2>Student Management</h2>
				<div class="nav-links">
					<a href="student-form" class="btn-link">Add Student</a> <a
						href="student-view" class="btn-link">View All Students</a> <a
						href="student-edit" class="btn-link">Update Student</a> <a
						href="student-delete" class="btn-link">Delete Student</a>
				</div>
			</section>

			<section class="nav-card">
				<h2>Course Management</h2>
				<div class="nav-links">
					<a href="add-course" class="btn-link">Add Course</a> <a
						href="update-course" class="btn-link">Update Course</a> <a
						href="${pageContext.request.contextPath}/view-courses"
						class="btn-link">View Courses</a>
				</div>
			</section>

			<section class="nav-card">
				<h2>Registration Management</h2>
				<div class="nav-links">
					<a href="registration-form" class="btn-link">Register Student
						for Course</a> <a href="view-registrations" class="btn-link">View
						Registrations</a> <a href="view-registrations" class="btn-link">Delete
						Registration</a>
				</div>
			</section>

			<section class="nav-card account-card">
				<h2>Account</h2>
				<div class="nav-links">
					<a href="logout" class="btn-link logout-link">Logout</a>
				</div>
			</section>

		</main>

	</div>

</body>
</html>