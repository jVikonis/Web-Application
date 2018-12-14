 package database;

import java.sql.*;
import java.util.*;
import classes.*;
import database.favoritesDB;

//import the package.(name of the class that is being used)
public class userDB {
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

	public static void updateUser(List<Users> changedUser, int accountID) throws SQLException {
		PreparedStatement dbQuery;
		String userInfo = "update users set user1=?, user2=?, user3=? where accountID=?";

		dbQuery = con.prepareStatement(userInfo);
		int i = 0;
		for (i = 0; i < changedUser.size(); i++) {
			if(changedUser.get(i) != null)
				dbQuery.setInt((i+1), changedUser.get(i).getUserID());
			else
				dbQuery.setInt((i+1), 0);
		}
		
		
		dbQuery.setInt(4, accountID);
		dbQuery.executeUpdate();
		
		for (i = 0; i < changedUser.size(); i++) {
			favoritesDB.updateFavorites(changedUser.get(i));
		}
	}

	public static void addUser(List<Users> addedUser, int accountID) throws SQLException {
		PreparedStatement dbQuery;
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
	
	public static void deleteUser(int accountID, int userID) throws SQLException {
		PreparedStatement dbQuery;
		int userClmn = 0;
		String[] columnNames = {"user1", "user2", "user3"};
		
		dbQuery = con.prepareStatement("select user1, user2, user3 from users where accountID = ?");
		dbQuery.setInt(1, accountID);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		for (int i = 1; i <= 3; i++) {
			if (rset.getInt(i) == userID) {
				userClmn = i - 1;
			}
		}		
		String updateUser = "update users set ? = 0 where accountID = ?";
		dbQuery = con.prepareStatement(updateUser);
		String temp = columnNames[userClmn];
		dbQuery.setString(1, temp);
		dbQuery.setInt(2, accountID);
		dbQuery.executeUpdate();
		
		favoritesDB.deleteFavorite(userID);
	}
	
	public static String getUserTest(int accountID) throws SQLException{
		PreparedStatement dbQuery;
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
		PreparedStatement dbQuery;
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
