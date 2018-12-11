
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "database.*" %>
<%@ page import = "classes.*" %>
<%@ page import = "java.util.*" %>
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
<link href="./advancedSearch.css" rel="stylesheet" type="text/css">
<title>Advanced Search</title>
</head>

<body>

	<div class="logo">
	<img src="./WebImages/logo.png" alt="CoconutTvLogo" id="logo"></a>
	</div>	
	
	
<nav class="navbar navbar-inverse">
  	<div class="container-fluid">   
  		<div class="navbar-header">
     		<span class="navbar-brand">GCTV</span>
    	</div>			 
		<ul class="nav navbar-nav">
     		<li class="nav navbar-nav navbar-left"><a href="<%
     		if (newSub != null) {
				if (selectedProfile != null) {
				out.print("./startPage.jsp?value=" + selectedProfile.getUserID());
				}
				else {
					out.print("./selectProfile.jsp");
				}
     		}
			else {
				out.print("./welcome.jsp");
			}%>" title="Home Page"><span class="fa fa-fw fa-home"></span></a></li>
     			<li class="dropdown">
      				<a class="dropdown-toggle" data-toggle="dropdown" href="#" title="Movies">
      				  <span class="fa fa-fw fa-tv"></span>
					  <span class="fa fa-caret-down"></span>
					 </a>
					 
        			<ul class="dropdown-menu">
          				<li><a href="./movieBrowser.jsp?value=Action" title="Action">Action</a></li>
         				<li><a href="./movieBrowser.jsp?value=Comedy" title="Comedy">Comedy</a></li>
          				<li><a href="./movieBrowser.jsp?value=Drama" title="Drama">Drama</a></li>
          				<li><a href="./movieBrowser.jsp?value=Horror" title="Horror">Horror</a></li>
         				<li><a href="./movieBrowser.jsp?value=Sci-Fi" title="Sci-Fi">Sci-Fi</a></li>
        			</ul>
      			</li>
      	</ul>
      
      <ul class="nav navbar-nav navbar-right">
      	 
      	 	 <form class="navbar-form navbar-left" action="./movieBrowser.jsp" title="Search" >
				<div class="input-group">
    			<input type="text" class="form-control" placeholder="Search..." name="blahblah" id="searchBox" >
    				<div class="input-group-btn" >
     					<button class="btn btn-default" type="submit" title="Search">
        				<span class="fa fa-fw fa-search"></span>
      					</button>
  			 		</div>
  				</div>
			 </form>
      	 
     	 <li><a href="./selectProfile.jsp" title="Switch Profile"><span class="glyphicon glyphicon-user"></span></a></li>
    	 <li><a href="LogOut" title="Log Out"><span class="glyphicon glyphicon-log-out"></span></a></li>
		</ul>
	</div>
</nav>
		
<div class="container">	
	<div class="row">
		<form action="./movieBrowser.jsp">
			Keywords: <input type="text" name="search" value="">
  			Genre: <select name="value">
    			<option value="">Any</option>
    			<option value="action">Action</option>
    			<option value="comedy">Comedy</option>
    			<option value="drama">Drama</option>
    			<option value="horror">Horror</option>
    			<option value="sci-fi">Sci-Fi</option>
  			</select>
  			MPAA Rating: <select name="rating">
    			<option value="">Any</option>
    			<option value="r">R</option>
    			<option value="pg-13">PG-13</option>
    			<option value="pg">PG</option>
  			</select>
  			User Rating: <select name="urating">
    			<option value="">Any</option>
    			<option value="5">5</option>
    			<option value="4">4</option>
    			<option value="3">3</option>
    			<option value="1">2</option>
    			<option value="1">1</option>
    			<option value="0">0</option>
  			</select>
  			<br>
  			<input type="submit" value="Search">
		</form>
  	</div>
  	<div class="row">	
	</div>
</div>	
</body>
</html>