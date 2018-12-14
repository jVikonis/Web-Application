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
<link href="./adminLogin.css" rel="stylesheet" type="text/css">
<script>
function checkAdmin() {
	var booleanValue = false;
	if(documents.forms["adminlogin"]["m_email"].value == "root@gctv.edu") {
		if(documents.forms["adminlogin"]["m_password"].value == "root") {
			booleanValue = true;
		}
	}
	if(!booleanValue)
		alert("Invalid Login");
	return booleanValue;
}
</script>
<title>Administrator Login</title>
</head>

<body>


	<div class="container-fluid">
		<div class="page-header">
			<h1 class="glow"> Administrator Login <br><br> </h1>
		</div>
		<center><span style="color:#000000;"><span style="font-size:24px;"><span style="font-family:lucida sans unicode,lucida grande,sans-serif;"><q><%=quotesDB.getQuote()[0] %></q></span></span></span></center>
		<div class="row">
 			<div class="col-sm-4 col-md-4">
 				
 			</div>
 			
 			
  			<div class="col-sm-4 col-md-4">
 				<form name="adminlogin" class="form-horizontal" action="./adminOptions.jsp" method="post" onsubmit="return checkAdmin()">
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="m_email"></label>
    					<div class="col-sm-8">
     					<input type="email" class="form-control" id="m_email" name="m_email" placeholder="Admin email" maxlength="45">
   						</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="m_password"></label>
    					<div class="col-sm-8"> 
      					<input type="password" class="form-control" id="m_password" name="m_password" placeholder="Admin password" maxlength="45">
    					</div>
  					</div>
  			
 					<div class="form-group"> 
    					<div class="col-sm-offset-2 col-sm-8">
      					<button type="submit" value="submit" class="btn btn">Log In</button>
   						</div>
  					</div>
				</form>
 			</div>
 			
 			
  			<div class="col-sm-4 col-md-4">
 				
 			</div>
		</div>
	
	
	
	
	</div>
	
</body>
</html>