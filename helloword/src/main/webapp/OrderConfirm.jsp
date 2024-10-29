<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page import="User.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<title>Insert title here</title>
</head>
<body>
<%
	User user = (User) request.getAttribute("user");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // Bạn có thể thay đổi định dạng tùy ý
	String dateString = dateFormat.format(user.getBoD());
%>
	<h1>Order Confirmation</h1>
	<p>To join our email list, enter your name and email address below.</p>
	<p>Email: ${user.getEmail()}</p>
	<p>Name: ${user.getName()}</p>
	<p>Locate: ${user.getLocate()}</p>
	<p>Phone: ${user.getPhone()}</p>
	<p>Birthday: <%= dateString %></p>
	<% 
		if(user.isSex()) { 
	%>
		<p>Sex: Nữ</p>
	<% 
		} else { 
	%>
		<p>Sex: Nam</p>
	<% 
		} 
	%>

	<span>Delivery: </span>
	<% 
		for(String type : user.getKoT()) { 
	%>
		<span><%= type %></span>
	<% 
		} 
	%>
</body>
</html>