package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.*;

public class movieDB {
	
	private static Connection con;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb", "root", "sesame");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
	}
	
	public static int getViews(int movieID) throws SQLException { // Returns views
		PreparedStatement dbQuery;
		
		int views;
		
		dbQuery = con.prepareStatement("select views from movie where movieID = ?");
		dbQuery.setInt(1, movieID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		
		views = rset.getInt(1);
		return views;
	}
	
	public static void setViews(int movieID, int views) throws SQLException {
		PreparedStatement dbQuery;
		
		dbQuery = con.prepareStatement("update movie set views = ? where movieID = ?");
		dbQuery.setInt(1, views);
		dbQuery.setInt(2, movieID);
		dbQuery.executeUpdate();
	}
	
	public static int getRatingAvg(int movieID) throws SQLException {
		PreparedStatement dbQuery;
		
		int rating;
		
		dbQuery = con.prepareStatement("select ratingAvg from movie where movieID = ?");
		dbQuery.setInt(1, movieID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		
		rating = rset.getInt(1);
		
		return rating;
	}
	
	public static void setRatingAvg(int movieID, int newRatingAvg) throws SQLException {
		PreparedStatement dbQuery;
		
		dbQuery = con.prepareStatement("update movie set ratingAvg = ? where movieID = ?");
		dbQuery.setInt(1, newRatingAvg);
		dbQuery.setInt(2, movieID);
		dbQuery.executeUpdate();
	}
	
	public static int getRatingCount(int movieID) throws SQLException {
		PreparedStatement dbQuery;
		
		int ratingCount;
		
		dbQuery = con.prepareStatement("select ratingCount from movie where movieID = ?");
		dbQuery.setInt(1, movieID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		
		ratingCount = rset.getInt(1);
		
		return ratingCount;
	}
	
	public static void setRatingCount(int movieID, int count) throws SQLException {
		PreparedStatement dbQuery;
		
		dbQuery = con.prepareStatement("update movie set ratingCount = ? where movieID = ?");
		dbQuery.setInt(1, count);
		dbQuery.setInt(2, movieID);
		dbQuery.executeUpdate();
	}
	
	public static int getRatingSum(int movieID) throws SQLException {
		PreparedStatement dbQuery;
		
		int ratingSum;
		
		dbQuery = con.prepareStatement("select ratingSum from movie where movieID = ?");
		dbQuery.setInt(1, movieID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		
		ratingSum = rset.getInt(1);
		
		return ratingSum;
	}
	
	public static void setRatingSum(int movieID, int newSum) throws SQLException {
		PreparedStatement dbQuery;
		
		dbQuery = con.prepareStatement("update movie set ratingSum = ? where movieID = ?");
		dbQuery.setInt(1, newSum);
		dbQuery.setInt(2, movieID);
		dbQuery.executeUpdate();
	}
	
	public static List<Movie> search(String keyword, String genre, String MPAARating, Integer userRating) throws SQLException {
		// Returns a list with given search parameters, checks if any are null
		StringBuilder queryString = new StringBuilder("select movieID from movie");
		PreparedStatement dbQuery;
		List<Movie> list = new ArrayList<Movie>();
		
			if ((genre != null || keyword != null || MPAARating != null || userRating != null) ) {
				queryString.append(" where ");
				if (keyword != null) {
					queryString.append("(movieTitle LIKE '%" + keyword + "%' OR movieDescription LIKE '%" + keyword + "%')");
					if (genre != null) {
						queryString.append(" AND movieGenre = '" + genre + "'");
					}
					if (MPAARating != null) {
						queryString.append(" AND movieMPAARating = '" + MPAARating + "'");
					}
					if (userRating != null) {
						queryString.append(" AND ratingAvg >= " + userRating);
					}
				}
				else if (genre != null) {
					queryString.append("movieGenre = '" + genre + "'");
					if (MPAARating != null) {
						queryString.append(" AND movieMPAARating = '" + MPAARating + "'");
					}
					if (userRating != null) {
						queryString.append(" AND ratingAvg >= " + userRating);
					}
				}
				else if (MPAARating != null) {
					queryString.append("movieMPAARating = '" + MPAARating + "'");
					if (userRating != null) {
						queryString.append(" AND ratingAvg >= " + userRating);
					}
				}
				else if (userRating != null) {
					queryString.append("ratingAvg >= " + userRating);
				}
			}
		dbQuery = con.prepareStatement(queryString.toString());
		ResultSet rset = dbQuery.executeQuery();
			
		while (rset.next()) {
			list.add(movieDB.getMovie(rset.getInt(1)));
		}
		return list;
	}
	
	public static void addRating(int movieID, int userRating) throws SQLException { // Adds user rating to ratingSum, increments ratingCount,
														 // then calculates ratingAvg, stores back in database
		int ratingCount, ratingSum;
		//double ratingAvg;
		
		ratingCount = getRatingCount(movieID) + 1;
		ratingSum = getRatingSum(movieID) + userRating;
		//ratingAvg = ratingSum / ratingCount;
		
		setRatingCount(movieID, ratingCount);
		setRatingSum(movieID, ratingSum);
		//setRatingAvg(movieID, ratingAvg);
	}
	
	public static Movie getMovie(int movieID) throws SQLException {
		Movie movie = new Movie();
		PreparedStatement dbQuery;
		
		if(movieID == 0) {
			return null;
		}
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
		movie.setRatingAvg(rset.getInt(15));
		
		return movie;
	}
	
	public static void addMovie(Movie newMovie) throws SQLException {
		//
		PreparedStatement dbQuery;
		
		dbQuery = con.prepareStatement("Insert into movie (movieID, movieGenre, movieTitle, movieDescription, movieImage, movieTrailer,"
				+ "movieReleaseDate, movieMPAARating, director, actor1, actor2, views, ratingSum, ratingCount) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
		
		dbQuery.executeUpdate();
	}
	
	public static void deleteMovie(int movieID) throws SQLException {
		PreparedStatement dbQuery = con.prepareStatement("delete from movie where movieID = ?");
		dbQuery.setInt(1, movieID);
		dbQuery.executeUpdate();
	}
	
	public static Connection getConnection() {
		return con;
	}
}
