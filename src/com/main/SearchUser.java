package com.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.mybatis.dao.UserDetails;
import com.main.mybatis.service.UserDetailsDAOImpl;

/**
 * Servlet implementation class SearchUser
 * 
 * @author Malay Shah
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();

		String user=req.getParameter("userName");
		UserDetails usr=new UserDetails();
		//usr.setUserName(user);
		usr.setEmailId(user);
		usr.setUserId(5);
		
		//DAO Call
		UserDetailsDAOImpl UDTable=new UserDetailsDAOImpl();
		List<UserDetails> userList;
		
		//userList=UDTable.getUsernameNotFriendByUserid(usr);
		userList=UDTable.getUsernameNotFriendByEmailid(usr);

		int i=1;
		for (UserDetails temp:userList){
			out.println("User-ID "+i+": "+temp.getUserId());
			out.println("<br>");
			out.println("User-Name "+i+": "+temp.getUserName());
			i++;
		}
	}

}
