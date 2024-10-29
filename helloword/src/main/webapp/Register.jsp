<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register File</title>
</head>
<body>
<form action="/helloword/DBServlet" method="post">
	<label>Full name: </label><br>
	<input type="text" id="Name" name="RegisName" required><br>
	
	<label>Password: </label><br>
	<input type="password" id="Pass" name="RegisPass" required><br>
	
	<label>&nbsp</label>
	<input type="submit" value="Apply" name="Apply" id="Apply">
</form>
</body>
</html>