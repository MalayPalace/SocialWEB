<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.main.UserInfoHold"%>
<%@ include file="userjsp/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SocialWEB: Search Friends</title>
<script src="scripts/search.js"></script>
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
			<li><a href="profile.jsp">Profile</a></li>
      
        </ul>
  <ul id="disp">
	<li>Welcome, <%=username %>&nbsp;&nbsp;&nbsp;</li>
	<li>Friends: <%=noFriend %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout.jsp"><img src="images/logout.png" width="62" height="26" /></a></li>
  </ul>
      </div><!--close menubar-->	
    </nav>
</header>

<!--Main Page  -->
<!--Error Message  -->
<br>
<div id="message-placeholder">
</div>
<br>

<%
if (!(data == null)) {
%>
<!-- Site Content -->
<div id="site_content">
<br>
<form name="searchFrm" onsubmit="javascript:dataChange(<%=data.getUserID() %>);return false;">
	&nbsp;&nbsp;<input type="text" name="searchTxt" size="40%" placeholder="Enter first few characters to search" value="" />
	<input type="submit" value="Search" onclick="dataChange(<%=data.getUserID() %>)">
	&nbsp;&nbsp;Search by :&nbsp;&nbsp;
	<select name="searchType" onchange="chgTxt()">
		<option value="Username" selected>Username</option>
		<option value="Email">Email</option>
	</select>
</form>
<br>

<!-- Div Tag to display process data -->
<div id="mainData">
</div>

<br><br>
</div>
</body>
</html>
<%
	}
%>
