<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="userjsp/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SocialWEB: Friends</title>
<script src="scripts/friends.js"></script>
<link rel="stylesheet" type="text/css" href="scripts/menustyle.css" />
</head>
<body>
<header>
 <nav>
   <div id="menubar">
        <ul id="nav">
			<li><a href="userIndex.jsp">Home</a></li>
			<li class="current"><a href="#">Friends</a></li>
			<li><a href="serFriends.jsp">Search Friends</a></li>
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

<div id="site_content">
<br>
<table>
<tbody>
<tr>
	<td width="100%" valign="top">
		<div class="table-content">
			<jsp:include page="userjsp/getFriendList.jsp"></jsp:include>
		</div>
	</td>
	<td valign="top">
		<div class="navigation">
			<div class="navigation_top">
				<div class="navigation_bottom">
					<jsp:include page="userjsp/receivedFriendrequest.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</td>
</tr>
</tbody>
</table>
</div>
</body>
</html>