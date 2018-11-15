package classes;

import java.util.List;

public class Users {
	private String m_username;
	private int m_accountID;
	private List<Integer> m_favorites;
	private int m_userID;
	
	public int getUserID() {
		return m_userID;
	}
	public void setUserID(int number) {
		m_userID = number; 
	}
	public String getUsername() {
		return m_username;
	}
	public void setUsername(String username) {
		m_username = username;
	}
	public int getAccountID() {
		return m_accountID;
	}
	public void setAccountID(int accountID) {
		m_accountID = accountID;
	}
	public List<Integer> getFavorites() {
		return m_favorites;
	}
	public void setFavorites(List<Integer> favorites) {
		m_favorites = favorites;
	}
	
	public void addFavorite(int movieID) {
		if (!m_favorites.contains(movieID)) {
			m_favorites.add(movieID);
		}
	}
	
	public void removeFavorite(int movieID) {
		if (m_favorites.contains(movieID)) {
			int index = m_favorites.indexOf(movieID);
			m_favorites.remove(index);
		}
	}
}
