
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="newSub" class="classes.Subscriber" scope="session"></jsp:useBean>
<jsp:useBean id="selectedProfile" class="classes.Users" scope="session"></jsp:useBean>
<%@ page import = "database.*" %>
<%@ page import = "classes.*" %>
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
<link href="./accountSettings.css" rel="stylesheet" type="text/css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<title>Account Settings</title>
</head>
<body>
<%
if (newSub == null || newSub.getAccountID() == 0) {
	request.getRequestDispatcher("welcome.jsp").forward(request, response);
}
	selectedProfile = (Users) session.getAttribute("selectedProfile");
%>

	
	<div class="container-fluid">
		<div class="page-header">
			<h1> Account Settings<br><br></h1>
		</div>
	
		<div class="row">
 			<div class="col-sm-4">
 				
 			</div>
  			<div class="col-sm-4">
  				
  				
				<button type="button" class="upperbtn" data-toggle="modal" data-target="#updatePayment">Update Payment Info</button><br><br>
				<button type="button" class="upperbtn" data-toggle="modal" data-target="#updateAccount">Update Account Info</button><br><br>
				<button type="button" class="upperbtn" data-toggle="modal" data-target="#updatePlan">Change the Plan</button><br><br>
  				
  				
  				<!-- PAYMENT UPDATE MODAL -->
<div class="modal fade" id="updatePayment" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title" id="modalLabel">Update Payment Info</h3>
			</div>
			<div class="modal-body">				
				
				<form name="updateCardInfo" class="form-horizontal" action="SaveCCInfo" method="post" onsubmit="">
					<div class="form-group">
    				<label class="control-label col-sm-2" for="cardHolderFirstName">First Name:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_firstName" name="m_firstName" placeholder=<%=newSub.getPaymentInfo().getFirstName() %> maxlength="45" required>
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="cardHolderLastName">Last Name:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_lastName" name="m_lastName" placeholder=<%=newSub.getPaymentInfo().getLastName() %> maxlength="45" required>
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_ccNumber">Credit Card Number:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_ccNumber" name="m_ccNumber" placeholder=<%=newSub.getPaymentInfo().getCCNumber() %> maxlength="16" required>
    				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_ccType">Credit Card Type:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_ccType" name="m_ccType" placeholder=<%=newSub.getPaymentInfo().getCCType() %> maxlength="45" required>
    				</div>
  				</div>
  				<div class="form-group"> 
  				<div class="form-row">
    				<label class="control-label col-sm-2" for="m_ccExpiration">Expiration Month/Year:</label>
    				<div class="col-sm-4">
      				<input type="text" class="form-control" id="m_expMonth" name="m_expMonth" placeholder=<%=newSub.getPaymentInfo().getExpMonth() %> maxlength="2" required>
      				</div>
      				<div class="col-sm-4">
      				<input type="text" class="form-control" id="m_expYear" name="m_expYear" placeholder=<%=newSub.getPaymentInfo().getExpYear() %> maxlength="4" required>
    				</div>
  				</div>
  				</div>
  				<div class="form-group">
    				<label class="control-label col-sm-2" for="m_ccv">CCV:</label>
    				<div class="col-sm-8">
      				<input type="text" class="form-control" id="m_ccv" name="m_ccv" placeholder=<%=newSub.getPaymentInfo().getCCNumber() %> maxlength="3" required>
    				</div>
  				</div>
  				
  				<div class="form-group"> 
    				<div class="col-sm-offset-2 col-sm-8">
      				<button type="submit" value="updatePayment" class="modalbtn">Save Changes</button>
    				</div>
  				</div>				
				
				</form>				
				
			</div>
			<div class="modal-footer">
				
				<button type="button" class="modalbtn" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>  <!-- END OF PAYMENT UPDATE MODAL -->
  				
  				
 <!-- MODAL FOR ACCOUNT INFO UPDATE -->
 <div class="modal fade" id="updateAccount" role="dialog">
 <div class="modal-dialog">

 <!-- Modal content-->
 <div class="modal-content">
 	<div class="modal-header">
 		<button type="button" class="close" data-dismiss="modal">&times;</button>
 		<h3 class="modal-title">Update Account Info</h3>
 	</div>
 	<div class="modal-body">
 		<form name="updateAccountInfo" class="form-horizontal" action="UpdateAccountInfo" method="post">  			
		  			<div class="form-group">
		    				<label class="control-label col-sm-2" for="m_email">Email:</label>
		    				<div class="col-sm-8">
		      				<input type="email" class="form-control" id="m_email" name="m_email" placeholder="<%=newSub.getLoginInfo().getEmail() %>" maxlength="45" required>
		    				</div>
		  				</div>
		  				<div class="form-group">
		    				<label class="control-label col-sm-2" for="m_password">Password:</label>
		    				<div class="col-sm-8"> 
		      				<input type="password" class="form-control" id="m_password" name="m_password" placeholder="Enter password" maxlength="45" required>
		    				</div>
		  				</div>
		  				<div class="form-group">
		    				<label class="control-label col-sm-2" for="m_password1">Re-enter <br> password:</label>
		    				<div class="col-sm-8"> 
		      				<input type="password" class="form-control" id="m_password1" name="m_password1" placeholder="Re-enter password" maxlength="45" required>
		    				</div>
		  				</div>
						<div class="form-group">
		    				<label class="control-label col-sm-2" for="m_firstName">First Name:</label>
		    				<div class="col-sm-8">
		      				<input type="text" class="form-control" id="m_firstName" name="m_firstName" placeholder="<%=newSub.getFirstName() %>" maxlength="45">
		    				</div>
		  				</div>
						<div class="form-group">
		    				<label class="control-label col-sm-2" for="m_lastName">Last Name:</label>
		    				<div class="col-sm-8">
		      				<input type="text" class="form-control" id="m_lastName" name="m_lastName" placeholder="<%=newSub.getLastName() %>" maxlength="45">
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
		      				<input type="text" class="form-control" id="m_line1" name="m_line1" placeholder="<%=newSub.getAddress().getLine1() %>" maxlength="45">
		    				</div>
		  				</div>
		  				<div class="form-group">
		    				<label class="control-label col-sm-2" for="m_line2">Address line 2:</label>
		    				<div class="col-sm-8">
		      				<input type="text" class="form-control" id="m_line2" name="m_line2" placeholder= "<%if (newSub.getAddress().getLine2() != null ) {out.print(newSub.getAddress().getLine2());} else { out.print(" e.g. Apt.#, Suite #, etc.");} %>" maxlength="45">
		    				</div>
		  				</div>
		  				<div class="form-group">
		    				<label class="control-label col-sm-2" for="m_city">City:</label>
		    				<div class="col-sm-8">
		      				<input type="text" class="form-control" id="m_city" name="m_city" placeholder="<%=newSub.getAddress().getCity() %>" maxlength="45">
		    				</div>
		  				</div>
		  				<div class="form-group">
		    				<label class="control-label col-sm-2" for="m_state">State:</label>
		    				<div class="col-sm-8">
		      				<input type="text" class="form-control" id="m_state" name="m_state" placeholder="<%=newSub.getAddress().getState() %>" maxlength="2">
		    				</div>
		  				</div>
		  				<div class="form-group">
		    				<label class="control-label col-sm-2" for="m_zip">Zip Code:</label>
		    				<div class="col-sm-8">
		      				<input type="text" class="form-control" id="m_zip" name="m_zip" placeholder="<%=newSub.getAddress().getZip() %>" maxlength="5">
		    				</div>
		  				</div>
		  				<div class="form-group">
		    				<label class="control-label col-sm-2" for="m_phoneNumber">Phone Number:</label>
		    				<div class="col-sm-8">
		      				<input type="tel" class="form-control" id="m_phoneNumber" name="m_phoneNumber" placeholder="<%=newSub.getPhoneNumber() %>" maxlength="20">
		    				</div>
		  				</div>  				
