<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.main.DBConnection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<%
		boolean flag = false;
		String temp;
		String value = request.getParameter("user");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConn();
			if (conn != null) {
				stmt = conn.createStatement();
				rs=stmt.executeQuery("Select USER_NAME from USER_DETAILS");
				while (rs.next()) {
					temp = rs.getString(1);
					if (temp.equalsIgnoreCase(value)) {
						flag = true;
						break;
					}
				}

				if (flag) {
	%>
	<img src="images/error.png" width="20px" height="20px" />&nbsp;&nbsp;&nbsp;
	<font color="red">Username is already taken</font>
	<%
		} else {
	%>
	<img src="images/success.png" width="20px" height="20px" />&nbsp;&nbsp;&nbsp;
	<font color="green">Username is available</font>
	<%
		}
				conn.close();
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	%>
</body>
</html>