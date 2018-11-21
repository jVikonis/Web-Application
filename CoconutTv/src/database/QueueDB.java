package database;

import java.sql.*;
import java.util.*;

public class QueueDB {
	private Connection con = null;
	private PreparedStatement dbQuery;

	public void initializeJdbc() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb", "root", "sesame");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Connection getConnection() {
		return con;
	}

	public int getNumberofRentals(int accountID) throws SQLException {
		String count = "select count(*) as Rentals from queue where accountID = ?";
		dbQuery = con.prepareStatement(count);
		dbQuery.setInt(1, accountID);
		ResultSet rset = dbQuery.executeQuery();

		rset.next();
		return rset.getInt(1);
	}

	// Supplied two methods for checking if a movie is already checked out, one by
	// title and one by movie id.

	public boolean movieCheckedOut(String movieTitle, int accountID) throws SQLException {
		this.initializeJdbc();
		String movieCheckString = "select movietitle from queue where accountID = ?";
		dbQuery = con.prepareStatement(movieCheckString);
		dbQuery.setInt(1, accountID);
		ResultSet rset = dbQuery.executeQuery();
		List<String> movieTitles = new ArrayList<String>();
		rset.next();
		while (rset.next()) {
			movieTitles.add(rset.getString(1));
		}
		return movieTitles.contains(movieTitle);
	}

	public boolean movieCheckedOut(int movieID, int accountID) throws SQLException {
		this.initializeJdbc();
		String movieCheckString = "select movieId from queue where accountID = ?";
		dbQuery = con.prepareStatement(movieCheckString);
		dbQuery.setInt(1, accountID);
		ResultSet rset = dbQuery.executeQuery();

		List<Integer> movieTitles = new ArrayList<Integer>();

		rset.next();
		while (rset.next()) {
			movieTitles.add(rset.getInt(1));
		}
		return movieTitles.contains(movieID);
	}

	// This does not check if the rent limit is reached or if the movie is already
	// rented. This check must be done prior to
	// executing this method
	public void rentOutMovie(int movieID, String movieTitle, int accountID) throws SQLException {
		this.initializeJdbc();
		String rentMovie = "insert into queue (accountID, movieID, accountID) values (?,?,?);";
		dbQuery = con.prepareStatement(rentMovie);
		dbQuery.setInt(1, accountID);
		dbQuery.setInt(2, movieID);
		dbQuery.setString(3, movieTitle);
		dbQuery.executeUpdate();
	}

	public void returnMovie(int accountID, int movieID) throws SQLException {
		this.initializeJdbc();
		String returnMovie = "delete from queue where accountID = ? and movieID = ?";
		dbQuery = con.prepareStatement(returnMovie);
		dbQuery.setInt(1, accountID);
		dbQuery.setInt(2, movieID);
		dbQuery.executeUpdate();

	}

}
