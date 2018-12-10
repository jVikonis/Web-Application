
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "database.*" %>
<%@ page import = "classes.*" %>
<%@ page import = "java.util.*" %>
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
<script  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="./movieBrowser.css" rel="stylesheet" type="text/css">
<title>Movie Browser</title>
</head>



<body>
	
		<div class="logo">
			<a href="./startPage.jsp"><img src="WebImages/logo.png" alt="CoconutTvLogo" id="logo"></a>
		</div>	
	
	
<nav class="navbar navbar-inverse">
  	<div class="container-fluid">   
  		<div class="navbar-header">
     		<span class="navbar-brand">GCTV</span>
    	</div>			 
		<ul class="nav navbar-nav">
     		<li class="nav navbar-nav navbar-left"><a href="./startPage.jsp" title="Home Page"><span class="fa fa-fw fa-home"></span></a></li>
     			<li class="dropdown">
      				<a class="dropdown-toggle" data-toggle="dropdown" href="#" title="Movies">
      				  <span class="fa fa-fw fa-tv"></span>
					  <span class="fa fa-caret-down"></span>
					 </a>
					 
        			<ul class="dropdown-menu">
          				<li><a href="./movieBrowser.jsp?value=action" title="Action">Action</a></li>
         				<li><a href="./movieBrowser.jsp?value=comedy" title="Comedy">Comedy</a></li>
          				<li><a href="./movieBrowser.jsp?value=drama" title="Drama">Drama</a></li>
          				<li><a href="./movieBrowser.jsp?value=horror" title="Horror">Horror</a></li>
         				<li><a href="./movieBrowser.jsp?value=Sci-Fi" title="Sci-Fi">Sci-Fi</a></li>
        			</ul>
      			</li>
      	</ul>
      
      <ul class="nav navbar-nav navbar-right">
      	 
      	 	 <form class="navbar-form navbar-left" action="./movieBrowser.jsp" title="Search" >
				<div class="input-group">
    			<input type="text" class="form-control" placeholder="Search..." name="search" id="searchBox" >
    				<div class="input-group-btn" >
     					<button class="btn btn-default" type="submit" title="Search">
        				<span class="fa fa-fw fa-search"></span>
      					</button>
  			 		</div>
  				</div>
			 </form>
      	 
     	 <li><a href="./selectProfile.jsp" title="Switch Profile"><span class="glyphicon glyphicon-user"></span></a></li>
    	 <li><a href="./welcome.jsp" title="Log Out"><span class="glyphicon glyphicon-log-out"></span></a></li>
		</ul>
	</div>
</nav>
	


		<div class="row">
  			<div class="col-sm-4"></div>
  			
  			<div class="col-sm-4">
  				<div class="header">
  					
  					<%
  					String search = null, value = null, rating = null;
  					Integer urating = null;
  					
  					if (!"".equals(request.getParameter("search"))) {
  						search = request.getParameter("search");
  					}
  					if (!"".equals(request.getParameter("value"))) {
  						value = request.getParameter("value");
  					}
  					if (!"".equals(request.getParameter("rating"))) {
  						rating = request.getParameter("rating");
  					}
  					
  					if (!"".equals(request.getParameter("urating"))) {
  						urating = Integer.getInteger(request.getParameter("urating"));
  					}
  				
  					
  					
  					List<Movie> movieList = movieDB.search(search, value, rating, urating);
  					if (movieList.size()!=0) {
  						for (int i = 0; i < movieList.size(); i++) {
  							out.print(movieList.get(i).getMovieID() + " ");
  						}
  					}
  					
  					%>
  				</div>
  				<ul class="list-group">
  					<li class="list-group-item">Action movies <span class="badge">3</span></li>
  					<li class="list-group-item">Comedy movies <span class="badge">5</span></li> 
  					<li class="list-group-item">Drama movies <span class="badge">30</span></li> 
  					<li class="list-group-item">Horror movies <span class="badge">1</span></li>
  					<li class="list-group-item">Sci-Fi movies <span class="badge">4</span></li>
				</ul>
				<a href="./selectedMovie.jsp"> Show movie selected</a>
  			
  			</div>
		</div>
</body>
</html>