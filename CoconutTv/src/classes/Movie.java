package classes;

public class Movie {
	private int m_movieID;
	private String m_genre, m_title, m_rating, m_description, m_movieImage, m_movieTrailer;
	private Crew m_director, m_actor1, m_actor2;
	
	public int getMovieID() {
		return m_movieID;
	}
	
	public void setMovieID(int movieID) {
		m_movieID = movieID;
	}
	
	public String getGenre() {
		return m_genre;
	}
	
	public void setGenre(String genre) {
		m_genre = genre;
	}
	
	public String getTitle() {
		return m_title;
	}
	
	public void setTitle(String title) {
		m_title = title;
	}
	
	public String getRating() {
		return m_rating;
	}
	
	public void setRating(String rating) {
		m_rating = rating;
	}
	
	public String getDescription() {
		return m_description;
	}
	
	public void setDescription(String description) {
		m_description = description;
	}
	
	public String getMovieImage() {
		return m_movieImage;
	}
	
	public void setMovieImage(String movieImage) {
		m_movieImage = movieImage;
	}
	
	public String getMovieTrailer() {
		return m_movieTrailer;
	}
	
	public void setMovieTrailer(String movieTrailer) {
		m_movieTrailer = movieTrailer;
	}
	
	public Crew getDirector() {
		return m_director;
	}
	
	public void setDirector(Crew director) {
		m_director = director;
	}
	
	public Crew getActor1() {
		return m_actor1;
	}
	
	public void setActor1(Crew actor1) {
		m_actor1 = actor1;
	}
	public Crew getActor2() {
		return m_actor2;
	}
	
	public void setActor2(Crew actor2) {
		m_actor2 = actor2;
	}
}
