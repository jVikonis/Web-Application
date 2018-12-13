package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.movieDB;
import classes.*;
/**
 * Servlet implementation class Ratings
 */
@WebServlet("/Ratings")
public class Ratings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ratings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Movie temp = (Movie) session.getAttribute("selectedMovie");		
		int rating = Integer.parseInt( request.getParameter("input-1 xs"));
		try {
			movieDB.addRating(temp.getMovieID(), rating); // adds rating to the database
		} catch (SQLException e) {
			e.printStackTrace();
		}//accountID and user rating
		try {
			temp = movieDB.getMovie(temp.getMovieID()); // updates the site with the new information
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("selectedMovie", temp);
		response.sendRedirect("welcome.jsp"); 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		Movie temp = (Movie) session.getAttribute("selectedMovie");		
		int rating = Integer.parseInt( request.getParameter("input-1 xs"));
		try {
			movieDB.addRating(temp.getMovieID(), rating); // adds rating to the database
		} catch (SQLException e) {
			e.printStackTrace();
		}//accountID and user rating
		try {
			temp = movieDB.getMovie(temp.getMovieID()); // updates the site with the new information
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("selectedMovie", temp);
		response.sendRedirect("selectedMovie.jsp?value=" + temp.getMovieID());
	}

}
