<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.studentcourse.dao.StudentDAO"%>
<%@ page import="com.studentcourse.dao.CourseDAO"%>
<%@ page import="com.studentcourse.model.Student"%>
<%@ page import="com.studentcourse.model.Course"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Student for Course</title>
</head>
<body>

	<h2>Register Student for Course</h2>

	<%
	String error = (String) session.getAttribute("error");
	if (error != null) {
	%>
	<h3 style="color: red;"><%=error%></h3>
	<%
	session.removeAttribute("error");
	}
	%>

	<form action="register-course" method="post">

		Select Student: <select name="studentId" required>
			<option value="">-- Select Student --</option>
			<%
			StudentDAO studentDao = new StudentDAO();
			List<Student> students = studentDao.viewStudent();
			for (Student s : students) {
			%>
			<option value="<%=s.getId()%>"><%=s.getName()%> -
				<%=s.getEmail()%></option>
			<%
			}
			%>
		</select> <br>
		<br> Select Course: <select name="courseId" required>
			<option value="">-- Select Course --</option>
			<%
			CourseDAO courseDao = new CourseDAO();
			List<Course> courses = courseDao.getAllCourses();
			for (Course c : courses) {
			%>
			<option value="<%=c.getId()%>"><%=c.getName()%> -
				<%=c.getTrainer()%></option>
			<%
			}
			%>
		</select> <br>
		<br>

		<button type="submit">Register</button>

	</form>

	<br>
	<a href="dashboard">Back to Dashboard</a>

</body>
</html>