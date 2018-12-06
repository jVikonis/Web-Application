package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Subscriber;
import classes.Users;
import database.favoritesDB;
import database.userDB;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
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
		HttpSession session = request.getSession();
		String username = request.getParameter("userName");
		String favGenre = request.getParameter("genrePreference");
		String ageRest = request.getParameter("ageRestriction");
		Subscriber newSub = (Subscriber) session.getAttribute("newSub");
		Users newUser = (Users) session.getAttribute("selectedProfile");
		newUser.setUsername(username);
		newUser.setFavoriteGenre(favGenre);
		newUser.setAgeRestriction(ageRest);
		if (newUser.getUserID() != 0) {
			try {
				favoritesDB.updateFavorites(newUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				favoritesDB.addFavorite(newUser);
				for (int i = 0; i < newSub.getUserProfiles().size(); i++) {
					if(newSub.getUserProfiles().get(i) == null) {
						newSub.getUserProfiles().set(i, newUser);
						i = 8;
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			userDB.updateUser(newSub.getUserProfiles(), newSub.getAccountID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("newSub", newSub);
		response.sendRedirect("selectProfile.jsp");
		
	}

}
