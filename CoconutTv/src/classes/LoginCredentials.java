package classes;

public class LoginCredentials {
	private String m_email, m_password;

	public String getEmail() {
		return m_email;
	}

	public void setEmail(String email) {
		m_email = email;
	}

	public String getPassword() {
		return m_password;
	}

	public void setPassword(String password) {
		m_password = password;
	}
	
	public boolean passwordChecker(String password) {
		return m_password.equals(password);
	}
}
