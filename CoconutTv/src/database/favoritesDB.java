package database;

import java.sql.*;
import java.util.*;

import classes.*;

public class favoritesDB {

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

	public static void addFavorite(Users favUser) throws SQLException {
		getConnection();
		String favInfo = "Insert into favorites(userName, genrePreference, favorite1, favorite2, favorite3, ageRestriction, crewPerson, recent1, recent2, recent3) values (?,?,?,?,?,?,?,?,?,?)";
		dbQuery = con.prepareStatement(favInfo);

		dbQuery.setString(1, favUser.getUsername());
		dbQuery.setString(2, favUser.getFavoriteGenre());
		
		if (favUser.getFavorites() != null) {
			dbQuery.setInt(3, favUser.getFavorites().get(0));
			dbQuery.setInt(4, favUser.getFavorites().get(1));
			dbQuery.setInt(5, favUser.getFavorites().get(2));
		}
		else {
			dbQuery.setInt(3, 0);
			dbQuery.setInt(4, 0);
			dbQuery.setInt(5, 0);
		}
		
		dbQuery.setString(6, favUser.getAgeRestriction());
		
		if (favUser.getFavoriteCrew() != null) {
			dbQuery.setInt(7, favUser.getFavoriteCrew().getCrewID());
		}
		else {
			dbQuery.setInt(7, 0);
		}
		if (favUser.getRecents() != null) {
			dbQuery.setInt(8, favUser.getRecents().get(0));
			dbQuery.setInt(9, favUser.getRecents().get(1));
			dbQuery.setInt(10, favUser.getRecents().get(2));
		}
		else {
			dbQuery.setInt(8, 0);
			dbQuery.setInt(9, 0);
			dbQuery.setInt(10, 0);
		}
		
		dbQuery.executeUpdate();
		
		dbQuery = con.prepareStatement("select MAX(userID) from favorites");
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		// Made change to userID since that is the values we need from the database
		favUser.setUserID(rset.getInt(1));

	}

	public static void deleteFavorite(Users favDeleteFromUser) throws SQLException {
		getConnection();
		String deleteRow = "Delete from favorites where userID = ?";
		dbQuery = con.prepareStatement(deleteRow);
		dbQuery.setInt(1, favDeleteFromUser.getUserID());
		dbQuery.executeUpdate();
	}
	
	public static void deleteFavorite(int userID) throws SQLException {
		getConnection();
		String deleteRow = "Delete from favorites where userID = ?";
		dbQuery = con.prepareStatement(deleteRow);
		dbQuery.setInt(1, userID);
		dbQuery.executeUpdate();
	}

	public static void updateFavorites(Users updatedUser) throws SQLException {
		getConnection();
		String updateFav = "update favorites set userName = ?, genrePreference = ?, favorite1 = ?, favorite2 = ?, favorite3 = ?, crewPerson = ?, recent1 = ?, recent2 = ?, recent3 = ?, where userID = ?";
		dbQuery = con.prepareStatement(updateFav);

		dbQuery.setString(1, updatedUser.getUsername());
		dbQuery.setString(2, updatedUser.getFavoriteGenre());
		dbQuery.setInt(3, updatedUser.getFavorites().get(0));
		dbQuery.setInt(4, updatedUser.getFavorites().get(1));
		dbQuery.setInt(5, updatedUser.getFavorites().get(2));
		dbQuery.setString(6, updatedUser.getAgeRestriction());
		dbQuery.setInt(7, updatedUser.getFavoriteCrew().getCrewID());
		dbQuery.setInt(8, updatedUser.getRecents().get(0));
		dbQuery.setInt(9, updatedUser.getRecents().get(1));
		dbQuery.setInt(10, updatedUser.getRecents().get(2));

		dbQuery.executeUpdate();

	}
	
	public static Users getUsersObj(int userID) throws SQLException {
		getConnection();
		if (userID == 0) {
			//If there is not user created for that field
			return null;
		}
		Users temp = new Users();
		List<Integer> tempFav = new ArrayList<Integer>();
		List<Integer> tempRecent = new ArrayList<Integer>();
		temp.setFavorites(tempFav);
		temp.setRecents(tempRecent);
		Crew tempCrew = new Crew();
		String select = "select * from favorites where userID = ?";
		dbQuery = con.prepareStatement(select);
		dbQuery.setInt(1,  userID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		temp.setUsername(rset.getString("username"));
		temp.setFavoriteGenre(rset.getString("genrePreference"));
		temp.getFavorites().add(rset.getInt("favorite1"));
		temp.getFavorites().add(rset.getInt("favorite2"));
		temp.getFavorites().add(rset.getInt("favorite3"));
		temp.setAgeRestriction(rset.getString("agerestriction"));
		temp.getRecents().add(rset.getInt("recent1"));
		temp.getRecents().add(rset.getInt("recent2"));
		temp.getRecents().add(rset.getInt("recent3"));
		temp.setUserID(userID);
		
		rset = dbQuery.executeQuery("select * from crew where crewID = " + rset.getInt("crewPerson"));
		if (rset.next()) {
			tempCrew.setCrewID(rset.getInt("crewid"));
			tempCrew.setFirstName(rset.getString("crewFirstname"));
			tempCrew.setLastName(rset.getString("crewLastname"));
			temp.setFavoriteCrew(tempCrew);
		}
		else {
			temp.setFavoriteCrew(null);
		}		
		return temp;		
	}

}
