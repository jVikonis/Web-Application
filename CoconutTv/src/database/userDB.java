 package database;

import java.sql.*;
import java.util.*;
import classes.*;
import database.favoritesDB;

//import the package.(name of the class that is being used)
public class userDB {
	private static Connection con = null;
	private static PreparedStatement dbQuery;

	private static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb", "root", "sesame");
			return con;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static void updateUser(List<Users> changedUser, int accountID) throws SQLException {
		getConnection();
		String userInfo = "update users set user1=?, user2=?, user3=?, where accountID=?";

		dbQuery = con.prepareStatement(userInfo);

		dbQuery.setString(1, changedUser.get(0).getUsername());
		dbQuery.setString(2, changedUser.get(1).getUsername());
		dbQuery.setString(3, changedUser.get(2).getUsername());
		dbQuery.setInt(4, accountID);
		dbQuery.executeUpdate();
		
		for (int i = 0; i < changedUser.size(); i++) {
			favoritesDB.updateFavorites(changedUser.get(i));
		}
	}

	public static void addUser(List<Users> addedUser, int accountID) throws SQLException {
		getConnection();
		//Removed the where clause because this method is used when we are creating a new record in the DB
		String userInfo= "Insert into Users (user1,user2,user3,accountID) values (?,?,?,?)";
		dbQuery = con.prepareStatement(userInfo);
		int[] user = new int[]{0, 0, 0};
		for (int i = 0; i < addedUser.size(); i++) {
			user[i] = addedUser.get(i).getUserID();
		}		
		dbQuery.setInt(1, user[0]);
		dbQuery.setInt(2, user[1]);
		dbQuery.setInt(3, user[2]);
		dbQuery.setInt(4, accountID);
		dbQuery.executeUpdate();	
	}
	
	public static void deleteUser(String userColumn, int accountID) throws SQLException {
		getConnection();
		ResultSet rset = dbQuery.executeQuery("select " + userColumn + " from users where accountID = " + accountID);
		String updateUser = "update users set ? = 0 where accountID = ?";
		dbQuery = con.prepareStatement(updateUser);
		dbQuery.setString(1, userColumn);
		dbQuery.setInt(2, accountID);
		dbQuery.executeUpdate();
		
		if(rset.next())
			favoritesDB.deleteFavorite(rset.getInt("userid"));
	}
	
	public static String getUserTest(int accountID) throws SQLException{
		getConnection();
		String select= "Select * from users where accountID=?";
		dbQuery=con.prepareStatement(select);
		dbQuery.setInt(1, accountID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		String name = rset.getString(2);
		return name;
	}
	
	//Changing the database to store the userID's instead of the usernames to make searching for them much easier
	public static List<Users> getUserList(int accountID) throws SQLException {
		getConnection();
		List<Users> userList = new ArrayList<Users>();
		String select = "select * from users where accountID = ?";
		dbQuery = con.prepareStatement(select);
		dbQuery.setInt(1,  accountID);
		ResultSet rset = dbQuery.executeQuery();
		//Each user in the table will hold the userID and not the username
		String[] userNum = new String[]{"user1", "user2", "user3"};
		if (rset.next()) {
			for(int i = 0; i < 3; i++) {
				userList.add(favoritesDB.getUsersObj(rset.getInt(userNum[i])));
			}
		
		
		}
		return userList;
	}

}
