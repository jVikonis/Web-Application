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
<link rel="icon" type="image/x-icon" href="WebImages/logo.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="./updateProfile.css" rel="stylesheet" type="text/css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<title>Update Profile Info</title>
</head>
<%	
	int userNumber = Integer.parseInt(request.getParameter("value"));
	selectedProfile = newSub.getUserProfiles().get(userNumber);
	if(selectedProfile == null) {
		selectedProfile = new Users();
	}
	
	session.setAttribute("selectedProfile", selectedProfile);
%>

<body>

<div class="container-fluid">
		<div class="page-header">
			<h1 class="glow"> Profile Update<br><br></h1>
		</div>
	<center><span style="color:#000000;"><span style="font-size:24px;"><span style="font-family:lucida sans unicode,lucida grande,sans-serif;"><q><%=quotesDB.getQuote()[0] %></q></span></span></span></center>
		<div class="row">
 			<div class="col-sm-4">
 				
 			</div>
  			<div class="col-sm-4">
  				<form name="updateUsername" class="form-horizontal" action="UpdateProfile" method="post" onsubmit="" >
					<div class="form-group">
    					<label class="control-label col-sm-2" for="userName">Update First Name:</label>
    					<div class="col-sm-8">
      					<input type="text" class="form-control" id="userName" name="userName" placeholder="<%if(selectedProfile.getUsername() != null){
      						out.print(selectedProfile.getUsername());
      						}
      						else {
      						out.print("Username");
      						}%>" maxlength="10">
    					</div>
  					</div>
  				
  				<div class="form-group">
  				</div>
  				<br><br>

					
					<div class="form-group">
  					<label class="control-label col-sm-2" for="genrePreference">Update Favorite Genre:</label>
  					<div class="col-sm-8">
  					<select class="form-control" id="genrePreference" name="genrePreference">
  						<option>Choose one..</option>
    					<option value="Action" id="Action" name="action">Action</option>
    					<option value="Comedy" id="Comedy" name="comedy">Comedy</option>
    					<option value="Drama" id="Dama" name="drama">Drama</option>
    					<option value="horror" id="Horror" name="horror">Horror</option>
    					<option value="Sci-Fi" id="Sci-Fi" name="scifi">Sci-Fi</option>
  					</select>
  					</div>
				</div>  
  				
  				<div class="form-group"> 
  				</div>				
  			
  				<br><br>					
					<div class="form-group">
  					<label class="control-label col-sm-2" for="ageRestriction">Age Restriction:</label>
  					<div class="col-sm-8">
  					<select class="form-control" id="ageRestriction" name="ageRestriction">
  						<option>Choose one..</option>
    					<option value="yes" id="yes" name="yes">Yes</option>
    					<option value="no" id="no" name="no">No</option>
  					</select>
  					</div>
				</div>  
  				
  				<div class="form-group"> 
    				<div class="col-sm-offset-2 col-sm-8">
      				<button type="submit" value="ageRestriction" class="btn">Save Changes</button>
    				</div>
  				</div>				
				
				</form>
  				<br><br>
								
				<a href="./profileManagement.jsp" class="btn">Back to Profile Management</a>
				<br><br><br><br><br><br><br><br>		
				<a href="./selectProfile.jsp" class="btn">Back to Select Profile</a><br><br>
				
			</div>
  			<div class="col-sm-4">
  				
  			</div>
		</div>
	</div>

</body>
</html>