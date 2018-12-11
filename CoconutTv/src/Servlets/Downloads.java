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
		Movie temp = (Movie) session.getAttribute("movie");
		Users users = (Users) session.getAttribute("user");// get the user  
		 // getNumberOfRentals requires an int param that takes in the account ID
		Subscriber sub = (Subscriber) session.getAttribute("sub");// gets the subscriber needed for gaining the users level
		//Says the subscriber isnt being properly initialized
		if(sub == null || sub.getAddress() == null)
		{
			response.sendRedirect("signUp.jsp");
		} 
		else if(users == null || users.getUsername() == null){
			response.sendRedirect("selectProfile.jsp");
		}
		
			try {
				if(QueueDB.movieCheckedOut(temp.getTitle(), users.getAccountID())) {
					response.sendRedirect("downloadConfirmation.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		
			
		String level = sub.getLevelName();// get the subscription level
		if(level.equals("silver")) {
			
			int check;
			try {
				 check = QueueDB.getNumberofRentals(users.getAccountID()); //sets check equal to the number of rentals that the user has taken out so far
				 
				 if(check <1)
					{try {
						QueueDB.rentOutMovie(temp.getMovieID(), temp.getTitle(), sub.getAccountID());
						movieDB.setViews(temp.getMovieID(),temp.getViews()+1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						//send to a relevant page
					}
					else {System.out.print("Sorry you've reached your limit of downloads");
						response.sendRedirect("welcome.jsp");}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		else if (level.equals("gold")) {
			
			int check;
			try {
				 check = QueueDB.getNumberofRentals(users.getAccountID());
				 if(check < 2) {
						try {
							QueueDB.rentOutMovie(temp.getMovieID(), temp.getTitle(), sub.getAccountID());
							movieDB.setViews(temp.getMovieID(),temp.getViews()+1);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//send to a relevant page
						} 
						else {System.out.print("Sorry you've reached your limit of downloads");
							response.sendRedirect("welcome.jsp");}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			
		 else if(level.equals("platinum")){
			 int check;
				try {
					 check = QueueDB.getNumberofRentals(users.getAccountID());
					 if(check<3) {
							try {
								QueueDB.rentOutMovie(temp.getMovieID(), temp.getTitle(), users.getAccountID());
								movieDB.setViews(temp.getMovieID(),temp.getViews()+1);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//send to a relevant page
							}
							else {System.out.print("Sorry you've reached your limit of downloads");
								response.sendRedirect("welcome.jsp");}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
