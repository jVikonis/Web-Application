
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="selectedMovie" class="classes.Movie" scope="session"></jsp:useBean>
<jsp:useBean id="selectedProfile" class="classes.Users" scope="session"></jsp:useBean>
<jsp:useBean id="newSub" class="classes.Subscriber" scope="session"></jsp:useBean>
<%@ page import= "database.*"%>
<%@ page import = "classes.*" %>
<%@ page session="true" %>
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
	//session.setAttribute("movie", selectedMovie);
	//session.setAttribute("sub", subscriberDB.getSub(10001));
	//session.setAttribute("user", favoritesDB.getUsersObj(1));
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
          				<li><a href="./movieBrowser.jsp?genre=Action" title="Action">Action</a></li>
         				<li><a href="./movieBrowser.jsp?genre=Comedy" title="Comedy">Comedy</a></li>
          				<li><a href="./movieBrowser.jsp?genre=Drama" title="Drama">Drama</a></li>
          				<li><a href="./movieBrowser.jsp?genre=Horror" title="Horror">Horror</a></li>
         				<li><a href="./movieBrowser.jsp?genre=Sci-Fi" title="Sci-Fi">Sci-Fi</a></li>
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
      	 
     	 <li><a href=<%if (selectedProfile.getUserID() == 0) { out.print("./welcome.jsp"); } else { out.print("selecteProfile.jsp"); }%> title="Switch Profile"><span class="glyphicon glyphicon-user"></span></a></li>
     	 }
    	  <li><a href="LogOut" title="Log Out"><span class="glyphicon glyphicon-log-out"></span></a></li>
		</ul>
	</div>
</nav>
	
	
	
	
	
	
	
		<div class="row">		
			<div class="col-sm-5">  			
   				 <img src="./MoviePosters/<%=selectedMovie.getMovieImage()%>" alt= "movieimage" id="movieImage" name="movieImage">		
			</div>		
		
  			<div class="col-sm-7">
   			<div  style="max-width: 575px;"> 	
  				<h2><%=selectedMovie.getTitle() %></h2><br>
  				
    			<h5><b>Director: </b><%=selectedMovie.getDirector().getFirstName() %> <%=selectedMovie.getDirector().getLastName() %></h5> 
    			
    			<h5><b>Actors: </b><%=selectedMovie.getActor1() %> , <%= selectedMovie.getActor2() %> </h5>
    			
    			<h5><b>Description: </b> <br><br>  <%=selectedMovie.getDescription() %> </h5>
    			
    			
    			
    			
    			<br>
    			<form action="Ratings" method="post">
					<label for="input-1 xs" class="control-label">Rate this movie:</label>
					<!-- does the value filed indicate the default value? If so we can change it to selectedMovie.getRating to display the rating -->
	   				<input id="input-1 xs" name="input-1 xs" class="rating rating-loading" data-min="0" data-max="5" data-step="1" value=<%=selectedMovie.getRatingAvg() %> data-size="xs">
	   				<br> 
   					<button type="submit"  class="ratingbtn">Submit </button>&nbsp;
    				<button type="reset" class="ratingbtn">Reset</button>
   				</form>
    			
    			
    			
    			<div class="row">
    				<div class="col-sm-1">
	    				<form action="Downloads" method="post">
	    					<br><button type="submit" title="Download" class="downloadBtn"> <a href ="Downloads"></a><i class="fa fa-download"></i></button>        
	    				</form>
    				</div>
    				<div class="col-sm-1 favorites">    					
    						<a href="Favorites" action="Favorites" title="Add to Favorites" class="heartIcon"><i class="fa fa-fw fa-heart"></i></a>     					
    				</div> 
    				<div class="col-sm-1">    			
    					<a href="<%=selectedMovie.getMovieTrailer() %>" class="trailer" title="Watch a trailer here!"><span class="glyphicon glyphicon-play"></span></a> 
    				</div>
    			</div>
    				
      			
				
				
				
				
				
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