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
 * Servlet implementation class Rating
 */
@WebServlet("/Rating")
public class Rating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rating() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Movie temp = (Movie) session.getAttribute("selectedProfile");		
		int rating = Integer.parseInt( request.getParameter("input-1 xs"));
		try {
			movieDB.addRating(temp.getMovieID(), rating); // adds rating to the database
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//accountID and user rating
		try {
			temp = movieDB.getMovie(temp.getMovieID()); // updates the site with the new information
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("selectedMovie", temp);
		response.sendRedirect("selectedMovie.jsp"); 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		Movie temp = (Movie) session.getAttribute("selectedProfile");
		//int fun = valueOf(temp.getMPAARating());
		
		int rating = Integer.parseInt( request.getParameter("input-1 xs"));
		try {
			movieDB.addRating(temp.getMovieID(), rating); // adds rating to the database
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//accountID and user rating
		try {
			temp = movieDB.getMovie(temp.getMovieID()); // updates the site with the new information
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("selectedMovie", temp);
		response.sendRedirect("selectedMovie.jsp");
	}

}
