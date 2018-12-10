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
import database.subscriberDB;

/**
 * Servlet implementation class UpdateSubLevel
 */
@WebServlet("/UpdateSubLevel")
public class UpdateSubLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSubLevel() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		Subscriber temp = new Subscriber();
		temp = (Subscriber) session.getAttribute("newSub");
		String levelName = request.getParameter("m_levelName");
		if (levelName.equals("3")) {
			temp.setLevelName("Platinum");	
		}
		else if(levelName.equals("2")) {
			temp.setLevelName("Gold");	
		}
		else {
			temp.setLevelName("Silver");
		}
			
		try {
			subscriberDB.updateLevel(temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("newSub", temp);
		response.sendRedirect("accountSettings.jsp");
	}

}
