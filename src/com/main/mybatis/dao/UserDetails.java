package com.main.mybatis.dao;

import java.sql.Date;

/**
 * Class to Map from User_Details Table in Database
 * 
 * @author Malay Shah
 *
 */

public class UserDetails {
	private int userId;
	private String userName;
	private String userPassword;
	private String emailId;
	private Date insDate;
	private int noFriends;
	
	//Getter & Setter Methods
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getInsDate() {
		return insDate;
	}
	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}
	public int getNoFriends() {
		return noFriends;
	}
	public void setNoFriends(int noFriends) {
		this.noFriends = noFriends;
	}	
}
