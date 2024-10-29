<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí</title>
<style>
@charset "UTF-8";
    h1
    {
        color: black;
        font-family: Georgia;
    }
    p
    {
        color: white;
        font-family: Serif;
        font-style: italic;
    }
    form
    {
        font-weight: Bold;
    }
    a
    {
        font-family:Arial;
    }
    option
    {
        font-family: Serif;
        font-weight: Bold;
        font-style: italic;
    }
    #submit
    {
        font-weight: Bold;
        font-family:Arial;
        padding: 5px;
    }
    #Shoplink
    {
        font-weight: Bold;
        font-size:25;
    }
    .gender
    {
        font-style: italic;
    }
    .GiveAddress
    {
        font-style: italic;
    } 
    html
    {
        background-color: #FF9000;
    }
    input
    {
        padding: 5px;
        border-radius: 5px;
        margin: 5px;
    }
    img
    {
        border-radius: 100px;
    }
    #Tpho
    {
        padding: 7px;
        margin: 5px;
    }
    
</style>
</head>
<body>
<h1>Form đăng kí thông tin khách hàng</h1>
<p>Form này được tạo ra với mục đích nhập dữ liệu và thông tin của khách hàng tham gia mua sản phẩm.</p>
<lable id="Shoplink">Link facebook shop:</lable>
<a href="https://www.facebook.com/profile.php?id=100073106232050">Tại đây.</a><br>
<img src="https://downloadlogomienphi.com/sites/default/files/logos/download-logo-vector-shopee-mien-phi.jpg" title="Ảnh logo"><br>
	<form action="emailList" method="post">
		<input type="hidden" name="action" value="add">
		
		<label>Email:</label>
		<input type="email" name="email" required><br>
		
		<label>Họ và tên:</label>
		<input type="text" name="Hoten" required><br>
		
		<label>Ngày sinh:</label>
		<input type="date" name="ngaysinh" required><br>
		
		<label>Địa chỉ:</label>
		<input type="text" name="Address" required><br>
		
		<label>Thành phố:</label>
		<select id="Tpho" name="Tpho">
		<option value="Tpho">Hồ Chí Minh</option>
		<option value="Tpho">Hà Nội</option>
		<option value="Tpho">Đà Nẵng</option>
		<option value="Tpho">Kon Tum</option>
		<option value="Tpho">Quảng Nam</option>
		<option value="Tpho">Quảng Trị</option>
		<option value="Tpho">Quảng Bình</option>
		<option value="Tpho">Quảng Ngãi</option>
		<option value="Tpho">Thừa Thiên Huế</option>
		<option value="Tpho">Gia Lai</option>
		</select><br>
		
		<label>Giới tính:</label>
		<label for="male" class="gender">
            <input type="radio" id="male" name="gender" value="male" required>
            Nam
        </label>
        <label for="female" class="gender">
            <input type="radio" id="female" name="gender" value="female" required>
            Nữ
        </label>
        <label for="other" class="gender">
            <input type="radio" id="other" name="gender" value="other" required>
            Khác
        </label><br>
		
		<label>Nghề nghiệp:</label>
		<input type="text" name="Job" required><br>
		
		<!--Tại phần hình thức giao hàng ta không thể sử dụng required để yêu cầu thông qua HTML cơ bản mà cần phải sử dụng kết hợp JS để thực hiện chức năng này-->
		<label>Hình thức giao hàng:</label>
			<label for="Tại nhà" class="GiveAddress">
            <input type="checkbox" id="Tại nhà" name="Hình thức" value="Tại nhà">
            Tại nhà
        </label>
        <label for="Tại cơ quan" class="GiveAddress">
            <input type="checkbox" id="Tại cơ quan" name="Hình thức" value="Tại cơ quan">
            Tại cơ quan
        </label>
        <label for="Khác" class="GiveAddress">
            <input type="checkbox" id="Khác" name="Hình thức" value="Khác" >
            Khác
		</label><br>
		
		<label>&nbsp</label>
		<input type="submit" value="Apply Now" id="submit">
	</form>
</body>
</html>