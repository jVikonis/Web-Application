
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "database.*" %>
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
<link href="./welcome.css" rel="stylesheet" type="text/css">
<title>Welcome Page</title>
</head>
<body>
	
	<div class="container-fluid">
	<div class="page-header">
		<h1 class="glow"> Welcome <br> to <br> Gilligan's CoconutTV!</h1>
	</div>
	<!-- The movie quote -->
	<center><span style="color:#a9a9a9;"><span style="font-size:24px;"><span style="font-family:lucida sans unicode,lucida grande,sans-serif;"><q><%=quotesDB.getQuote()[0] %></q></span></span></span></center>
	<div class="row">
 		<div class="col-sm-4">
 		<h2>Log In / Sign Up<br><br>
 		<% if(request.getAttribute("loginCheckFail") == "true") {
 			//TODO: Can we change this font, color and size to match
 			out.println("Invalid Username or Password");
 		}else if (request.getAttribute("loginCheckFail") == "cancel") {
 			out.println("Canceled Account Please Sign Up Again");
 		}
 		%>
 		</h2>
 		
 		
 		<form class="form-horizontal" action="Login" method="post">
  			<div class="form-group">
   				<label class="control-label col-sm-2" for="m_email">Email:</label>
    			<div class="col-sm-8">
     			<input type="email" class="form-control" id="m_email" name="m_email" placeholder="Enter email" maxlength="45">
   				</div>
  			</div>
  			<div class="form-group">
   				<label class="control-label col-sm-2" for="m_password">Password:</label>
    			<div class="col-sm-8"> 
      			<input type="password" class="form-control" id="m_password" name="m_password" placeholder="Enter password" maxlength="45">
    			</div>
  			</div>
  			<div class="form-group"> 
    			<div class="col-sm-offset-2 col-sm-8">
      			<div>
        		<label><a href="getPassword.jsp">Forgot Password? </a></label><br>
        		<label>Not a Member? <a href="./signUp.jsp">Sign Up!</a></label>
      			</div>
    			</div>
  			</div>
 			<div class="form-group"> 
    			<div class="col-sm-offset-2 col-sm-8">
      			<button type="submit" value="login" class="btn btn">Log In</button>
   				</div>
   				
  			</div>
		</form> 	
 		</div>
 		
 		
 		<div class="col-sm-4">
 		<h2>Plan Options<br><br></h2>
 		<div class="list-group">
    		<a href="./signUp.jsp" class="list-group-item">
      		<h3 class="list-group-item-heading">Silver</h3>
      		<p class="list-group-item-text"> 1 movie rented out at a time</p>
      		<p class="list-group-item-text">Small promotional benefits</p>
      		<p class="list-group-item-text">Price: $3.95</p>
   			</a>
    		<a href="./signUp.jsp" class="list-group-item">
     		<h3 class="list-group-item-heading">Gold</h3>
     		<p class="list-group-item-text"> 2 movies rented out at a time</p>
      		<p class="list-group-item-text">Large promotional value</p>
      		<p class="list-group-item-text">Price: $6.95</p>
    		</a>
   			<a href="./signUp.jsp" class="list-group-item">
      		<h3 class="list-group-item-heading">Platinum</h3>
      		<p class="list-group-item-text"> 3 movies rented out at a time</p>
      		<p class="list-group-item-text">Highest promotional value</p>
      		<p class="list-group-item-text">Price: $9.95</p>
    		</a>
 		</div> 		
 		</div> 		
 		
  		
  		<div class="col-sm-4">
  			<h2>Check Out Movies<br><br></h2>
  			<div class="thumbnail">  				
  				<img src="./WebImages/logo.png" alt="Any Picture" id="welcomeImage">
  				
  				<h3>Browse Movies</h3>
  				<p>See our available movies before you sign up. </p>
  				<p><a href="./movieBrowser.jsp" class="btn btn" role="button">See Movies</a></p>
  				
  			</div>
  		</div>  		
  		
  		  		
  		
  		
	</div>
	
	
	
	<div class="navbar-default navbar-fixed-bottom">
  		<div >
  			<div class="boom">
    		<a href="./adminLogin.jsp" style="float:right">Admin<span class="glyphicon glyphicon-log-in"></span></a>
  			</div>
  		</div>
	</div>
	
	</div>	
</body>
</html>