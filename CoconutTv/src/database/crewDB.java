package database;

import java.sql.*;
import classes.*;

public class crewDB {
	
	public static Crew getCrew(String name) throws SQLException { // Requires full name, example "Spike Lee"
		Connection con = getConnection();
		PreparedStatement dbQuery;
		
		Crew crew = new Crew();
		
		String qString = "select * from crew";
		dbQuery = con.prepareStatement(qString);
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		while (rset.next()) {
			if ( (rset.getString("crewFirstName")+ " " +rset.getString("crewLastName")).equals(name) ) {
				crew.setCrewID(rset.getInt("crewID"));
				crew.setFirstName(rset.getString("crewFirstName"));
				crew.setLastName(rset.getString("crewLastName"));
			}
		}
		return crew;
	}
	
	public static void addCrew(Crew newCrew) throws SQLException {
		Connection con = getConnection();
		PreparedStatement dbQuery;
		
		String qString = "Insert into crew (crewID, crewFirstName, crewLastName) values (?, ?, ?)";
		dbQuery = con.prepareStatement(qString);
		dbQuery.setInt(1, newCrew.getCrewID());
		dbQuery.setString(2, newCrew.getFirstName());
		dbQuery.setString(3, newCrew.getLastName());
		dbQuery.executeQuery();
	}
	
	private static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb", "root", "sesame");
			return con;
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
