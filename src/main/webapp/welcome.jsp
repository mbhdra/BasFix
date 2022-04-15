<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		Welcome ${uname} <br>
		<a href="videos.jsp">Videos</a><br>
		<a href="register.jsp">Add New User</a><br>
		
		<form action="logout">
			<input type="submit" value="Logout">
		</form>
</body>
</html>