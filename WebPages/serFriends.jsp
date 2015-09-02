<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.main.UserInfoHold"%>
<%@ include file="userjsp/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SocialWEB: Search Friends</title>
<link rel="stylesheet" type="text/css" href="scripts/menustyle.css" />
</head>
<body>
<header>
 <nav>
   <div id="menubar">
        <ul id="nav">
			<li><a href="userIndex.jsp">Home</a></li>
			<li><a href="friends.jsp">Friends</a></li>
			<li class="current"><a href="#">Search Friends</a></li>
			<li><a href="noti.jsp">Notification</a></li>
        </ul>
  <ul id="disp">
	<li>Welcome, <%=username %>&nbsp;&nbsp;&nbsp;</li>
	<li>Friends: <%=noFriend %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout.jsp"><img src="images/logout.png" width="62" height="26" /></a></li>
  </ul>
      </div><!--close menubar-->	
    </nav>
</header>
<br><br>

<!--Main Page  -->
<form>
	<input type="text" size="40%" placeholder="Enter first few characters to search" />&nbsp;&nbsp;Search by :&nbsp;&nbsp;
	<select name="searchType">
		<option value="Username" selected>Username</option>
		<option value="Email">Email</option>		
	</select>
<br>

<!-- Div Tag to display process data -->
<div id="mainData"></div>

</form>
</body>
</html>
