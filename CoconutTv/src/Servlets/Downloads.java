package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database.QueueDB;
import database.favoritesDB;
import database.movieDB;
import classes.Movie;
import classes.Subscriber;
import classes.Users;

/**
 * Servlet implementation class Downloads
 */
@WebServlet("/Downloads")
public class Downloads extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Downloads() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("selectedProfile");// get the user  
		 // getNumberOfRentals requires an int param that takes in the account ID
		Subscriber sub = (Subscriber) session.getAttribute("newSub");// gets the subscriber needed for gaining the users level
		//Says the subscriber isnt being properly initialized
		if(sub == null || sub.getAddress() == null)
		{
			response.sendRedirect("signUp.jsp");
			return;
		} 
		else if(users == null || users.getUsername() == null){
			response.sendRedirect("selectProfile.jsp");
			return;
		}
		Movie temp = (Movie) session.getAttribute("selectedMovie");
		int movieNum = 0;
		try {
			movieNum = Integer.parseInt(request.getParameter("value"));
			
		}catch (NumberFormatException e2) {
			e2.printStackTrace();
		}
		try {
		if (temp.getMovieID() != movieNum) {
				temp = movieDB.getMovie(movieNum);
				session.setAttribute("selectedMovie", temp);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
			try {
				if(QueueDB.movieCheckedOut(temp.getTitle(), sub.getAccountID())) {
					response.sendRedirect("DownloadConfirmation.jsp");
					session.setAttribute("DownloadStatus", "current");
					return;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		
			
		String level = sub.getLevelName();// get the subscription level
		int check = 0;
		try {
			check = QueueDB.getNumberofRentals(sub.getAccountID());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(level.equals("silver") || level.equals("Silver")) {
			
			if(check <1)
				{try {
					QueueDB.rentOutMovie(temp.getMovieID(), temp.getTitle(), sub.getAccountID());
					movieDB.setViews(temp.getMovieID(),temp.getViews()+1);
					users.addRecents(temp.getMovieID());
					users.removeRecents(users.getRecents().get(3));
					favoritesDB.updateFavorites(users);
					session.setAttribute("DownloadStatus", "complete");
					response.sendRedirect("DownloadConfirmation.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					//send to a relevant page
				}
				else {System.out.print("Sorry you've reached your limit of downloads");
				//route to the correct
					session.setAttribute("DownloadStatus", "fail");
					response.sendRedirect("CantDownload.jsp");
					}
			
			
			/* if(check <1)
			{try {
				QueueDB.rentOutMovie(temp.getMovieID(), temp.getTitle(), users.getAccountID());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			else {System.out.print("Sorry you've reached your limit of downloads");
				response.sendRedirect("welcome.jsp");} */
			
		}
		else if (level.equals("gold") || level.equals("Gold")) {
			if(check < 2) {
					try {
						QueueDB.rentOutMovie(temp.getMovieID(), temp.getTitle(), sub.getAccountID());
						movieDB.setViews(temp.getMovieID(),temp.getViews()+1);
						users.addRecents(temp.getMovieID());
						users.removeRecents(users.getRecents().get(3));
						favoritesDB.updateFavorites(users);
						session.setAttribute("DownloadStatus", "complete");
						response.sendRedirect("DownloadConfirmation.jsp");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//send to a relevant page
					} 
					else {System.out.print("Sorry you've reached your limit of downloads");
						session.setAttribute("DownloadStatus", "fail");
						response.sendRedirect("CantDownload.jsp");
						}
			
		/*	if(check < 2) {
				try {
					QueueDB.rentOutMovie(temp.getMovieID(), temp.getTitle(), users.getAccountID());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}} 
				else {System.out.print("Sorry you've reached your limit of downloads");
					response.sendRedirect("welcome.jsp");} */
			}
			
		 else if(level.equals("platinum") || level.equals("Platinum")){
				if(check<3) {
						try {
							QueueDB.rentOutMovie(temp.getMovieID(), temp.getTitle(), sub.getAccountID());
							movieDB.setViews(temp.getMovieID(),temp.getViews()+1);
							users.addRecents(temp.getMovieID());
							users.removeRecents(users.getRecents().get(3));
							favoritesDB.updateFavorites(users);
							session.setAttribute("DownloadStatus", "complete");
							response.sendRedirect("DownloadConfirmation.jsp");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//send to a relevant page
						}
						else {System.out.print("Sorry you've reached your limit of downloads");
							session.setAttribute("DownloadStatus", "fail");
							response.sendRedirect("CantDownload.jsp");
							}
			 
		/*	if(check<3) {
				try {
					QueueDB.rentOutMovie(temp.getMovieID(), temp.getTitle(), users.getAccountID());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
				else {System.out.print("Sorry you've reached your limit of downloads");
					response.sendRedirect("welcome.jsp");} */
			}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
