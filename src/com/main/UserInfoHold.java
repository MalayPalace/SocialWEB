package com.main;

/**
 * This class is used to hold User Information
 * 
 * @author Malay Shah
 */

public class UserInfoHold {
	
	private int userID;
	private String username;
	private int noFriends;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public int getNoFriends() {
		return noFriends;
	}
	public void setNoFriends(int noFriends) {
		this.noFriends = noFriends;
	}
}
