<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.main.UserInfoHold" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	UserInfoHold data=(UserInfoHold)session.getAttribute("CurUserDet");
	String username = data.getUsername();
	int noFriend = data.getNoFriends();
%>
<body bgcolor="#D2D2D2">
<font text-align="right">
<table>
<tr>
<td>Welcome: <%=username %></td>
<td><img src="images/logout.png" /></td>
</tr>
<tr>
<td>Friends: <%=noFriend %></td>
<td></td>
</tr>
</table>
</font>
</body>
