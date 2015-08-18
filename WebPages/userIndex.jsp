<%@page import="com.mysql.fabric.xmlrpc.base.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.main.UserInfoHold"%>
<%@ include file="userjsp/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SocialWEB: UserPage</title>
<link rel="stylesheet" type="text/css" href="scripts/menustyle.css" />
</head>
<body>
<header>
 <nav>
   <div id="menubar">
        <ul id="nav">
			<li class="current"><a href="index.html">Home</a></li>
			<li><a href="ourwork.html">Our Work</a></li>
			<li><a href="testimonials.html">Testimonials</a></li>
			<li><a href="projects.html">Projects</a></li>
			<li><a href="contact.html">Contact Us</a></li>
        </ul>
  <ul id="disp">
	<li>Welcome, <%=username %>&nbsp;&nbsp;&nbsp;</li>
	<li>Friends: <%=noFriend %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout.jsp"><img src="images/logout.png" width="62" height="26" /></a></li>
  </ul>
      </div><!--close menubar-->	
    </nav>
</header>
</body>
</html>
