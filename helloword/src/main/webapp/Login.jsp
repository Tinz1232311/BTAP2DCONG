<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login File</title>
</head>
<body>
<form action="/helloword/DBServlet" method="post">
	<label>Full name: </label><br>
	<input type="text" id="Name" name="Name"><br>
	
	<label>Password: </label><br>
	<input type="password" id="Pass" name="Pass"><br>
	
	<label>&nbsp</label>
	<input type="submit" value="Login" name="action" id="Login">
	<input type="submit" value="Register" name="action" id="Register">
</form>
</body>
</html>