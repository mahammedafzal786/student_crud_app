<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<%!
	
		int getCube(int i){
			return (i*i*i);
		}
	
	%>
	
	<%
	
		for(int i=1;i<=10;i++){
			out.print(5+" * "+ i +" = "+(5*i)+"<br>");
		}
	
	%>
	
	Addition : <%=getCube(2)%>
	
</body>
</html>