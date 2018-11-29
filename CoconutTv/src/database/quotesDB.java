package database;
import java.sql.*;

public class quotesDB {
	private static Connection con;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb", "root", "sesame");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
	}
	
	private static int getRandomQID() throws SQLException {
		PreparedStatement dbQuery;
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
		PreparedStatement dbQuery;
		int randomQID = getRandomQID();
		
		dbQuery = con.prepareStatement("select * from quotes where quoteid = ?");
		dbQuery.setInt(1, randomQID);
		ResultSet rset = dbQuery.executeQuery();
		String[] quoteInfo = new String[] {"PLACHOLDER QUOTE", "PLACEHOLDER TITLE"};
		if(rset.next()) {
			quoteInfo[0] = rset.getString("quoteString");
			quoteInfo[1] = rset.getString("movieTitle");
		}
		return quoteInfo;
	}

}
