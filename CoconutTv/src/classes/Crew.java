package classes;

public class Crew extends Person {
	protected int m_crewID;
	private String m_firstName, m_lastName;
	
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
