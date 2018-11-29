<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "database.*" %>
<%@ page import = "classes.*" %>
<%@ page session="true" %>
<jsp:useBean id="newSub" class="classes.Subscriber" scope="session"></jsp:useBean>
<jsp:useBean id="selectedProfile" class="classes.Users" scope="session"></jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link href="./selectProfile.css" rel="stylesheet" type="text/css">
<title>Select Profile</title>
</head>
<%
if(request.getSession().getAttribute("signUpFlag") == "true") {
	subscriberDB.addSubscriber(newSub);
}
%>

<%= newSub.getAccountID()%>
<%= newSub.getUserProfiles().get(0).getUserID()%>
<body>

	<div class="container">
		<div class="page-header">
			<h1> Select Your Profile<br><br></h1>
		</div>
	
		<div class="row">
 			<div class="col-sm-4 col-md-4">
 				<a href="./startPage.jsp" class="thumbnail">
 				<h1>Profile 1</h1>
 				<h3><%=newSub.getUserProfiles().get(0).getUsername() %></h3>
 				</a>
 				<a href="./profileManagement.jsp">Manage your profiles </a>
 			</div>
  			<div class="col-sm-4 col-md-4">
 				<a href="./startPage.jsp" class="thumbnail">
 				<h1>Profile 2</h1>
 				<h3>
 				</h3>
 				</a>
 				<a href="./profileManagement.jsp">Manage your profiles </a>
 			</div>
  			<div class="col-sm-4 col-md-4">
 				<a href="" class="thumbnail">
 				<h1>Profile 3</h1>
 				<h3>Empty</h3>
 				</a>
 				<a href="./profileManagement.jsp">Manage your profiles </a>
 			</div>
		</div>
	
	
	
	
	
	</div>

</body>
</html>