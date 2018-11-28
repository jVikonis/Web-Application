<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link href="./welcome.css" rel="stylesheet" type="text/css">
<title>Welcome Page</title>
</head>
<body>
	<input type="hidden" name="resetSent" value="false">
	<div class="container-fluid">
		<div class="page-header">
			<h1>
				Welcome <br> to <br> Gilligan's CoconutTV!
			</h1>
		</div>

		<form class="form-horizontal" action="ResetPassword" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="m_email">Email:</label>
				<div class="col-sm-8">
					<input type="email" class="form-control" id="m_email"
						name="m_email" placeholder="Enter email" maxlength="45">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<button type="submit" value="login" class="btn btn-success">Send
						Link</button>
				</div>
			</div>
		</form>
		
		<form class="form-horizontal" action="welcome.jsp" method=post>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<button type="submit" value="login" class="btn btn-success">Return
						to Login</button>
				</div>
			</div>
		</form>
	</div>
	<% if(request.getAttribute("resetSent") == "true") {
 			//TODO: Can we change this font, color and size to match
 			out.println("Recovery Email has been sent");
 		}%>

</body>


</html>