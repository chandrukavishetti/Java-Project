<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial;
}

table {
	margin: 20px auto;
}

td {
	padding: 10px;
}

.error {
	color: red;
	font-weight: bold;
	text-align: center;
}
</style>
</head>
<body>
	<h2 align="center">Online Exam Result Preview System</h2>
	<%
	String errorMsg = (String) request.getAttribute("errorMsg");
	if (errorMsg != null) {
	%>
	<p class="error"><%=errorMsg%></p>
	<%
	}
	%>
	
	<form action="${pageContext.request.ContextPath }/onlineexam" method="post">
	<table>
	<tr>
	<td>
	
	
	</table>
	
	
	</form>

</body>
</html>