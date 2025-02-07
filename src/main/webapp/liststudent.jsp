<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="registration.css">
</head>
<body>
		<%
		
			ArrayList<StudentBean>	list = (ArrayList<StudentBean>)request.getAttribute("list");
		
		%>
		
		
		 <h3>Student List Page</h3>
		 
		<div class="regform">
		 <table border='1'> 		
		 			   				
		 	<tr>					
		 							
		  		<td>Roll No</td>	
		 		<td>Name</td>		
		 		<td>STD</td>		
		 		<td>Marks</td>		
		 		<td>Action</td>		
		 							
		 	</tr>					
		 
		<%  
		 for(int i = 0; i < list.size(); i++) {
			 StudentBean s = list.get(i);
		 %>	 
			 	<tr>								
			 										
			  		<td> <%=s.getRno()%></td>		
			 		<td><%=s.getName()%></td>		
			 		<td><%=s.getStd()%></td>			
			 		<td><%=s.getMarks()%></td>		
			 		<td> <a href='EditStudentServlet?rno=<%=s.getRno()%>'> EDIT | <a href='DeleteStudentServlet?rno=<%=s.getRno()%>'> DELETE</td>			
			 										
			 	</tr>		
			 							
			
		<%} %>	 
		 
		 
		 </table>	
		 </div>
		 <br><br>
		 
			 <a href="registration.jsp"><button>New Student</button></a>				
		 	
		 	<a href="login.jsp"><button>Loguot</button></a>		
		 
		
	
		
		
</body>
</html>