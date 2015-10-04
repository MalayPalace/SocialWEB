package com.main.mybatis.dao;

import java.util.List;

/**
 * Interface for Mapping Friends_Details Class to Database for mybatis
 * 
 * @author Malay Shah
 *
 */
public interface FriendsDetailsDAO {
	
	/**
	 * Method to Insert Friend Relation to DB
	 * 
	 * @param FriendsDetails
	 * @return int
	 */
	public int insertRelation(FriendsDetails fnd);
	
	/**
	 * Method to get received Friends request
	 * 
	 * @param int
	 * @return UserDetails 
	 */
	public List<UserDetails> getFriendRequestByFriendsID(int friendsId);
	
	/**
	 * Method to get List of User_ID whom Friend request is sent
	 * 
	 * @param int
	 * @return List<Integer>
	 */
	public List<Integer> getFriendRequestSend(int userId);
	
	/**
	 * Method to get List of Friends using userId
	 * 
	 * @param int
	 * @return List<UserDetails>
	 */
	public List<UserDetails> getFriendsList(int userId);
}
