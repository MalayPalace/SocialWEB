package com.main;

import com.main.database.DBConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddUser
 * 
 * @author Malay Shah
 */

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String email=req.getParameter("email");
		String user=req.getParameter("username");
		String pass=req.getParameter("pwd");

		Connection conn=null;
		Statement stmt=null;
		try{
			conn=DBConnection.getConn();
			if(conn!=null){
				stmt=conn.createStatement();
				stmt.executeUpdate("insert into USER_DETAILS(USER_NAME,USER_PASSWORD,EMAIL_ID,INS_DATE,NO_OF_FRIENDS) " +
						"values('"+user+"','"+pass+"','"+email+"',CURRENT_TIMESTAMP(),0)");
				out.print("<div class='block'>User Registered Successfully!!  ");
				out.print("<a href='index.html'>Click Here</a> to go back to Login Page</div>");
				req.getRequestDispatcher("/register.jsp").include(req, res);
				conn.close();
			}
		}catch(Exception err){			
			err.printStackTrace();
			out.println("Connection Error. Please again later");
			out.print("<a href='index.html'>Click Here</a> to go back to Login Page");
		}
	}
}
