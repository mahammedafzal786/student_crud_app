<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<link rel="stylesheet" type="text/css" href="registration.css">
</head>
<body>
		<div class="regform">
			<form action="InsertStudentServlet" method="post">
		
				<h3>Student Registration</h3>
		
				<table>
					<tr>
						<td>Name : </td>
						<td><input type="text" name="name" placeholder="Enter the name"></td>
					</tr>
					<tr>
						<td>STD : </td>
						<td><input type ="text" name="std" placeholder="Enter STD"></td>
					</tr>
					<tr>
						<td>Marks : </td>
						<td><input type ="text" name="marks" placeholder="Enter Marks"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button><a href="ListStudentServlet">List Students</a></button></td>
					</tr>	
				</table>

			</form>
	</div>
</body>
</html>