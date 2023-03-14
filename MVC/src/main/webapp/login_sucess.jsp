<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "bean.Login" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<% 
		Login bean = (Login)request.getAttribute("bean");
		out.print("Welcome, "+bean.getEmail());
		%>
	</body>
</html>