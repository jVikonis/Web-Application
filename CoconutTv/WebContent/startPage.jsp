
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
<link rel="icon" type="image/x-icon" href="">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link href="./startPage.css" rel="stylesheet" type="text/css">
<title>Start Page</title>
</head>
<%	
	int userNumber = Integer.parseInt(request.getParameter("value"));
	selectedProfile = newSub.getUserProfiles().get(userNumber);
	
	if(selectedProfile == null) {
		response.sendRedirect("selectProfile.jsp");
	}
%>

<%
	Movie m1 = movieDB.getMovie(selectedProfile.getFavorites().get(0));
	Movie m2 = movieDB.getMovie(selectedProfile.getFavorites().get(1));
	Movie m3 = movieDB.getMovie(selectedProfile.getFavorites().get(2));
	Movie m4 = movieDB.getMovie(selectedProfile.getRecents().get(0));
	Movie m5 = movieDB.getMovie(selectedProfile.getRecents().get(1));
	Movie m6 = movieDB.getMovie(selectedProfile.getRecents().get(2));
%>


<body>

	<div class="logo">
		<a href="./startPage.jsp"><img src="./WebImages/logo.png" alt="CoconutTvLogo" id="logo"></a>
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
		
<div class="container">	
	<div class="row">
			<div><h2>Display Your 3 Favorite Movies<br><br></h2></div>
			
 			<div class="col-sm-4 col-md-4">
    			<a href="./selectedMovie.jsp?value=<%=m1.getMovieID()%>" class="thumbnail">    				
      				<img src="./MoviePosters/<%=m1.getMovieImage()%>" alt="movieImage" id="movieImage" name="movieImage" class="hover-shadow">      				
    			</a>
  			</div>		
  			<div class="col-sm-4 col-md-4">
    			<a href="./selectedMovie.jsp?value=<%=m2.getMovieID()%>" class="thumbnail">    				
      				<img src="./MoviePosters/<%=m2.getMovieImage()%>" alt="movieImage" id="movieImage" name="movieImage" class="hover-shadow">      				
    			</a>
  			</div>	
  			<div class="col-sm-4 col-md-4">
    			<a href="./selectedMovie.jsp?value=<%=m3.getMovieID()%>" class="thumbnail" onclick=<%session.setAttribute("selectedMovie", m3);%>>    				
      				<img src="./MoviePosters/<%=m3.getMovieImage()%>" alt="movieImage" id="movieImage" name="movieImage" class="hover-shadow">      				
    			</a>
  			</div>	
  			
  		</div>
  		<div class="row">	
  			<div><h2>Display Your 3 Recently Viewed Movies<br><br></h2></div>
  			<div class="col-sm-4 col-md-4">
    			<a href="./selectedMovie.jsp?value=<%=m4.getMovieID()%>" class="thumbnail">    				
      				<img src="./MoviePosters/<%=m4.getMovieImage()%>" alt="movieImage" id="movieImage" name="movieImage" class="hover-shadow">      				
    			</a>
  			</div>		
  			<div class="col-sm-4 col-md-4">
    			<a href="./selectedMovie.jsp?value=<%=m5.getMovieID()%>" class="thumbnail">    				
      				<img src="./MoviePosters/<%=m5.getMovieImage()%>" alt="movieImage" id="movieImage" name="movieImage" class="hover-shadow">      				
    			</a>
  			</div>	
  			<div class="col-sm-4 col-md-4">
    			<a href="./selectedMovie.jsp?value=<%=m6.getMovieID()%>" class="thumbnail">    				
      				<img src="./MoviePosters/<%=m6.getMovieImage()%>" alt="movieImage" id="movieImage" name="movieImage" class="hover-shadow">      				
    			</a>
  			</div>	
	</div>
</div>	
	
	















</body>
</html>