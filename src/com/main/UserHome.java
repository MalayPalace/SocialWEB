package com.main;

import com.main.database.DBConnection;
import com.main.UserInfoHold;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Landing Page after Users Logged on
 * 
 * @author Malay Shah
 */
@WebServlet(urlPatterns = { "/UserHome" })
public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		String pass=request.getParameter("pwd");

		Connection conn=null;
		Statement stmt=null;
		ResultSet rs;
		String rPwd;
		String rUser;
		int nFriends;
		try{
			conn=DBConnection.getConn();
			if(conn!=null){
				stmt=conn.createStatement();
				rs=stmt.executeQuery("SELECT USER_NAME,USER_PASSWORD,NO_OF_FRIENDS FROM USER_DETAILS where USER_NAME='"+user+"'");
				if(rs.next()){
					rUser=rs.getString("USER_NAME");
					rPwd=rs.getString("USER_PASSWORD");
					nFriends=rs.getInt("NO_OF_FRIENDS");
					if (rPwd.equals(pass)){
						//Setting Values
						UserInfoHold hs=new UserInfoHold();
						hs.setUsername(rUser);
						hs.setNoFriends(nFriends);
						
						//Setting Values in a Session
						HttpSession sess=request.getSession();
						sess.setAttribute("CurUserDet",hs);
						response.sendRedirect("userIndex.jsp");
					}else{
						request.getRequestDispatcher("/index.html").include(request, response);					
						out.print("<script>document.getElementById(\"err_msg\").innerHTML=\"<font color='red'>Password is Incorrect</font><br>\";</script>");					
					}
				}else{
					request.getRequestDispatcher("/index.html").include(request, response);					
					out.print("<script>document.getElementById(\"err_msg\").innerHTML=\"<font color='red'>Username is Incorrect</font><br>\";</script>");					
				}
				conn.close();
			}
		}catch(Exception err){
			err.printStackTrace();
		}
	}
}
