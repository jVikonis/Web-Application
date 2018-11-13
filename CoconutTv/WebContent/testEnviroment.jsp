<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id = "test1" scope = "session" class = "database.subscriberDB" ></jsp:useBean>
<%@ page import = "database.subscriberDB" %>
<%@ page import = "java.sql.*" %>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Database Testing Enviroment</title>
</head>
<body>

<% 

	test1.initializaJdbc();
	
	int accountID = test1.loginCheck("rshelby@yahoo.com", "sesame");%>

	<%=accountID %>


</body>
</html>