<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="User.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form New</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
    String[] transportTypes = user.getKoT(); 
    // Lấy các giá trị KindOfTransport đã chọn (KoT)
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String birthdayFormatted = "";
	if (user.getBoD()!= null) {
    birthdayFormatted = dateFormat.format(user.getBoD());
}

%>
<form action="/helloword/EditServlet" method="post">
    <h1>Edit Info</h1><br>
    <label>Your name: </label>
    <input type="text" id="name" name="name" value="<%= user.getName() %>" readonly><br>
    <label>Email Address: </label>
    <input type="email" id="email" name="email" value="<%= user.getEmail() %>"><br>
    <label>Locate: </label>
    <input type="text" id="locate" name="locate" value="<%= user.getLocate() %>"><br>
    <label>Phone: </label>
	<input type="text" id="phone" name="phone" value="<%= user.getPhone() %>"><br>
    <label>Sex:</label>
    <label for="male" class="gender">
        <input type="radio" id="male" name="gender" value="0" <%= !user.isSex() ? "checked" : "" %>>
        Nam
    </label>
    <label for="female" class="gender">
        <input type="radio" id="female" name="gender" value="1" <%= user.isSex() ? "checked" : "" %>>
        Nữ
    </label><br>
    <label>BirthDay: </label>
    <input type="date" id="birthday" name="birthday" value="<%= birthdayFormatted %>"><br>
    <label>Kind of transport:</label>
    <label for="In home" class="Type">
        <input type="checkbox" id="Home" name="Type" value="In home" 
            <%= (transportTypes != null && java.util.Arrays.asList(transportTypes).contains("In home")) ? "checked" : "" %>>
        In home
    </label>
    <label for="In office" class="Type">
        <input type="checkbox" id="Office" name="Type" value="In office" 
            <%= (transportTypes != null && java.util.Arrays.asList(transportTypes).contains("In office")) ? "checked" : "" %>>
        In office
    </label>
    <label for="Other" class="Type">
        <input type="checkbox" id="Other" name="Type" value="Other" 
            <%= (transportTypes != null && java.util.Arrays.asList(transportTypes).contains("Other")) ? "checked" : "" %>>
        Other
    </label><br>
    
    <input type="submit" value="Confirm">
</form>
</body>
</html>
