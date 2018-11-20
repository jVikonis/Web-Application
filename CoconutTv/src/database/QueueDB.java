package database;

import java.sql.*;

public class QueueDB {
	// select count(*) as Rentals from queue where accountID = ?

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
	
	public int getNumberofRentals (int accountID) throws SQLException {
		String count = "select count(*) as Rentals from queue where accountID = ?";
		dbQuery = con.prepareStatement(count);
		dbQuery.setInt(1, accountID);
		ResultSet rset = dbQuery.executeQuery();
		
		rset.next();
		return rset.getInt(1);
	}
	
	public boolean movieCheckedOut(int movieID, int accountID) throws SQLException {
		String movieCheckString = "select count (*) from "
	}

}
