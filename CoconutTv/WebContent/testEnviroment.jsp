<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id = "test1" scope = "session" class = "database.subscriberDB" ></jsp:useBean>
<jsp:useBean id = "testSub" scope = "session" class = "classes.Subscriber" ></jsp:useBean>
<jsp:useBean id = "testSub1" scope = "session" class = "database.QueueDB" ></jsp:useBean>
<%@ page import = "database.subscriberDB" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "classes.*"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Database Testing Enviroment</title>
</head>
<body>

<% 

	test1.initializeJdbc();
	testSub1.initializeJdbc();
	
	testSub = test1.getSub(10001);%>
	

	<%= testSub1.getNumberofRentals(10001)%>


</body>
</html>