<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget Password</title>
</head>
<body>
		<h2>Forget Password Page</h2>
		
		
	<form action="ForgetPasswordServlet" method="post">
	${Error}
		<table>
			<tr>
				<td>Email ID : </td>
				<td><input type="text" name="emailid" /> </td>
			</tr>
			
			<tr>
				<td> </td>
				<td><input type="submit"/>  <a href='login.jsp'> Login </td>
					 
			</tr>
		</table>
	</form>
</body>
</html>