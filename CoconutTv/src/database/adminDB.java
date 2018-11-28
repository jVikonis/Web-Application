package database;

import java.sql.*;

public class adminDB {
	
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
	
	public static ResultSet getTableData(String tableName) throws SQLException {
		getConnection();
		dbQuery = con.prepareStatement("select * from " + tableName);
		return dbQuery.executeQuery();
		}
	//restrictor variable are the specific values wanted from the table i.e levelName or movie genre
	public static ResultSet getTableData(String tableName, String columnName, String restrictor) throws SQLException {
		getConnection();
		dbQuery = con.prepareStatement("select * from " + tableName + " where " + columnName + " = " + restrictor);
		return dbQuery.executeQuery();
	}
	
	
}
