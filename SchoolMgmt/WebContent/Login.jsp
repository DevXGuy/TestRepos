<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Login</title>
</head>
<body>

	<div>
		<form action="/SchoolMgmt/UserMgmt/LoginServlet" method="post">
			<p>
				<label>Username: </label><input type="text" id="txtUsername" />
			</p>
			<p>
				<label>Password: </label><input type="password" id="txtPassword" />
			</p>
			<p>
				<input type="submit" id="btnLogin" value="Login">
			</p>
		</form>
	</div>

</body>
</html>