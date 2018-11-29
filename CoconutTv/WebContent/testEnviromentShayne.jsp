<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import = "database.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "classes.*"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Database Testing Enviroment</title>
</head>
<body>

	<% 
	Movie testMovie;
	for(int i = 1; i < 54; i++) {
		 testMovie = movieDB.getMovie(53);
		 %>
		 <%= testMovie.getMovieID() + " " +
				 testMovie.getGenre() + " " +
				 testMovie.getTitle() + " " +
				 testMovie.getDescription() + " " +
				 testMovie.getMovieImage() + " " +
				 testMovie.getMovieTrailer() + " " +
				 testMovie.getDate() + " " +
				 testMovie.getMPAARating() + " " +
				 testMovie.getActor1() + " " +
				 testMovie.getActor2() + " " +
				 testMovie.getViews() + " " +
				 testMovie.getRatingSum() + " " +
				 testMovie.getRatingCount()
		 %>
		 <br>
		 <%
	}
	%>


	


</body>
</html>