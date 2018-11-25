<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import = "database.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "classes.*"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Database Testing Enviroment</title>
</head>
<body>

<% 

	crewDB testCrewDB = new crewDB();
	Crew testCrew = testCrewDB.getCrew("Spike Lee");
	/*
	test1.initializeJdbc();
	testSub1.initializeJdbc();
	int accountID = test1.loginCheck("tstevens@yahoo.com", "sesame");
	testSub = test1.getSub(accountID);
	*/
	%>


	<%= testCrew.getCrewID() + testCrew.getFirstName() + testCrew.getLastName()%>


</body>
</html>