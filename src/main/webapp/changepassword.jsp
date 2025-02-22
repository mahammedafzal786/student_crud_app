<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>
	
	<h2>Change Password</h2>
	
	<form action="ChangePasswordServlet" method="post">
		
		${Error}
				<table>
					<tr>
						<td>Otp : </td>
						<td><input type="text" name="otp" placeholder="Enter the otp"></td>
					</tr>
					<tr>
						<td>Password : </td>
						<td><input type="password" name="password" /> </td>
					</tr>
					<tr>
						<td>Confirm Password : </td>
						<td><input type="password" name="password" /> </td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Reset Password"><button><a href="login.jsp">Login</a></button></td>
					</tr>	
				</table>

			</form>
	
	
</body>
</html>