package Servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.*;
import database.movieDB;

/**
 * Servlet implementation class AddMovie
 */
@WebServlet("/AddMovie")
public class AddMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movie movie = new Movie();
		int maxMovieID = 0;
		movie.setGenre(request.getParameter("movieGenre"));
		movie.setTitle(request.getParameter("movieTitle"));
		movie.setDescription(request.getParameter("movieDescription"));
		movie.setDate(request.getParameter("movieReleaseDate"));
		movie.setMovieImage(request.getParameter("movieImage"));
		movie.setMovieTrailer(request.getParameter("movieTrailer"));
		movie.setMPAARating(request.getParameter("movieMPAARating"));
		movie.setDirector(new Crew(request.getParameter("director")));
		movie.setActor1(request.getParameter("actor1"));
		movie.setActor2(request.getParameter("actor2"));
		
		try {
			PreparedStatement query = movieDB.getConnection().prepareStatement(("select MAX(movieID) from movie"));
			ResultSet rset = query.executeQuery();
			rset.next();
			maxMovieID = rset.getInt(1) + 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		movie.setMovieID(maxMovieID);
		
		try {
			movieDB.addMovie(movie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("./adminOptions.jsp");
	}

}
