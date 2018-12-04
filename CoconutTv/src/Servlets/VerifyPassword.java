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
		String s1 = (String)request.getParameter("m_verify_password");
		String s2 = (String)request.getParameter("verifyPassword");
		int n1 = Integer.parseInt(request.getParameter("accountID"));
		int n2 = Integer.parseInt(request.getParameter("userIDDel"));
		
		if(s1.equals(s2) ) {
			try {
				userDB.deleteUser(n1 , n2);
			} catch (NumberFormatException e) {
				e.printStackTrace();
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

}
