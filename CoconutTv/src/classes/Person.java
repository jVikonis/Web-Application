package classes;

public class Person {
	protected String m_firstName, m_lastName;
	
	public String getFirstName() {
		return m_firstName;
	}
	
	public String getLastName() {
		return m_lastName;
	}
	
	public void setFirstName(String firstName) {
		m_firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		m_lastName = lastName;
	}
}
