package Servlets;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.*;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		//request.getRequestDispatcher("welcome.jsp").forward(request, response);
		
		Subscriber newSub = new Subscriber();
		newSub.setAccountStatus("active");
		newSub.setCreateDate(new Date());
		newSub.setFirstName(request.getParameter("m_firstName"));
		newSub.setLastName(request.getParameter("m_lastName"));
		newSub.setPhoneNumber(request.getParameter("m_phoneNumber"));
		newSub.setLevelName(request.getParameter("m_levelName"));
		
		CreditCard newCard = new CreditCard();
		newCard.setFirstName(request.getParameter("m_cfirstName"));
		newCard.setLastName(request.getParameter("m_clastName"));
		newCard.setCCNumber(request.getParameter("m_ccNumber"));
		newCard.setCCType(request.getParameter("m_ccType"));
		newCard.setExpMonth(Integer.parseInt(request.getParameter("m_expMonth")));
		newCard.setExpYear(Integer.parseInt(request.getParameter("m_expYear")));
		newCard.setCCV(Integer.parseInt(request.getParameter("m_ccv")));
		newSub.setPaymentInfo(newCard);
		
		Address newAddress = new Address();
		newAddress.setLine1(request.getParameter("m_line1"));
		newAddress.setLine2(request.getParameter("m_line2"));
		newAddress.setCity(request.getParameter("m_city"));
		newAddress.setState(request.getParameter("m_state"));
		newAddress.setZip(request.getParameter("m_zip"));
		newSub.setAddress(newAddress);
		
		Users newUsers = new Users();
		newUsers.setUsername(request.getParameter("m_firstName"));
		newUsers.setFavoriteGenre(request.getParameter("m_favoriteGenre"));
		newUsers.setAgeRestriction("no");
		List<Users> newListUsers = new ArrayList<Users>();
		newListUsers.add(newUsers);
		newSub.setUserProfiles(newListUsers);
		
		LoginCredentials newLogin = new LoginCredentials();
		newLogin.setEmail(request.getParameter("m_email"));
		newLogin.setPassword(request.getParameter("m_password"));
		newSub.setLoginInfo(newLogin);
		
		HttpSession session = request.getSession();
		session.setAttribute("newSub", newSub);
		session.setAttribute("signUpFlag", "true");
		response.sendRedirect("SignUpConfirmation.jsp");
		
		
	}

}
