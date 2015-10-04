<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.main.UserInfoHold" %>
<%@page import="org.apache.logging.log4j.LogManager"%>
<%@page import="org.apache.logging.log4j.Logger"%>

<!DOCTYPE html>
<%
Logger log=LogManager.getRootLogger();
String username=null;
int noFriend=0;
UserInfoHold data=null;
try{
		data=(UserInfoHold)session.getAttribute("CurUserDet");
		username = data.getUsername();
		noFriend = data.getNoFriends();
	}catch(NullPointerException err){
		response.sendRedirect("index.html");
		//response.setHeader("Location", "index.html");
	}catch(Exception err){
		log.error("Error while getting Session Data: "+err.getMessage());
	}
%>