package database;

import java.sql.*;
import java.util.List;
import classes.Users;

//import the package.(name of the class that is being used)
public class userDB {
	private Connection con = null;
	private PreparedStatement dbQuery;

	public void initializaJdbc() {
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

	public void updateUser(List<Users> changedUser) throws SQLException {
		String userInfo = "update users set user1=?, user2=?, user3=?, where accountID=?";

		dbQuery = con.prepareStatement(userInfo);

		dbQuery.setString(1, changedUser.get(0).getUsername());
		dbQuery.setString(2, changedUser.get(1).getUsername());
		dbQuery.setString(3, changedUser.get(2).getUsername());
		dbQuery.setInt(4, changedUser.get(0).getAccountID());
		dbQuery.executeUpdate();
	}

	public void addUser(List<Users> addedUser) throws SQLException {
		String userInfo= "Insert into Users (user1,user2,user3) values (?), where accountID=?";
				
		dbQuery = con.prepareStatement(userInfo);
		
		dbQuery.setString(1, addedUser.get(0).getUsername());
		dbQuery.setString(2, addedUser.get(1).getUsername());
		dbQuery.setString(3, addedUser.get(2).getUsername());
		dbQuery.setInt(4, addedUser.get(0).getAccountID());
		dbQuery.executeUpdate();
		
		
	}
	
	public void deleteUser(String userColumn, int accountID) throws SQLException {
		String deleteUser = "Delete from ? where accountID = ?";
		dbQuery = con.prepareStatement(deleteUser);
		dbQuery.setString(1, userColumn);
		dbQuery.setInt(2, accountID);
		dbQuery.executeUpdate();
		
		//String deleteFavorites= "Delete from favorites where userID = ?";
		//dbQuery = con.prepareStatement(deleteFavorites);
		//dbQuery.setString(1,user );
		//dbQuery.executeUpdate();
		
	}

}
