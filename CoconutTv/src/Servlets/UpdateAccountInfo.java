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
 * Servlet implementation class UpdateAccountInfo
 */
@WebServlet("/UpdateAccountInfo")
public class UpdateAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccountInfo() {
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
		temp.getLoginInfo().setEmail(request.getParameter("m_email"));
		temp.getLoginInfo().setPassword(request.getParameter("m_password"));
		temp.setFirstName(request.getParameter("m_firstName"));
		temp.setLastName(request.getParameter("m_lastName"));
		temp.getAddress().setLine1(request.getParameter("m_line1"));
		temp.getAddress().setLine2(request.getParameter("m_line2"));
		temp.getAddress().setCity(request.getParameter("m_city"));
		temp.getAddress().setState(request.getParameter("m_state"));
		temp.getAddress().setZip(request.getParameter("m_zip"));
		temp.setPhoneNumber(request.getParameter("m_phoneNumber"));		
		try {
			subscriberDB.updateSubscriber(temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("newSub", temp);
		response.sendRedirect("accountSettings.jsp");
	}

}
