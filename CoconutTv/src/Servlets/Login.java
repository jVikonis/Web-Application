package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.*;
import classes.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		doGet(request, response);
		int accountid = -1;
		try {
		accountid = subscriberDB.loginCheck(request.getParameter("m_email"), request.getParameter("m_password"));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if (accountid <= 0) {
			request.setAttribute("loginCheckFail", "true");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		else {
			Subscriber newSub = new Subscriber();
			try {
				newSub = subscriberDB.getSub(accountid);
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			if (newSub.getAccountStatus().equals("active")) {
				session.setAttribute("newSub", newSub);
				request.setAttribute("loginCheckFail", "false");
				response.sendRedirect("selectProfile.jsp");
			}
			else {
				request.setAttribute("loginCheckFail", "cancel");
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}
		}
		
		
	}

}
