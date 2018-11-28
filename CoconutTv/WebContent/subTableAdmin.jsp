<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import = "java.sql.*" %>
<%@ page import = "database.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% 
	String table = "subscriber";
	//This should be passed down from the page that collects the parameters
	String tableName = request.getParameter("tablename");
	
	ResultSet rsColumns = adminDB.getConnection().getMetaData().getColumns(null, null, table,null);
	%>
	
	<table border = "1">
	<tr>
	<% // Add column names to the table
	while (rsColumns.next()) { %>
	<td><%= rsColumns.getString("COLUMN_NAME") %></td>
	<%}%>
	</tr>

	<% 
	ResultSet rs = adminDB.getTableData(table);
	
	// Get column count
	int columnCount = rs.getMetaData().getColumnCount();

	// Store rows to rowData
	while (rs.next()) {
	out.println("<tr>");
	for (int i = 0; i < columnCount; i++) {out.println("<td>"); %>
	<%= rs.getObject(i + 1) %>
	<% 	out.println("</td>");}
	out.println("</tr>");
	} %>
	</table>
	</body>
  </html>
