package database;

import java.sql.*;

public class QueueDB {
	// select count(*) as Rentals from queue where accountID = ?

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

}
