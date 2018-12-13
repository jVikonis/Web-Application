package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Movie;

public class QueueDB {
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
	
	public static int getNumberofRentals(int accountID) throws SQLException {
		PreparedStatement dbQuery;
		String count = "select count(*) as Rentals from queue where accountID = ?";
		dbQuery = con.prepareStatement(count);
		dbQuery.setInt(1, accountID);
		ResultSet rset = dbQuery.executeQuery();

		rset.next();
		return rset.getInt(1);
	}

	// Supplied two methods for checking if a movie is already checked out, one by
	// title and one by movie id.

	public static boolean movieCheckedOut(String movieTitle, int accountID) throws SQLException {
		PreparedStatement dbQuery;
		String movieCheckString = "select movietitle from queue where accountID = ?";
		dbQuery = con.prepareStatement(movieCheckString);
		dbQuery.setInt(1, accountID);
		ResultSet rset = dbQuery.executeQuery();
		while (rset.next()) {
			if (rset.getString(1).equals(movieTitle)) {
				return true;
			}
		}
		return false;
	}

	public static boolean movieCheckedOut(int movieID, int accountID) throws SQLException {
		PreparedStatement dbQuery;
		String movieCheckString = "select movieId from queue where accountID = ?";
		dbQuery = con.prepareStatement(movieCheckString);
		dbQuery.setInt(1, accountID);
		ResultSet rset = dbQuery.executeQuery();

		rset.next();
		while (rset.next()) {
			if (rset.getInt(1) == movieID) {
				return true;
			}
		}
		return false;
	}

	// This does not check if the rent limit is reached or if the movie is already
	// rented. This check must be done prior to
	// executing this method
	public static void rentOutMovie(int movieID, String movieTitle, int accountID) throws SQLException {
		PreparedStatement dbQuery;
		String rentMovie = "insert into queue (accountID, movieID, movieTitle) values (?,?,?);";
		dbQuery = con.prepareStatement(rentMovie);
		dbQuery.setInt(1, accountID);
		dbQuery.setInt(2, movieID);
		dbQuery.setString(3, movieTitle);
		dbQuery.executeUpdate();
	}

	public static void returnMovie(int accountID, int movieID) throws SQLException {
		PreparedStatement dbQuery;
		String returnMovie = "delete from queue where accountID = ? and movieID = ?";
		dbQuery = con.prepareStatement(returnMovie);
		dbQuery.setInt(1, accountID);
		dbQuery.setInt(2, movieID);
		dbQuery.executeUpdate();

	}
	
	public static List<Movie> listOfMovies(int accountID) throws SQLException{
		List<Movie> tempList = new ArrayList<Movie>();
		PreparedStatement dbQuery;
		String returnMovieIDs = "select movieID from queue where accountID = ?";
		dbQuery = con.prepareStatement(returnMovieIDs);
		dbQuery.setInt(1,  accountID);
		ResultSet rset = dbQuery.executeQuery();
		while(rset.next()) {
			tempList.add(movieDB.getMovie(rset.getInt(1)));
		}
		if (tempList.isEmpty()) {
			return null;
		}
		return tempList;
	}

}
