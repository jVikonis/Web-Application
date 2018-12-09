package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.*;
import database.subscriberDB;

/**
 * Servlet implementation class SaveCCInfo
 */
@WebServlet("/SaveCCInfo")
public class SaveCCInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCCInfo() {
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
		
		temp.getPaymentInfo().setFirstName(request.getParameter("m_firstName"));
		temp.getPaymentInfo().setLastName("m_lastName");
		temp.getPaymentInfo().setCCNumber(request.getParameter("m_ccType"));
		temp.getPaymentInfo().setExpMonth(Integer.parseInt(request.getParameter("m_expMonth")));
		temp.getPaymentInfo().setExpYear(Integer.parseInt(request.getParameter("m_expYear")));
		temp.getPaymentInfo().setCCV(Integer.parseInt(request.getParameter("m_ccv")));
		
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
