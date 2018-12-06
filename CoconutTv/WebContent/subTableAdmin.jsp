<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import = "java.sql.*" %>
<%@ page import = "database.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="WebImages/logo.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link href="./subTableAdmin.css" rel="stylesheet" type="text/css">



<title>Administrator</title>
</head>
<body>
	
	<div class="container-fluid">
	
	<% 
	String table = "subscriber";
	//This should be passed down from the page that collects the parameters
	String tableName = request.getParameter("tablename");
	
	ResultSet rsColumns = adminDB.getConnection().getMetaData().getColumns(null, null, table,null);
	%>
	<div class="page-header"> <h2> Current Table Name: <% out.println(table); %> </h2>  </div>
	
	<div class="row">
	
	<table border = "1" align="center">
	<tr>
	<% // Add column names to the table
	while (rsColumns.next()) { %>
	<td> <h4><b><%= rsColumns.getString("COLUMN_NAME") %></b> </h4></td>
	<%}%>
	
	</tr> 

	<% 
	ResultSet rs = adminDB.getTableData(table);
	
	// Get column count
	int columnCount = rs.getMetaData().getColumnCount();

	// Store rows to rowData
	while (rs.next()) {
	out.println("<tr>");
	for (int i = 0; i < columnCount; i++) {out.println("<td><h5><i>"); %>
	<%= rs.getObject(i + 1) %>
	<% 	out.println("</i></h5></td>");}
	out.println("</tr>");
	} %>
	</table>

	</div>
	</div>
	<br> 
	<center><a href="./adminOptions.jsp" >Back To Options</a><br>
	<a href="./welcome.jsp">Exit</a><br><br> </center>
	</body>
  </html>
