<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	
		<form action="addUser" method="post">
			Username: <input type="text" name="uname"><br>
			Password: <input type="password" name="upass"><br>
			Role: <input type="text" name="urole"><br>
			<input type="submit" value="Add User">
		</form>
	
		<form action="logout">
			<input type="submit" value="Logout">
		</form>
	</body>
</html>