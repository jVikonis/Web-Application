<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id = "test1" scope = "session" class = "database.subscriberDB" ></jsp:useBean>
<jsp:useBean id = "testSub" scope = "session" class = "classes.Subscriber" ></jsp:useBean>
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

	test1.initializaJdbc();
	
	testSub = test1.getSub(10001);%>

	<%=testSub.getLevelName()%>


</body>
</html>