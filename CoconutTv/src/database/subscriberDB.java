package database;

import java.sql.*;
import java.sql.Date;
import classes.Subscriber;

//import the package.(name of the class that is being used)
//make sure the Subscriber being passed as the parameter is one of the default values before you call this method
//Database only accepts one of three values 'silver', 'gold' or 'platinum' for level name default is silver
//Database only accepts one of three values 'active', 'canceled' or 'trial' for account status default is trial


public class subscriberDB {

	private Connection con = null;
	private PreparedStatement dbQuery;
	
	
	public void initializaJdbc() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb" , "root", "sesame");
	}
	catch (Exception ex) {
		ex.printStackTrace();
		}
	}

	public Connection getConnection() {
		return con;
	}
	
	public Subscriber getSub() throws SQLException{
		return null;
	}
	
	public void updateSubscriber(Subscriber changedSub) throws SQLException {
		String personalInfo = "update subscriber set levelName = ?, firstName = ?, lastName = ?, phoneNumber = ?, emailAddress = ?, memberPassword = ?, accountStatus = ? where accountID = ?";
		String addressInfo = "update subscriber set billAddressLine1 = ?, billAddressLine2 = ?, billCity = ?, billState = ?, billZipCode = ? where accountID = ?";
		String cardInfo = "update card set creditCardCCV = ?, creditCardNumber = ?, cardHolderFristName = ?, cardHolderLastName = ?, expYear = ?, expMonth = ?, ccType = ? where accountID = ?";
		
		dbQuery = con.prepareStatement(personalInfo);
		
		dbQuery.setString(1, changedSub.getLevelName());
		dbQuery.setString(2, changedSub.getFirstName());
		dbQuery.setString(3, changedSub.getLastName());
		dbQuery.setString(4, changedSub.getPhoneNumber());
		dbQuery.setString(5, changedSub.getLoginInfo().getEmail());
		dbQuery.setString(6, changedSub.getLoginInfo().getPassword());
		dbQuery.setString(7, changedSub.getAccountStatus());
		dbQuery.setInt(8, changedSub.getAccountID());
		dbQuery.executeUpdate();
		
		dbQuery = con.prepareStatement(addressInfo);
		
		dbQuery.setString(1, changedSub.getAddress().getLine1());
		dbQuery.setString(2, changedSub.getAddress().getLine2());
		dbQuery.setString(3, changedSub.getAddress().getCity());
		dbQuery.setString(4, changedSub.getAddress().getState());
		dbQuery.setString(5, changedSub.getAddress().getZip());
		dbQuery.setInt(6, changedSub.getAccountID());
		dbQuery.executeUpdate();
		
		dbQuery = con.prepareStatement(cardInfo);
		
		dbQuery.setInt(1, changedSub.getPaymentInfo().getCCV());
		dbQuery.setString(2, changedSub.getPaymentInfo().getCCNumber());
		dbQuery.setString(3, changedSub.getPaymentInfo().getFirstName());
		dbQuery.setString(4, changedSub.getPaymentInfo().getLastName());
		dbQuery.setInt(5, changedSub.getPaymentInfo().getExpYear());
		dbQuery.setInt(6, changedSub.getPaymentInfo().getExpMonth());
		dbQuery.setString(7, changedSub.getPaymentInfo().getCCType());
		dbQuery.setInt(8, changedSub.getAccountID());
		dbQuery.executeUpdate();
		
	}
	
	public void addSubscriber(Subscriber addedSub) throws SQLException {
		String subInfo = "Insert into subscriber (levelName, firstName, lastName, billAddressLine1, billAddressLine2, billCity, billState, billZipCode, phoneNumber, emailAddress, memberPassword, accountCreateDate, accountStatus) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String cardInfo = "Insert into card (accountID, creditCardCCV, creditcardNumber, cardholderfirstname, cardholderlastname, expyear,expmonth, cctype) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		dbQuery = con.prepareStatement(subInfo);
		Date today = (Date) new java.util.Date();
		
		dbQuery.setString(1, addedSub.getLevelName());
		dbQuery.setString(2, addedSub.getFirstName());
		dbQuery.setString(3, addedSub.getLastName());
		dbQuery.setString(4, addedSub.getAddress().getLine1());
		dbQuery.setString(5, addedSub.getAddress().getLine2());
		dbQuery.setString(6, addedSub.getAddress().getCity());
		dbQuery.setString(7, addedSub.getAddress().getState());
		dbQuery.setString(8, addedSub.getAddress().getZip());
		dbQuery.setString(9, addedSub.getPhoneNumber());
		dbQuery.setString(10, addedSub.getLoginInfo().getEmail());
		dbQuery.setString(11, addedSub.getLoginInfo().getPassword());
		dbQuery.setDate(12, today);
		dbQuery.setString(13, addedSub.getAccountStatus());
		dbQuery.executeUpdate();

		dbQuery = con.prepareStatement("select MAX(accountID) from subscriber");
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		addedSub.setAccountID(rset.getInt(1));
		
		dbQuery = con.prepareStatement(cardInfo);
		
		dbQuery.setInt(1, addedSub.getAccountID());
		dbQuery.setInt(2, addedSub.getPaymentInfo().getCCV());
		dbQuery.setString(3, addedSub.getPaymentInfo().getCCNumber());
		dbQuery.setString(4, addedSub.getPaymentInfo().getFirstName());
		dbQuery.setString(5, addedSub.getPaymentInfo().getLastName());
		dbQuery.setInt(6, addedSub.getPaymentInfo().getExpYear());
		dbQuery.setInt(7, addedSub.getPaymentInfo().getExpMonth());
		dbQuery.setString(8, addedSub.getPaymentInfo().getCCType());
		dbQuery.executeUpdate();	
		
	}
	
	public void deleteSubsriber(int accountID) throws SQLException {
		String deleteRow = "Delete from Subscriber where accountID = ?";
		dbQuery = con.prepareStatement(deleteRow);
		dbQuery.setInt(1, accountID);
		dbQuery.executeUpdate();
		
	}
	
	public void updateStatus(Subscriber statusChange) throws SQLException {
		String updateStatusStr = "Update subscriber set accountStatus = ? where accountID = ?";
		dbQuery = con.prepareStatement(updateStatusStr);
		dbQuery.setString(1,  statusChange.getAccountStatus());
		dbQuery.setInt(2,  statusChange.getAccountID());
		dbQuery.executeUpdate();
	}
	
	public void updateLevel (Subscriber levelChange) throws SQLException {
		String updateLevelStr = "Update subscriber set levelName = ? where accountID = ?";
		dbQuery = con.prepareStatement(updateLevelStr);
		dbQuery.setString(1, levelChange.getLevelName());
		dbQuery.setInt(2,  levelChange.getAccountID());
		dbQuery.executeUpdate();
	}
	
	public int loginCheck(String email, String password) throws SQLException {
		//for testing purposes only		
		String test = "Select accountID from Subscriber where emailAddress = ? and memberPassword = ?";
		dbQuery = con.prepareStatement(test);
		dbQuery.setString(1, email);
		dbQuery.setString(2, password);
		
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		int nunber = rset.getInt(1);
		return nunber;
		
		
	}
}

