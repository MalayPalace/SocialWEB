<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
session.invalidate();
%>
<html>
<head>
<meta http-equiv="refresh" content="3;url=index.html" />
</head>
<body>
<p>Logging out...Redirecting to Login page</p><br>
<a href="index.html">Click here</a> if you are not Redirected to Login Page
</body>
</html>