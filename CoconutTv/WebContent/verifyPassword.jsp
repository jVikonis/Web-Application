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
<link href="./profileManagement.css" rel="stylesheet" type="text/css">
<title>Verify Password</title>
</head>
<!-- Delete this line of code -->
<%newSub = subscriberDB.getSub(10001);
selectedProfile = newSub.getUserProfiles().get(0);%>
<body>
	<div class="header">
	<div class="row">
 		<div class="col-sm-4">
 		<h3><center>Enter Password</center><br><br>
 		<% if(request.getAttribute("verifyFail") == "true") {
 			//TODO: Can we change this font, color and size to match
 			out.println("<center>Invalid Username or Password</center>");
 		}%>
 		</h3>
 		</div>
 		</div>
 		
	<form class="form-horizontal" action="VerifyPassword" method="post">
	<input type = "hidden" name = "verifyPassword" id = "verifyPassword" value="<%=newSub.getLoginInfo().getPassword()%>">
	<input type = "hidden" name = "userIDDel" id = "userIDDel" value = "<%=selectedProfile.getUserID()%>">
	<input type = "hidden" name = "accountID" id = "accountID" value = "<%=newSub.getAccountID()%>">
		<div class="form-group">
   				<label class="control-label col-sm-2" for="m_password">Password:</label>
    			<div class="col-sm-8"> 
      			<input type="password" class="form-control" id="m_verify_password" name="m_verify_password" placeholder="Verify Password" maxlength="45">
    			</div>
  			</div>
  			</form>
	</div>



</body>
</html>