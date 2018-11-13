package database;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import classes.Subscriber;

//import the package.(name of the class that is being used)

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
		
		dbQuery.setInt(1, changedSub.getCreditCardCCV());
		dbQuery.setString(2, changedSub.getCreditCardNumber());
		dbQuery.setString(3, changedSub.getFirstName());
		dbQuery.setString(4, changedSub.getLastName());
		dbQuery.setInt(5, changedSub.getExpYear());
		dbQuery.setInt(6, changedSub.getExpMonth());
		dbQuery.setString(7, changedSub.getCCType());
		dbQuery.setInt(8, changedSub.getAccountID());
		dbQuery.executeUpdate();
		
	}
	
	public void addSubscriber(Subscriber addedSub) throws SQLException {
		String subInfo = "Insert into subscriber (levelName, firstName, lastName, billAddressLine1, billAddressLine2, billCity, billState, billZipCode, phoneNumber, emailAddress, memberPassword, accountCreateDate, accountStatus) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String cardInfo = "Insert into card (accountID, creditCardCCV, creditcardNumber, cardholderfirstname, cardholderlastname, expyear,expmonth, cctype) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		dbQuery = con.prepareStatement(subInfo);
		Date today = (Date) new java.util.Date();
		
		dbQuery.setString(1, addedSub.getlevelName());
		dbQuery.setString(2, addedSub.getFirstName());
		dbQuery.setString(3, addedSub.getLastName());
		dbQuery.setString(4, addedSub.getBillAddressLine1());
		dbQuery.setString(5, addedSub.getBillAddressLine2());
		dbQuery.setString(6, addedSub.getBillCity());
		dbQuery.setString(7, addedSub.getBillState());
		dbQuery.setString(8, addedSub.getBillZipCode());
		dbQuery.setString(9, addedSub.getPhoneNumber());
		dbQuery.setString(10, addedSub.getEmailAddress());
		dbQuery.setString(11, addedSub.getMemberPassword());
		dbQuery.setDate(12, today);
		dbQuery.setString(13, addedSub.getAccountStatus());
		dbQuery.executeUpdate();

		dbQuery = con.prepareStatement("select MAX(accointID) from subscriber");
		ResultSet rset = dbQuery.executeQuery();
		rset.next();
		addedSub.setAccountID(rset.getInt(1));
		
		dbQuery = con.prepareStatement(cardInfo);
		
		dbQuery.setInt(1, addedSub.getAccountID());
		dbQuery.setInt(2, addedSub.getCreditCardCCV());
		dbQuery.setString(3, addedSub.getCreditCardNumber());
		dbQuery.setString(4, addedSub.getFirstName());
		dbQuery.setString(5, addedSub.getLastName());
		dbQuery.setInt(6, addedSub.getExpYear());
		dbQuery.setInt(7, addedSub.getExpMonth());
		dbQuery.setString(8, addedSub.getCCType());
		dbQuery.executeUpdate();	
		
	}
	
	public void deleteSubsriber(int accountID) throws SQLException {
		String deleteRow = "Delete from Subscriber where accountID = ?";
		dbQuery = con.prepareStatement(deleteRow);
		dbQuery.setInt(1, accountID);
		dbQuery.executeUpdate();
		
	}
	
	public void updateStatus(Subscriber statusChange) {
		String updateStatusStr = "Update subscriber set accountStatus = ? where accountID = ?";
		dbQuery = con.prepareStatement(updateStatusStr);
		dbQuery.setString(1,  statusChange.getAccountStatus());
		dbQuery.setInt(2,  statusChange.getAccountID());
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

