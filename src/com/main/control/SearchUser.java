package com.main.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import com.main.mybatis.service.FriendsDetailsDAOImpl;
import com.main.mybatis.service.UserDetailsDAOImpl;

/**
 * Servlet which Searches Users by Username or Email-ID
 * 
 * @author Malay Shah
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log=LogManager.getLogger(SearchUser.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();

		String type=req.getParameter("type");
		String user=req.getParameter("user");
		int usrid=Integer.parseInt(req.getParameter("userid"));
		List<Integer> result=null;
		UserInfoHold userSess;
		HttpSession currSess=req.getSession();

		//Get Data From Session Set
		userSess=(UserInfoHold)currSess.getAttribute("CurUserDet");
		int currUserId=userSess.getUserID();

		//For calling DAO function
		UserDetails usrData=new UserDetails();

		//Initializing for DAO Call
		UserDetailsDAOImpl UDTable=new UserDetailsDAOImpl();
		FriendsDetailsDAOImpl FDTable=new FriendsDetailsDAOImpl();
		List<UserDetails> userList=new ArrayList<UserDetails>();

		if(type.equals("USER")){
			if(user.length()>=3){
				user="%"+user+"%";
				usrData.setUserId(usrid);
				usrData.setUserName(user);
				try{
					//Get list of Users by username
					userList=UDTable.getUsernameNotFriendByUserid(usrData);
				}catch(Exception err){
					log.error("Error occured while execution DAO->getUsernameNotFriendByUserid :"+err.getMessage());
				}
			}

		}else if(type.equals("EMAIL")){
			usrData.setUserId(usrid);
			usrData.setEmailId(user);
			try{
				//Get list of Users by EmailID
				userList=UDTable.getUsernameNotFriendByEmailid(usrData);
			}catch(Exception err){
				log.error("Error occured while execution DAO->getUsernameNotFriendByUserid :"+err.getMessage());
			}
		}

		if(!userList.isEmpty()){
			try{
				result=FDTable.getFriendRequestSend(currUserId);
			}catch(Exception err){
				log.error("Error while getting Friend Req already sent :"+err.getMessage());
			}
			out.println("<table cellpadding='6'>");
			for(UserDetails userDet:userList){
				int retID=userDet.getUserId();
				out.println("<tr>");
				out.println("<td rowspan='2'><img src='images/shadow.png' width='62' height='62' /></td>");
				out.println("<td>"+userDet.getUserName()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>");
				out.println("<div id='user"+userDet.getUserName()+"Button'>");
				if(result.contains(retID)){
					out.println("<i>Friend request sent</i>");
				}else{
					out.println("<button type='button' name='addfriend' onclick='sendReq("+retID+",\""+userDet.getUserName()+"\")'>Add Friend</button>");
				}
				out.println("</div>");
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}else{
			out.println("<msg>messagePrint</msg>");
		}
	}
}
