<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.main.UserInfoHold" %>
<%@ page import="org.apache.logging.log4j.LogManager"%>
<%@ page import="org.apache.logging.log4j.Logger"%>
<%@ page import="com.main.mybatis.dao.UserDetails" %>
<%@ page import="com.main.mybatis.service.FriendsDetailsDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<%
Logger log=LogManager.getLogger("getFriendList.jsp");
UserInfoHold data = null;
List<UserDetails> userList=null;
try {
	data = (UserInfoHold) session.getAttribute("CurUserDet");
	if(data!=null){
		int userID = data.getUserID();
		
		//Initializing for DAO Call
		FriendsDetailsDAOImpl FDTable=new FriendsDetailsDAOImpl();
		
		userList = FDTable.getFriendsList(userID);
	}else{
		response.sendRedirect("index.html");
	}
	
	if(!userList.isEmpty()){
		int retID;
		String retUser,retEmail; 
		out.println("<table cellpadding='6'>");
		for(UserDetails userDet:userList){
			retID = userDet.getUserId();
			retUser = userDet.getUserName();
			retEmail = userDet.getEmailId();
			out.println("<tr>");
			out.println("<td rowspan='2'><img src='images/shadow.png' width='62' height='62' /></td>");
			out.println("<td>"+retUser+"</td>");
			out.println("<td></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>"+retEmail+"</td>");
			out.println("<td>");
			out.println("<div id='user"+retUser+"Button'>");
			out.println("<button type='button' name='blockFriend' onclick='blockReq("+retID+",\""+retUser+"\")'>Block Friend</button></td>");
			out.println("</div>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}else{
		out.println("No Friends!<br><br>");
		out.println("Try searching some new Friends");
	}

} catch (Exception err) {
	log.error("Error while getting Session Data: " + err.getMessage());
}
%>