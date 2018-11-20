package database;
import java.sql.*;
import classes.*;

import java.sql.Date;
import java.util.*;

import classes.Movie;
public class favoritesDB {

	private Connection con = null;
	private PreparedStatement dbQuery;
	
	
	public void initializaJdbc() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb" , "scott", "tiger");
	}
	catch (Exception ex) {
		ex.printStackTrace();
		}
	}

	public void addFavorite(Users favUser)  throws SQLException                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       {
		String favInfo = "Insert into favorites(userName, genrePreference, favorite1, favorite2, favorite3, crewPerson, recent1, recent2, recent3) values (?,?,?,?,?,?,?,?,?)"; 
	          dbQuery = con.prepareStatement(favInfo);

		dbQuery.setString(1, favUser.getUsername());
		dbQuery.setString(2, favUser.getFavoriteGenre());
		dbQuery.setInt(3, favUser.getFavorites().get(0));
		dbQuery.setInt(4, favUser.getFavorites().get(1)); 
		dbQuery.setInt(5, favUser.getFavorites().get(2));
		dbQuery.setString(6, favUser.getAgeRestriction());
		dbQuery.setInt(7, favUser.getFavoriteCrew().getCrewID());
		dbQuery.setInt(8, favUser.getRecents().get(0));
		dbQuery.setInt(9, favUser.getRecents().get(1));
		dbQuery.setInt(10, favUser.getRecents().get(2));
		
		dbQuery = con.prepareStatement("select MAX(userID) from favorites");
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		favUser.setAccountID(rset.getInt(1));
		
	}
	public void deleteFavorite(Users favDeleteFromUser) throws SQLException
	{
		String deleteRow = "Delete from favorites where userID = ?";
		dbQuery = con.prepareStatement(deleteRow);
		dbQuery.setInt(1, favDeleteFromUser.getUserID());
		dbQuery.executeUpdate();
	}
	public void updateFavorites(Users updatedUser) throws SQLException
	{
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
	public Connection getConnection() {
		return con;
	}
	
}
