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
	
	public static String[] getTables() {
		String[] tables = null;
		
		try {
			DatabaseMetaData dbMetaData = con.getMetaData();
			ResultSet rsTables = dbMetaData.getTables(null, "moviestoredb", null, new String[] {"TABLE"});
			
			int size = 0;
			while (rsTables.next()) size++;
			
			rsTables = dbMetaData.getTables(null, null, null, new String[] {"TABLE"});
			
			tables = new String[size];
			
			int i = 0;
			while (rsTables.next())
				tables[i++] = rsTables.getString("TABLE_NAME");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	
		return tables;
	}
	
	public static Connection getConnection() {
		return con;
	}
	
}
