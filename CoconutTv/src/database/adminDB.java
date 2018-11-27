package database;

import java.sql.*;

public class adminDB {
	
	private Connection con = null;
	private PreparedStatement dbQuery;

	public void initializeJdbc() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/moviestoredb", "root", "sesame");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public ResultSet getTableData(String tableName) throws SQLException {
		this.initializeJdbc();
		dbQuery = con.prepareStatement("select * from " + tableName);
		return dbQuery.executeQuery();
		}
	//restrictor variable are the specific values wanted from the table i.e levelName or movie genre
	public ResultSet getTableData(String tableName, String columnName, String restrictor) throws SQLException {
		this.initializeJdbc();
		dbQuery = con.prepareStatement("select * from " + tableName + " where " + columnName + " = " + restrictor);
		return dbQuery.executeQuery();
	}
	
	
}
