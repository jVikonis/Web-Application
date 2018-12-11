package classes;

public class Movie {
	private int m_movieID;
	private String m_genre, m_title;
	private String m_description, m_movieImage, m_movieTrailer;
	private Crew m_director;
	private String m_actor1, m_actor2, m_date, m_MPAARating;
	private int m_views, m_ratingSum, m_ratingCount, m_ratingAvg;
	
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
	
	public String getActor1() {
		return m_actor1;
	}
	
	public void setActor1(String actor1) {
		m_actor1 = actor1;
	}
	public String getActor2() {
		return m_actor2;
	}
	
	public void setActor2(String actor2) {
		m_actor2 = actor2;
	}
	public String getDate() {
		return m_date;
	}
	public void setDate(String date) {
		m_date = date;
	}
	public String getMPAARating() {
		return m_MPAARating;
	}
	public void setMPAARating(String MPAARating) {
		m_MPAARating = MPAARating;
	}
	public int getViews() {
		return m_views;
	}
	public void setViews(int views) {
		m_views = views;
	}
	public int getRatingSum() {
		return m_ratingSum;
	}
	public void setRatingSum(int ratingSum) {
		m_ratingSum = ratingSum;
	}
	public int getRatingCount() {
		return m_ratingCount;
	}
	public void setRatingCount(int ratingCount) {
		m_ratingCount = ratingCount;
	}
	public int getRatingAvg() {
		return m_ratingAvg;
	}
	public void setRatingAvg(int ratingAvg) {
		m_ratingAvg = ratingAvg;
	}
	
}
