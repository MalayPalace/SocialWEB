<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.main.mybatis.dao.UserDetails"%>
<%@page import="com.main.mybatis.service.FriendsDetailsDAOImpl"%>
<%@page import="com.main.UserInfoHold"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
  <%
  UserInfoHold sess=null;
  try{
	  sess=(UserInfoHold)session.getAttribute("CurUserDet");
	  int usrID=sess.getUserID();
	  System.out.println("UserID==="+usrID);
	  List<UserDetails> dataHold;
	  FriendsDetailsDAOImpl frndDAO=new FriendsDetailsDAOImpl();
	  
	  dataHold=frndDAO.getFriendRequestByFriendsID(usrID);
	  System.out.println("Size==="+dataHold.size());
	  if(!dataHold.isEmpty()){
			out.println("<b>Friend Request</b>");
			out.println("<hr>");
		  	out.println("<table cellpadding='2'>");
			for(UserDetails userDet:dataHold){
				out.println("<tr>");
				out.println("<td colspan='2'>"+userDet.getUserName()+"</td>");				
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td colspan='2'>"+userDet.getEmailId()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><button name='acceptButton' onclick='acceptClick("+userDet.getUserId()+")'>Accept</button></td>");
				out.println("<td><button name='rejectButton' onclick='rejectClick("+userDet.getUserId()+")'>Reject</button></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><hr></td>");
				out.println("<td><hr></td>");
				out.println("</tr>");
			}
			out.println("</table>");
	  }else{
		  out.println("No Pending Friend Request ");
	  }
  }catch(Exception err){
	  err.printStackTrace();
	  response.sendRedirect("../index.html");
  }
  %>

</body>
</html>