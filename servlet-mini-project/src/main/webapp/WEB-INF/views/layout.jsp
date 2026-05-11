<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Course Management System</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<div class="container">
		<div class="header">
			<h1>📚 Student Course Management System</h1>
			<p>Manage students, courses, and registrations efficiently</p>
		</div>

		<%
		HttpSession sessionObj = request.getSession(false);
		String loggedInUser = (sessionObj != null) ? (String) sessionObj.getAttribute("loggedInUser") : null;
		if (loggedInUser != null) {
		%>
		<div class="navbar">
			<div class="nav-links">
				<a href="${pageContext.request.contextPath}/dashboard">🏠
					Dashboard</a> <a href="${pageContext.request.contextPath}/student-view">👨‍🎓
					Students</a> <a href="${pageContext.request.contextPath}/view-courses">📖
					Courses</a> <a
					href="${pageContext.request.contextPath}/registration-form">📝
					Register Course</a> <a
					href="${pageContext.request.contextPath}/view-registrations">📋
					Registrations</a>
			</div>
			<div class="user-info">
				👤 Welcome,
				<%=loggedInUser%>
				| <a href="${pageContext.request.contextPath}/logout"
					style="color: white; text-decoration: none;">🚪 Logout</a>
			</div>
		</div>
		<%
		}
		%>

		<div class="content">
			<!-- Dynamic content will be inserted here -->
			${pageContent}
		</div>

		<div class="footer">
			<p>&copy; 2024 Student Course Management System. All rights
				reserved.</p>
		</div>
	</div>

</body>
</html>