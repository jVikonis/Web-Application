<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link href="./signUp.css" rel="stylesheet" type="text/css">

<title>Sign Up</title>
</head>
<body>

	<div class="container-fluid">
	<div class="header">
		<h1> Sign Up Here!<br><br></h1>
	</div>
	
	<div class="row">
  		<div class="col-sm-3"></div>
  		
  		
  		
  		<div class="col-sm-6">
  			
  			<form class="form-horizontal" action="./selectProfile.jsp" method="post">
  				<div class="row">
  					<h3> Customer Info <br></h3>
  				</div>
  			
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_email">Email:</label>
    				<div class="col-sm-8">
      				<input type="email" class="form-control" id="m_email" name="m_email" placeholder="e.g. Example@example.com">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_password">Password:</label>
    				<div class="col-sm-8"> 
      				<input type="password" class="form-control" id="m_password" name="m_password" placeholder="Enter password">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_password1">Re-enter <br> password:</label>
    				<div class="col-sm-8"> 
      				<input type="password" class="form-control" id="m_password1" name="m_password1" placeholder="Re-enter password">
    				</div>
  				</div>
				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_firstName">First Name:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_firstName" name="m_firstName" placeholder="Enter first name">
    				</div>
  				</div>
				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_lastName">Last Name:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_lastName" name="m_lastName" placeholder="Enter last name">
    				</div>
  				</div>
				
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="dateOfBirth">Date of birth:</label>
    				<div class="col-sm-8"> 
      				<input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_line1">Address line 1:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_line1" name="m_line1" placeholder="e.g. 123 Fake St.">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_line2">Address line 2:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_line2" name="m_line2" placeholder=" e.g. Apt.#, Suite #, etc.">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_city">City:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_city" name="m_city" placeholder="e.g. Chicago">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_state">State:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_state" name="m_state" placeholder="e.g. IL">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_zip">Zip Code:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_zip" name="m_zip" placeholder="e.g. 60007">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_phoneNumber">Phone Number:</label>
    				<div class="col-sm-8">
      				<input type="tel" class="form-control" id="m_phoneNumber" name="m_phoneNumber" placeholder="e.g. (555) 555-0000">
    				</div>
  				</div>  				
  				<div class="form-group">
  					<label class="control-label col-sm-2" for="genre">Favorite Genre:</label>
  					<div class="col-sm-8">
  					<select class="form-control" id="genre" name="">
  						<option>Choose one..</option>
    					<option value="1" id="action" name="action">Action</option>
    					<option value="2" id="comedy" name="comedy">Comedy</option>
    					<option value="3" id="drama" name="drama">Drama</option>
    					<option value="4" id="horror" name="horror">Horror</option>
    					<option value="5" id="scifi" name="scifi">Sci-Fi</option>
  					</select>
  					</div>
				</div>
				<div class="form-group">
  					<label class="control-label col-sm-2" for="m_levelName">Subscription Level:</label>
  					<div class="col-sm-8">
  					<select class="form-control" id="m_levelName" name="m_levelName">
  						<option>Choose one..</option>
    					<option value="1" id="Silver" name="Silver">Silver </option>
    					<option value="2" id="Gold" name="Gold">Gold </option>
    					<option value="3" id="Platinum" name="Platinum">Platinum </option>
  					</select>
  					</div>
				</div>  				
  				
  				<div class="form-group"> 
    				<div class="col-sm-offset-2 col-sm-8">
      				<div class="checkbox">
        			<label><input type="checkbox" id="ageRestriction" name="ageRestriction"> Age Restriction?</label>
      				</div>
    				</div>
  				</div>
  				
  				<div class="row">
  					<h3> Payment Info <br></h3>  					
  				</div>
  				
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="cardHolderFirstName">First Name:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_firstName" name="m_firstName" placeholder="Card holder first name">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="cardHolderLastName">Last Name:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_lastName" name="m_lastName" placeholder="Card holder last name">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_ccNumber">Credit Card Number:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_ccNumber" name="m_ccNumber" placeholder="1234 5678 9000 0000">
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_ccType">Credit Card Type:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_ccType" name="m_ccType" placeholder="e.g. Visa, Discover, MasterCard ,etc.">
    				</div>
  				</div>
  				<div class="form-group"> 
  				<div class="form-row">
    				<label class="control-label col-sm-2" for="m_ccExpiration">Expiration Month/Year:</label>
    				<div class="col-sm-4">
      				<input type="text" class="form-control" id="m_expMonth" name="m_expMonth" placeholder="e.g. 9">
      				</div>
      				<div class="col-sm-4">
      				<input type="text" class="form-control" id="m_expYear" name="m_expYear" placeholder="e.g. 2020">
    				</div>
  				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_ccv">CCV:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_ccv" name="m_ccv" placeholder="e.g. 000">
    				</div>
  				</div>
  				
  				<div class="form-group"> 
    				<div class="col-sm-offset-2 col-sm-8">
      				<button type="submit" value="signUp" class="btn btn-success">Submit</button>
    				</div>
  				</div>
			</form>
  		
  		
  		</div>
  		
  		
  		
  		
  		<div class="col-sm-3"></div>
	</div>
	
	
	
	
	</div>

</body>
</html>