<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link href="./adminOptions.css" rel="stylesheet" type="text/css">
<title>Admin Add Movie</title>
</head>
<body>

<div class="container-fluid">
		<div class="page-header">
			<h1> Add a Movie to Database <br><br> </h1>
		</div>
		
		<div class="row">
 			<div class="col-sm-4 col-md-4">
 				
 			</div>			
 			
  			<div class="col-sm-4 col-md-4">
 				<form name="adminAddMovie" class="form-horizontal" action="./adminOptions.jsp" method="post" onsubmit="">
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="movieGenre">Movie Genre</label>
    					<div class="col-sm-8">
     					<input type="text" class="form-control" id="movieGenre" name="movieGenre" placeholder="Movie Genre" maxlength="45">
   						</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="movieTitle">Movie Title</label>
    					<div class="col-sm-8"> 
      					<input type="text" class="form-control" id="movieTitle" name="movieTitle" placeholder="Movie Title" maxlength="45">
    					</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="movieDescription">Movie Description</label>
    					<div class="col-sm-8"> 
      					<textarea class="form-control" id="movieDescription" name="movieDescription" placeholder="Movie Description" rows="5"></textarea>
    					</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="movieYearReleased">Movie Release Year</label>
    					<div class="col-sm-8"> 
      					<input type="text" class="form-control" id="movieYearReleased" name="movieYearReleased" placeholder="e.g. 1999" maxlength="4">
    					</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="movieImage">Movie Image Filename</label>
    					<div class="col-sm-8"> 
      					<input type="text" class="form-control" id="movieImage" name="movieImage" placeholder="e.g. 21grams.jpg" maxlength="45">
    					</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="movieTrailer">Movie Trailer Link</label>
    					<div class="col-sm-8"> 
      					<input type="text" class="form-control" id="movieTrailer" name="movieTrailer" placeholder="Paste movie link here">
    					</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="movieReleaseDate">Movie Release Date</label>
    					<div class="col-sm-8"> 
      					<input type="text" class="form-control" id="movieReleaseDate" name="movieReleaseDate" placeholder="e.g. 1999-05-02" maxlength="45">
    					</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="movieMPAARating">MPAA Rating</label>
    					<div class="col-sm-8"> 
      					<input type="text" class="form-control" id="movieMPAARating" name="movieMPAARating" placeholder="e.g. R" maxlength="45">
    					</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="director">Movie Director</label>
    					<div class="col-sm-8">
     					<input type="text" class="form-control" id="director" name="director" placeholder="e.g. Jack Nicholson" maxlength="45">
   						</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="actor1">Movie Actor 1</label>
    					<div class="col-sm-8">
     					<input type="text" class="form-control" id="actor1" name="actor1" placeholder="e.g. Jack Nicholson" maxlength="45">
   						</div>
  					</div>
  					<div class="form-group">
   						<label class="control-label col-sm-2" for="actor2">Movie Actor 2</label>
    					<div class="col-sm-8">
     					<input type="text" class="form-control" id="actor2" name="actor2" placeholder="e.g. Jack Nicholson" maxlength="45">
   						</div>
  					</div>
  					
 					<div class="form-group"> 
    					<div class="col-sm-offset-2 col-sm-8">
      					<button type="submit" value="submit" class="submitbtn">Add Movie</button>
   						</div>
  					</div>
				</form>
 				
 				
 				<br><br>
 				
 				<a href="welcome.jsp" class="admin1"> Exit </a> 				
 			</div>
 			
 			
  			<div class="col-sm-4 col-md-4">
 				
 			</div>
		</div>
	
	
	
	
	</div>


</body>
</html>