<!-- 		  				<div class="form-group"> -->
<!-- 		  					<label class="control-label col-sm-2" for="genre">Favorite Genre:</label> -->
<!-- 		  					<div class="col-sm-8"> -->
<!-- 		  					<select class="form-control" id="genre" name=""> -->
<!-- 		  						<option>Choose one..</option> -->
<!-- 		    					<option value="1" id="action" name="action">Action</option> -->
<!-- 		    					<option value="2" id="comedy" name="comedy">Comedy</option> -->
<!-- 		    					<option value="3" id="drama" name="drama">Drama</option> -->
<!-- 		    					<option value="4" id="horror" name="horror">Horror</option> -->
<!-- 		    					<option value="5" id="scifi" name="scifi">Sci-Fi</option> -->
<!-- 		  					</select> -->
<!-- 		  					</div> -->
<!-- 						</div> -->
		  			
		  			
		 			<div class="form-group"> 
		    			<div class="col-sm-offset-2 col-sm-8">
		      			<button type="submit" value="updateAccount" class="modalbtn">Save Changes</button>
		   				</div>		   				
		  			</div>
				</form>
 	</div>
 <div class="modal-footer">
 <button type="button" class="modalbtn" data-dismiss="modal">Cancel</button>
 </div>
 </div>

 </div>
 </div> <!-- END OF ACCOUNT INFO MODAL-->				
  			
  				
<!-- PLAN UPDATE MODAL -->
<div class="modal fade" id="updatePlan" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title" id="modalLabel">Update Plan</h3>
			</div>
			<div class="modal-body">				
				<form name="updateSubscription" class="form-horizontal" action="UpdateSubLevel" method="post" onsubmit="" required>
					
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
      				<button type="submit" value="updateSubscription" class="modalbtn">Save Changes</button>
    				</div>
  				</div>				
				
				</form>
			</div>
			<div class="modal-footer">
				
				<button type="button" class="modalbtn" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>  <!-- END OF PLAN UPDATE MODAL  -->
  				
  							
				<a href="./profileManagement.jsp" class="upperbtn">Profile Management</a>
				<br><br><br><br><br><br>
				<br><br><br><br><br><br>	
				<br><br><br><br><br><br>			
				<a href="./verifyPassword.jsp?checkCancel=cancel" class="lowerbtn">Cancel Plan</a>  <br><br> 
				<a href="<%if((selectedProfile.getUserID() == 0) || (selectedProfile == null)) {out.print("./selecteProfile.jsp");} else { out.print("./startPage.jsp" + selectedProfile.getUserID());}%>" class="lowerbtn">Go back to Home Page</a>
				
			</div>
  			<div class="col-sm-4">
  				
  			</div>
		</div>
	</div>
	
	
<script>
// Initialize tooltip component
$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})

// Initialize popover component
$(function () {
  $('[data-toggle="popover"]').popover()
})
</script>
	
</body>
</html>