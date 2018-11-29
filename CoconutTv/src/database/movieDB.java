package database;

import java.sql.*;
import classes.*;

public class movieDB {
	
	private static Connection con = null;
	private static PreparedStatement dbQuery;

	private static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb", "root", "sesame");
			return con;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static int getViews(int movieID) throws SQLException { // Returns views
		getConnection();
		
		int views;
		
		dbQuery = con.prepareStatement("select views from movie where movieID = ?");
		dbQuery.setInt(1, movieID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		
		views = rset.getInt(1);
		return views;
	}
	
	public static void setViews(int movieID, int views) throws SQLException {
		getConnection();
		
		dbQuery = con.prepareStatement("update movie set views = ? where movieID = ?");
		dbQuery.setInt(1, views);
		dbQuery.setInt(2, movieID);
		dbQuery.executeQuery();
	}
	
	public static double getRatingAvg(int movieID) throws SQLException {
		getConnection();
		
		double rating;
		
		dbQuery = con.prepareStatement("select ratingAvg from movie where movieID = ?");
		dbQuery.setInt(1, movieID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		
		rating = rset.getInt(1);
		
		return rating;
	}
	
	public static void setRatingAvg(int movieID, double newRatingAvg) throws SQLException {
		getConnection();
		
		dbQuery = con.prepareStatement("update movie set ratingAvg = ? where movieID = ?");
		dbQuery.setDouble(1, newRatingAvg);
		dbQuery.setInt(2, movieID);
		dbQuery.executeQuery();
	}
	
	public static int getRatingCount(int movieID) throws SQLException {
		getConnection();
		
		int ratingCount;
		
		dbQuery = con.prepareStatement("select ratingCount from movie where movieID = ?");
		dbQuery.setInt(1, movieID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		
		ratingCount = rset.getInt(1);
		
		return ratingCount;
	}
	
	public static void setRatingCount(int movieID, int count) throws SQLException {
		getConnection();
		
		dbQuery = con.prepareStatement("update movie set ratingCount = ? where movieID = ?");
		dbQuery.setInt(1, count);
		dbQuery.setInt(2, movieID);
		dbQuery.executeQuery();
	}
	
	public static int getRatingSum(int movieID) throws SQLException {
		getConnection();
		
		int ratingSum;
		
		dbQuery = con.prepareStatement("select ratingSum from movie where movieID = ?");
		dbQuery.setInt(1, movieID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		
		ratingSum = rset.getInt(1);
		
		return ratingSum;
	}
	
	public static void setRatingSum(int movieID, int newSum) throws SQLException {
		getConnection();
		
		dbQuery = con.prepareStatement("update movie set ratingCount = ? where movieID = ?");
		dbQuery.setInt(1, newSum);
		dbQuery.setInt(2, movieID);
		dbQuery.executeQuery();
	}
	
	public static void addRating(int movieID, int userRating) throws SQLException { // Adds user rating to ratingSum, increments ratingCount,
														 // then calculates ratingAvg, stores back in database
		int ratingCount, ratingSum;
		double ratingAvg;
		
		ratingCount = getRatingCount(movieID) + 1;
		ratingSum = getRatingSum(movieID) + userRating;
		ratingAvg = ratingSum / ratingCount;
		
		setRatingCount(movieID, ratingCount);
		setRatingSum(movieID, ratingSum);
		setRatingAvg(movieID, ratingAvg);
	}
	
	public static Movie getMovie(int movieID) throws SQLException {
		Movie movie = new Movie();
		getConnection();
		
		dbQuery = con.prepareStatement("select * from movie where movieID = ?");
		dbQuery.setInt(1, movieID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		
		movie.setMovieID(rset.getInt(1));
		movie.setGenre(rset.getString(2));
		movie.setTitle(rset.getString(3));
		movie.setDescription(rset.getString(4));
		movie.setMovieImage(rset.getString(5));
		movie.setMovieTrailer(rset.getString(6));
		movie.setDate(rset.getString(7));
		movie.setMPAARating(rset.getString(8));
		movie.setDirector(crewDB.getCrew(rset.getString(9))); // Gets string containing director name, then sends that to crewDB to retrieve
															// a crew type object and returns that
		movie.setActor1(rset.getString(10));
		movie.setActor2(rset.getString(11));
		movie.setViews(rset.getInt(12));
		movie.setRatingSum(rset.getInt(13));
		movie.setRatingCount(rset.getInt(14));
		movie.setRatingAvg(rset.getDouble(15));
		
		return movie;
	}
	
	public static void addMovie(Movie newMovie) throws SQLException {
		getConnection();
		
		dbQuery = con.prepareStatement("Insert into crew (movieID, movieGenre, movieTitle, movieDescription, movieImage, movieTrailer,"
				+ "movieReleaseDate, movieMPAARating, director, actor1, actor2, views, ratingSum, ratingCount, ratingAvg) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		dbQuery.setInt(1, newMovie.getMovieID());
		dbQuery.setString(2, newMovie.getGenre());
		dbQuery.setString(3, newMovie.getTitle());
		dbQuery.setString(4, newMovie.getDescription());
		dbQuery.setString(5, newMovie.getMovieImage());
		dbQuery.setString(6, newMovie.getMovieTrailer());
		dbQuery.setString(7, newMovie.getDate());
		dbQuery.setString(8, newMovie.getMPAARating());
		dbQuery.setString(9, newMovie.getDirector().getFirstName() + " " + newMovie.getDirector().getLastName());
		crewDB.addCrew(newMovie.getDirector());
		dbQuery.setString(10, newMovie.getActor1());
		dbQuery.setString(11, newMovie.getActor2());
		dbQuery.setInt(12, newMovie.getViews());
		dbQuery.setDouble(13, newMovie.getRatingSum());
		dbQuery.setDouble(14, newMovie.getRatingCount());
		dbQuery.setDouble(15, newMovie.getRatingAvg());
		
		dbQuery.executeQuery();
	}
	
	/*
	private static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb", "root", "sesame");
			return con;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	*/
}
