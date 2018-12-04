package database;

import java.sql.*;

public class adminDB {
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
	
	public static ResultSet getTableData(String tableName) throws SQLException {
		PreparedStatement dbQuery;
		dbQuery = con.prepareStatement("select * from " + tableName);
		return dbQuery.executeQuery();
		}
	//restrictor variable are the specific values wanted from the table i.e levelName or movie genre
	public static ResultSet getTableData(String tableName, String columnName, String restrictor) throws SQLException {
		PreparedStatement dbQuery;
		dbQuery = con.prepareStatement("select * from " + tableName + " where " + columnName + " = " + restrictor);
		return dbQuery.executeQuery();
	}
	
	public static Connection getConnection() {
		return con;
	}
	
}
