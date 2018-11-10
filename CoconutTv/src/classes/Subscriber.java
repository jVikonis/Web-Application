package classes;

import java.util.Date;
import java.util.List;

public class Subscriber extends Person{
	private int m_accountID;
	private String m_phoneNumber, m_accountStatus, m_levelName;
	private Date m_createDate;
	private Address m_address;
	private List<Users> m_userProfiles;
	private LoginCredentials m_loginInfo;
	private CreditCard m_paymentInfo;
	
	public int getAccountID() {
		return m_accountID;
	}
	public void setAccountID(int accountID) {
		m_accountID = accountID;
	}
	public String getPhoneNumber() {
		return m_phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		m_phoneNumber = phoneNumber;
	}
	public String getAccountStatus() {
		return m_accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		m_accountStatus = accountStatus;
	}
	public String getLevelName() {
		return m_levelName;
	}
	public void setLevelName(String levelName) {
		m_levelName = levelName;
	}
	public Date getCreateDate() {
		return m_createDate;
	}
	public void setCreateDate(Date createDate) {
		m_createDate = createDate;
	}
	public Address getAddress() {
		return m_address;
	}
	public void setAddress(Address address) {
		m_address = address;
	}
	public List<Users> getUserProfiles() {
		return m_userProfiles;
	}
	public void setUserProfiles(List<Users> userProfiles) {
		m_userProfiles = userProfiles;
	}
	public LoginCredentials getLoginInfo() {
		return m_loginInfo;
	}
	public void setLoginInfo(LoginCredentials loginInfo) {
		m_loginInfo = loginInfo;
	}
	public CreditCard getPaymentInfo() {
		return m_paymentInfo;
	}
	public void setPaymentInfo(CreditCard paymentInfo) {
		m_paymentInfo = paymentInfo;
	}
}
