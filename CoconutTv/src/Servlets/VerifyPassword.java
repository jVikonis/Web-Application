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
import database.*;
/**
 * Servlet implementation class VerifyPassword
 */
@WebServlet("/VerifyPassword")
public class VerifyPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyPassword() {
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
		//doGet(request, response);
		HttpSession session = request.getSession();
		Subscriber tempSub = (Subscriber) session.getAttribute("newSub");
		String s1 = (String)request.getParameter("m_verify_password");
		String s2 = tempSub.getLoginInfo().getPassword();
		int tempUserNum = Integer.parseInt(request.getParameter("profileNum"));
		if (!request.getParameter("checkCancel").equals("cancel")) {
			Users tempUser = tempSub.getUserProfiles().get(tempUserNum);		
			if(s1.equals(s2) ) {
				try {
					tempSub.getUserProfiles().set(tempUserNum, null);
					userDB.updateUser(tempSub.getUserProfiles(), tempSub.getAccountID());
					session.setAttribute("newSub", tempSub);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				session.setAttribute("verifyFail", "false");
				response.sendRedirect("DeleteConfirmation.jsp");
			}
			else {
				request.setAttribute("verifyFail", "true");
				request.getRequestDispatcher("verifyPassword.jsp").forward(request, response);
			}
		}
		else {
			if(s1.equals(s2) ) {
				tempSub.setAccountStatus("canceled");
				try {
					subscriberDB.updateStatus(tempSub);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("verifyFail", "false");
				response.sendRedirect("LogOut");
			}
			else {
				request.setAttribute("verifyFail", "true");
				request.getRequestDispatcher("verifyPassword.jsp").forward(request, response);
			}
		}
		
		
		
		
	}

}
