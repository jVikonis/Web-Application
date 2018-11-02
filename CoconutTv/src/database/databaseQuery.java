package database;

import java.sql.*;

public class databaseQuery {
	private Statement pstmt;

	public databaseQuery() {
		initializeJdbc();
	}

	/** Initialize database connection */
	private void initializeJdbc() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			// Connect to the sample database
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb", "root",
					"sesame");
			// Create a Statement
			pstmt = connection.createStatement();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	
	public void printResult() {
		pstmt.
	}


public static void main(String[] args) {
	databaseQuery test = new databaseQuery();
	
}

}
