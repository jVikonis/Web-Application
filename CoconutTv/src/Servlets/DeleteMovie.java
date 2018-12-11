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
import javax.servlet.http.HttpSession;

import database.movieDB;

/**
 * Servlet implementation class DeleteMovie
 */
@WebServlet("/DeleteMovie")
public class DeleteMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMovie() {
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
		String movieTitle = request.getParameter("movieTitle");
		try {
			PreparedStatement query = movieDB.getConnection().prepareStatement("select movieID from movie where movieTitle = ?");
			query.setString(1, movieTitle);
			ResultSet rset = query.executeQuery();
			if(rset.next()) {
				movieDB.deleteMovie(rset.getInt("movieID"));
				HttpSession session = request.getSession();
				session.setAttribute("deleteFail", "false");
				response.sendRedirect("./adminOptions.jsp");
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("deleteFail", "true");
				request.getRequestDispatcher("adminDeleteMovie.jsp").forward(request, response);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
