package com.main.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.main.UserInfoHold;
import com.main.mybatis.dao.UserDetails;
import com.main.mybatis.service.UserDetailsDAOImpl;

/**
 * Servlet to Update Information
 * 
 * @author Malay Shah
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log=LogManager.getLogger(UpdateUser.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUser() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		int id=Integer.parseInt(req.getParameter("UsrID"));
		String email=req.getParameter("email");
		String user=req.getParameter("username");
		String pass=req.getParameter("pwd");
		int nFriends=Integer.parseInt(req.getParameter("nFriends"));
		int rows=0;
		
		log.error("String===["+email+", "+user+", "+pass+"]");
		//For DAO Call
		UserDetailsDAOImpl userDao=new UserDetailsDAOImpl();
		UserDetails Upduser=new UserDetails();

		//Object created for holding session
		UserInfoHold currUser=new UserInfoHold();

		Upduser.setUserId(id);
		Upduser.setEmailId(email);
		Upduser.setUserName(user);
		Upduser.setUserPassword(pass);

		try{
			rows=userDao.updateUser(Upduser);
			if(log.isTraceEnabled()){
				log.trace(rows+" rows are updated for UserID "+id);
			}

			currUser.setUserID(id);
			currUser.setUsername(user);
			currUser.setNoFriends(nFriends);

			//Setting Values in a Session
			HttpSession sess=req.getSession();
			sess.setAttribute("CurUserDet",currUser);
			log.info("Session altered for User "+user);
			res.sendRedirect("profile.jsp?filter=-1");
		}catch(Exception e){
			log.error("Error occurred while updating User Details "+e.getMessage());
			res.sendRedirect("profile.jsp?filter=-2");
		}
	}
}
