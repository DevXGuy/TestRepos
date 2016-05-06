<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Register</title>
</head>
<body>
	<form action="/SchoolMgmt/RegisterServlet" method="post">
		<label>Name: </label><input type="text" name="txtName"> <label>Email:</label><input
			type="text" name="txtEmail"> <label>Password:</label><input
			type="text" name="txtPassword"> <input type="submit"
			name="btnSubmit" value="Register">
	</form>
</body>
</html>