<?xml version="1.0" encoding="UTF-8" ?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login Application</title>
</head>
<body>

	<h2>Login Page</h2>

	<form action="loginServlet" method="post">
	${loginError}
		<table>
			<tr>
				<td>UserName : </td>
				<td><input type="text" name="userName" /> </td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="password" name="password" /> </td>
			</tr>
			<tr>
				<td> </td>
				<td><input type="submit"/> </td>
			</tr>
		</table>
	</form>
</body>
</html>