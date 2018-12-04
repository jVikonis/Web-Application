
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="selectedMovie" class="classes.Movie" scope="session"></jsp:useBean>
<jsp:useBean id="selectedProfile" class="classes.Users" scope="session"></jsp:useBean>
<%@ page import= "database.*"%>
<%@ page import = "classes.*" %>
<%@ page session="true" %>
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

<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-star-rating/4.0.2/css/star-rating.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-star-rating/4.0.2/js/star-rating.min.js"></script>

<link href="./selectedMovie.css" rel="stylesheet" type="text/css">
<title>Selected Movie</title>
</head>
	
<body>
<% 	selectedProfile = (Users) session.getAttribute("selectedProfile");
	int movieID = Integer.parseInt(request.getParameter("value"));
	selectedMovie = movieDB.getMovie(movieID);
	%>
	<div class="logo">
		<a href="./startPage.jsp"><img src="logo.png" alt="CoconutTvLogo" id="logo"></a>
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
          				<li><a href="./movieBrowser.jsp" title="Action">Action</a></li>
         				<li><a href="./movieBrowser.jsp" title="Comedy">Comedy</a></li>
          				<li><a href="./movieBrowser.jsp" title="Drama">Drama</a></li>
          				<li><a href="./movieBrowser.jsp" title="Horror">Horror</a></li>
         				<li><a href="./movieBrowser.jsp" title="Sci-Fi">Sci-Fi</a></li>
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
			<div class="col-sm-5">  			
   				 <img src="./MoviePosters/<%=selectedMovie.getMovieImage()%>" alt= "movieimage" id="movieImage" name="movieImage">
    				<h4>INSERT MOVIE PICTURE<br> HERE</h4>
   					<p>Optional text</p> 			
			</div>		
		
  			<div class="col-sm-7">
   			<div  style="max-width: 600px;"> 	
  				<h3><%selectedMovie.getTitle(); %>
  				</h3><br>
  				
    			<h5><b>Director:</b><% selectedMovie.getDirector(); %></h5> 
    			
    			<h5><b>Actors:</b> <% selectedMovie.getActor1(); %> , <% selectedMovie.getActor2(); %> </h5>
    			
    			<h5><b>Description: </b> <br>  <% selectedMovie.getDescription(); %> </h5>
    			
    			
    			
    			<p><a href= <% selectedMovie.getMovieTrailer(); %> >Watch a trailer here!</a> </p>
    			
    			<form action="" method="post">
				<label for="input-1 xs" class="control-label">Rate this movie:</label>
   				<input id="input-1 xs" name="input-1 xs" class="rating rating-loading" data-min="0" data-max="5" data-step="1" value="0" data-size="xs">
   				<hr>
   					<button type="submit" class="btn btn-secondary">Submit</button>&nbsp;
    				<button type="reset" class="btn btn-secondary">Reset</button>
   				</form>
    			
    			
    			<p>
    			<br><button type="submit" title="Download" class="downloadBtn"><i class="fa fa-download"></i></button>        
    			
    			<a href="selectedMovie.jsp"  title="Add to Favorites" class="heartIcon"><i class="fa fa-fw fa-heart"></i></a>      			
    			(If person is not logged in, download button will not appear)
    			</p>
    				
      			
      			
				
				
				
				
				
<script>
$(document).on('ready', function(){
    $('#input-1 xs').rating();
});
</script>
    		</div>	    			
  			</div>
		</div>

</body>
</html>



































































