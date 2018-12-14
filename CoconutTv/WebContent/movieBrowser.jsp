
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
<script  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="./movieBrowser.css" rel="stylesheet" type="text/css">
<title>Movie Browser</title>
</head>



<body>
	
<nav class="navbar navbar-inverse">
  	<div class="container-fluid">   
  		<div class="navbar-header">
     		<span class="navbar-brand">GCTV</span>
    	</div>			 
		<ul class="nav navbar-nav">
     		<li class="nav navbar-nav navbar-left"><a href="<%
     		if (newSub.getUserProfiles() != null) {
				if (selectedProfile.getUsername() != null) {
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
          				<li><a href="./movieBrowser.jsp?genre=action" title="Action">Action</a></li>
         				<li><a href="./movieBrowser.jsp?genre=comedy" title="Comedy">Comedy</a></li>
          				<li><a href="./movieBrowser.jsp?genre=drama" title="Drama">Drama</a></li>
          				<li><a href="./movieBrowser.jsp?genre=horror" title="Horror">Horror</a></li>
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
      	 
     	 <li><a href="<%
     		if (newSub.getUserProfiles() != null) {
					out.print("./selectProfile.jsp");
     		}
			else {
				out.print("./welcome.jsp");
			}%>" title="Switch Profile"><span class="glyphicon glyphicon-user"></span></a></li>
    	 <li><a href="./LogOut" title="Log Out"><span class="glyphicon glyphicon-log-out"></span></a></li>
		</ul>
	</div>
</nav>
<center><span style="color:#000000;"><span style="font-size:24px;"><span style="font-family:lucida sans unicode,lucida grande,sans-serif;"><q><%=quotesDB.getQuote()[0] %></q></span></span></span></center>
<center>
<div class="row" align="center" style="width: 50%;">
	<form action="./movieBrowser.jsp" style="color: white;">
		<h3><label>Advanced Search:</label></h3>
		<div class="form-group row">
			<div class="col-xs-3">
				<label for="keyword">Keywords:</label>
				<input class="form-control" type="text" name="search" placeholder="Search..." id="keyword"style="background-color:green; color:white;">
			</div>
			<div class="col-xs-3">	
				<label for="genre">Genre:</label>
				<select class="form-control" id="genre" name="genre" style="background-color:green; color:white;">
				    <option value="">Any</option>
				    <option value="action">Action</option>
				    <option value="comedy">Comedy</option>
				    <option value="drama">Drama</option>
				    <option value="horror">Horror</option>
				    <option value="sci-fi">Sci-Fi</option>
				 </select>
			</div>
			<div class="col-xs-3">
				<label for="rating">MPAA Rating:</label>
				<select class="form-control" id="rating" name="rating" style="background-color:green; color: white;">
				    <option value="">Any</option>
				    <option value="r">R</option>
				    <option value="pg-13">PG-13</option>
				    <option value="pg">PG</option>
				 </select>
			</div>	
			<div class="col-xs-3">
				<label for="urating">Minimum User Rating</label>
				<select class="form-control" id="urating" name="urating" style="background-color:green; color: white; ">
				    <option value="">Any</option>
				    <option value="5">5</option>
				    <option value="4">4</option>
				    <option value="3">3</option>
				    <option value="2">2</option>
				    <option value="1">1</option>
				    <option value="0">0</option>
				 </select>
			</div>
		</div><br>
		<button class="searchbtn" type="submit" value="Search">Search</button>
	</form>
</div>	
</center>

<!-- 		<div class="row"> -->
<!-- 			<table align="center" width="50%"> -->
<!-- 				<tr> -->
<!-- 					<td bgcolor="green"> -->
<!-- 						<br> -->
<!-- 						<form action="./movieBrowser.jsp" style="color: white;"> -->
<!-- 							<label>Advanced Search:</label><br> -->
<!-- 							Keywords: <input type="text" name="search" placeholder="Search..." style="color: white; background-color:green;"> -->
<!-- 				  			Genre: <select name="genre" style="background-color:green"> -->
<!-- 				    			<option value="">Any</option> -->
<!-- 				    			<option value="action">Action</option> -->
<!-- 				    			<option value="comedy">Comedy</option> -->
<!-- 				    			<option value="drama">Drama</option> -->
<!-- 				    			<option value="horror">Horror</option> -->
<!-- 				    			<option value="sci-fi">Sci-Fi</option> -->
<!-- 				  			</select> -->
<!-- 				  			MPAA Rating: <select name="rating" style="background-color:green"> -->
<!-- 				    			<option value="">Any</option> -->
<!-- 				    			<option value="r">R</option> -->
<!-- 				    			<option value="pg-13">PG-13</option> -->
<!-- 				    			<option value="pg">PG</option> -->
<!-- 				  			</select> -->
<!-- 				  			Minimum User Rating: <select name="urating" style="background-color:green"> -->
<!-- 				    			<option value="">Any</option> -->
<!-- 				    			<option value="5">5</option> -->
<!-- 				    			<option value="4">4</option> -->
<!-- 				    			<option value="3">3</option> -->
<!-- 				    			<option value="2">2</option> -->
<!-- 				    			<option value="1">1</option> -->
<!-- 				    			<option value="0">0</option> -->
<!-- 				  			</select> -->
<!-- 				  			<br> -->
<!-- 				  			<input type="submit" value="Search" style="background-color:green"> -->
<!-- 						</form> -->
<!-- 						<br> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<!-- 		</div> -->
		<div class="row">
  			<div class="col-sm-4">
  			</div>
  			
  			<div class="col-sm-4">
  				
  					<%
  					String search = null, genre = null, rating = null;
  					Integer urating = null;
  					
  					if (!"".equals(request.getParameter("search"))) {
  						search = request.getParameter("search");
  					}
  					if (!"".equals(request.getParameter("genre"))) {
  						genre = request.getParameter("genre");
  					}
  					if (!"".equals(request.getParameter("rating"))) {
  						rating = request.getParameter("rating");
  					}
  					
  					if (!"".equals(request.getParameter("urating")) && request.getParameter("urating") != null) {
  						urating = Integer.parseInt(request.getParameter("urating"));
  					}
  					
  					List<Movie> movieList = movieDB.search(search, genre, rating, urating);
  					if (movieList.size()!=0) {
  						for (int i = 0; i < movieList.size(); i++) { %>
  							<table style="width: 500px; height: 200px;">
  		  					<tbody>
  		  						<tr>
  		  							<td style="width: 200px;">
  		  								<a style="color:white;" href=<% out.print("./selectedMovie.jsp?value=" + movieList.get(i).getMovieID()); %>><img src="./MoviePosters/<%=movieList.get(i).getMovieImage()%>" alt= "movieimage" id="movieImage" name="movieImage" style="width: 200px; height: 200px;"></a>
  		  							</td>
  		  							<td style="width: 400px;" bgcolor="green" valign="top"  >
  		  								<table style="color:white;" >
  		  									<tr>
  		  										<td align="center" valign="top">
  		  											<a style="color:white;" href=<% out.print("./selectedMovie.jsp?value=" + movieList.get(i).getMovieID()); %>><font size=6><%=movieList.get(i).getTitle() %><br></font></a> 
  		  										</td>
  		  									</tr>
  		  									<tr>
  		  										<td>
  		  											Rating: <%=movieList.get(i).getRatingAvg() %>/5
  		  										</td>
  		  									</tr>
  		  									<tr>
  		  										<td>
  		  											<%=movieList.get(i).getDescription() %>
  		  										</td>
  		  									</tr>
  		  									<tr>
  		  										<td >
  		  											<a href=<% out.print("./Downloads?value=" + movieList.get(i).getMovieID()); %> style="color: white">Download</a>
  		  										</td>
  		  									</tr>
  		  								</table>
  									</td>
  		  						</tr>
  		  					</tbody>
  		  				</table>
  		  				<br>
  		  				<%
  						}
  					}
  					
  					%>
  				</div>
  			
  			<div class="col-sm-4">
  			</div>
		</div>
</body>
</html>