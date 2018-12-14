package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Movie;
import classes.Subscriber;
import classes.Users;
import database.favoritesDB;

/**
 * Servlet implementation class Favorites
 */
@WebServlet("/Favorites")
public class Favorites extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favorites() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users tempUser = (Users) session.getAttribute("selectedProfile");// get the user  
		 // getNumberOfRentals requires an int param that takes in the account ID
		Subscriber sub = (Subscriber) session.getAttribute("newSub");// gets the subscriber needed for gaining the users level
		//Says the subscriber isnt being properly initialized
		if(sub == null || sub.getAddress() == null)
		{
			response.sendRedirect("signUp.jsp");
			return;
		} 
		else if(tempUser == null || tempUser.getUsername() == null){
			response.sendRedirect("selectProfile.jsp");
			return;
		}
		Movie temp = (Movie) session.getAttribute("selectedMovie");	
		if(tempUser.getFavorites().get(2) != 0)
		{
			boolean test = false;
			int j = -1;
			for(int i =0 ; i<3; i++) {
				
			if(tempUser.getFavorites().get(i) == temp.getMovieID()) {
				j = i;
				test = true;
				}
				
			}	
			if(test == true) {
				tempUser.getFavorites().set(j, 0);
				try {
					favoritesDB.updateFavorites(tempUser);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				response.sendRedirect("selectedMovie.jsp?value=" + temp.getMovieID()); 
				return;
			}
			tempUser.addFavorite(temp.getMovieID()); //changed the addFavorite method in the user class, so that an added favorite will go into idex 0 of the list, with the other favorites shifted down as necessesary. 
			tempUser.removeFavorite(tempUser.getFavorites().get(3));//garbage collecting, should delete the fourth movie from the favorites
			try {
				favoritesDB.updateFavorites(tempUser);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			tempUser.addFavorite(temp.getMovieID());
			try {
				favoritesDB.updateFavorites(tempUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//redirect to start page
		response.sendRedirect("selectedMovie.jsp?value=" + temp.getMovieID()); 
	}

}
