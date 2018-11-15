package classes;

import java.util.List;

public class Users {
	private String m_username, m_favoriteGenre;
	private int m_accountID;
	private List<Integer> m_favorites;
	private List<Integer> m_recents;
	private Crew m_favoriteCrew;
	private int m_userID;
	
	
	public String getFavoriteGenre() {
		return m_favoriteGenre;
	}
	
	public void setFavoriteGenre(String genre) {
		m_favoriteGenre = genre;
	}
	
	public void setRecents(List<Integer> newList) {
		m_recents = newList;
	}
	
	public List<Integer> getRecents() {
		return m_recents;
	}
	
	public void setFavoriteCrew(Crew favorite) {
		m_favoriteCrew = favorite;
	}
	
	public Crew getFavoriteCrew() {
		return m_favoriteCrew;
	}
	
	
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
