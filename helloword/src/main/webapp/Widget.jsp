<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input
	{
		margin: 5px;
		border-radius: 5px;
	}
	.Type
	{
		font-family: Arial;
    	font-style: italic;
    	font-size: 12px;
	}
</style>
</head>
<body>
<form action="/helloword/helloworld" method="post">
	<h1>Widget Order Form</h1><br>
	<label>Quantity: </label>
	<input type="text" id="quantity" name="quantity"><br>
	<label>Your name: </label>
	<input type="text" id="name" name="name"><br>
	<label>Email Address: </label>
	<input type="email" id="email" name="email"><br>
	<label>Kind of transport:</label>
	<label for="In home" class="Type">
            <input type="checkbox" id="Home" name="Type" value="In home">
            In home
        </label>
        <label for="In office" class="Type">
            <input type="checkbox" id="Office" name="Type" value="In office">
            In office
        </label>
        <label for="Other" class="Type">
            <input type="checkbox" id="Other" name="Type" value="Other" >
            Other
	</label><br>
	
	<label>&nbsp</label><br>
	<input type="submit" value="Confirm" id="submit">
</form> 
</body>
</html>