package classes;

public class CreditCard extends Person {
	private int m_cardID, m_ccv, m_expYear, m_expMonth;
	private String m_ccNumber, m_ccType;
	
	public int getCardID() {
		return m_cardID;
	}
	
	public void setCardID(int cardID) {
		m_cardID = cardID;
	}
	
	public int getCCV() {
		return m_ccv;
	}
	
	public void setCCV(int ccv) {
		m_ccv = ccv;
	}
	
	public int getExpYear() {
		return m_expYear;
	}
	
	public void setExpYear(int expYear) {
		m_expYear = expYear;
	}
	
	public int getExpMonth() {
		return m_expMonth;
	}
	
	public void setExpMonth(int expMonth) {
		m_expMonth = expMonth;
	}
	
	public String getCCNumber() {
		return m_ccNumber;
	}
	
	public void setCCNumber(String ccNumber) {
		m_ccNumber = ccNumber;
	}
	
	public String getCCType() {
		return m_ccType;
	}
	
	public void setCCType(String ccType) {
		m_ccType = ccType;
	}
}
