package database;
import java.sql.*;

public class quotesDB {
	private static Connection con = null;
	private static PreparedStatement dbQuery;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb", "root", "sesame");
			return con;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	private static int getRandomQID() throws SQLException {
		getConnection();
		String select = "select count(*) as quotes from quotes";
		dbQuery = con.prepareStatement(select);
		ResultSet rset = dbQuery.executeQuery();
		if (rset.next()) {
			return (int)(Math.random() * rset.getInt("quotes") + 1);
		}
		else
			return 1;
		
	}
	//Quote is first and then the movie title
	public static String[] getQuote() throws SQLException {
		getConnection();
		String[] quoteInfo = new String[] {"PLACHOLDER QUOTE", "PLACEHOLDER TITLE"};
		ResultSet rset = dbQuery.executeQuery("select * from quotes where quoteid = " + getRandomQID());
		if(rset.next()) {
			quoteInfo[0] = rset.getString("quoteString");
			quoteInfo[1] = rset.getString("movieTitle");
		}
		return quoteInfo;
	}

}
