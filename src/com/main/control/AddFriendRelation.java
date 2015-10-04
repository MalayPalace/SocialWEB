package com.main.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.main.UserInfoHold;
import com.main.mybatis.dao.FriendsDetails;
import com.main.mybatis.service.FriendsDetailsDAOImpl;

/**
 * Servlet implementation class AddFriendRelation
 * 
 * @author Malay Shah
 */
@WebServlet("/AddFriendRelation")
public class AddFriendRelation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log=LogManager.getLogger(AddFriendRelation.class);

	/**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriendRelation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		UserInfoHold userSess;
		HttpSession currSess=request.getSession();
		FriendsDetails frndData=new FriendsDetails();
		FriendsDetailsDAOImpl frndDao=new FriendsDetailsDAOImpl();
		
		//Get Data From Session Set
		userSess=(UserInfoHold)currSess.getAttribute("CurUserDet");
		int fndID=Integer.parseInt(request.getParameter("friendID"));
		int usrID=userSess.getUserID();
		frndData.setUserId_fk(usrID);
		frndData.setFriendsId(fndID);
		
		try{
			frndDao.insertRelation(frndData);
			log.debug("Friend request sent from "+usrID+" to "+fndID);
			out.println("<msg>Successfull</msg>");
		}catch(Exception err){
			log.error("Friend request sent from "+usrID+" to "+fndID+" FAILED!!");
			response.sendError(404);
		}
	}
}
