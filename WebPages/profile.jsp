<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="userjsp/header.jsp" %>
<%@ page import="com.main.mybatis.service.UserDetailsDAOImpl"%>
<%@ page import="com.main.mybatis.dao.UserDetails"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SocialWEB: Profile</title>
<link rel="stylesheet" type="text/css" href="scripts/menustyle.css" />
<script src="scripts/scripts_js.js"></script>
</head>
<body onload="getStr()">
<header>
 <nav>
   <div id="menubar">
        <ul id="nav">
			<li><a href="userIndex.jsp">Home</a></li>
			<li><a href="friends.jsp">Friends</a></li>
			<li><a href="serFriends.jsp">Search New Friends</a></li>
			<li class="current"><a href="#">Profile</a></li>
        </ul>
  <ul id="disp">
	<li>Welcome, <%=username %>&nbsp;&nbsp;&nbsp;</li>
	<li>Friends: <%=noFriend %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout.jsp"><img src="images/logout.png" width="62" height="26" /></a></li>
  </ul>
      </div><!--close menubar-->	
    </nav>
</header>

<!--Main Page  -->
<br>
<div id="message-placeholder">
</div>
<br>

<!--Get Information for currently logged User-->
<%
	int id;
	UserDetails currValue = new UserDetails();
	UserDetailsDAOImpl usrDao = new UserDetailsDAOImpl();

	if (!(data == null)) {
		id = data.getUserID();
		currValue = usrDao.getUserByuserId(id);
		if (currValue == null) {
			log.error("Error while fetching value from USER_DETAILS Table");
		}
%>

<div id="site_content">
<br><br>
<form name="frm" method="post" action="UpdateUser" onsubmit="return profileCheck()">
	<table>
		<tr>
			<td>EMAIL-ID :</td>
			<td><input type="email" name="email" size="40%" value="<%=currValue.getEmailId() %>" /></td>
			<td></td>
			<td><input type="hidden" name="hid_email"value="<%=currValue.getEmailId() %>" /></td>
		</tr>
		<tr>
			<td>USERNAME :</td>
			<td><input type="text" name="username" size="40%" value="<%=currValue.getUserName() %>" onchange="getUser(this.value)"/></td>
			<td><div id="userchk"></div></td>
			<td><input type="hidden" name="hid_username"value="<%=currValue.getUserName() %>" /></td>
		</tr>
		<tr>
			<td></td>
			<td><font color="GRAY">Should be unique</font></td>
			<td></td>
		</tr>
		<tr>
			<td>PASSWORD :</td>
			<td><input type="text" name="pwd" size="40%" value="<%=currValue.getUserPassword() %>" /></td>
			<td></td>
			<td><input type="hidden" name="hid_pwd" value="<%=currValue.getUserPassword() %>" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><input type="hidden" name="UsrID" value="<%=id %>" /></td>
			<td><input type="hidden" name="nFriends" value="<%=currValue.getNoFriends() %>" /></td>
			<td><input type="submit" value="UPDATE"></td>
			<td><input type="reset" value="CLEAR"></td>
		</tr>
	</table>
</form>
<br><br>
</div>
</body>
</html>
<%
	}
%>
