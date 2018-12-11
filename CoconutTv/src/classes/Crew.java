package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.movieDB;

public class Crew extends Person {
	protected int m_crewID;
	private String m_firstName, m_lastName;
	
	public Crew () {
		
	}
	
	public Crew(String fullName) {
		String[] part = fullName.split(" ");
		m_firstName = part[0];
		if (part.length > 1) {
		m_lastName = part[1];
		}
		PreparedStatement query = null;
		try {
			query = movieDB.getConnection().prepareStatement("select MAX(crewID) from crew");
			ResultSet rset = query.executeQuery();
			if(rset.next()) {
				m_crewID = rset.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public int getCrewID() {
		return m_crewID;
	}
	
	public void setCrewID(int crewID) {
		m_crewID = crewID;
	}
	
	public String getFirstName() {
		return m_firstName;
	}
	
	public void setFirstName(String firstName) {
		m_firstName = firstName;
	}
	
	public String getLastName() {
		return m_lastName;
	}
	
	public void setLastName(String lastName) {
		m_lastName = lastName;
	}
}
