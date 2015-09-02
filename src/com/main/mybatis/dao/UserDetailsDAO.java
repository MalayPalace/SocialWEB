package com.main.mybatis.dao;

import java.util.List;
import com.main.mybatis.dao.UserDetails;

/**
 * Interface for Mapping User_Details Class to Database for mybatis
 * 
 * @author Malay Shah
 *
 */

public interface UserDetailsDAO {
	
	/**
	 * Get List of all User who are not yet Friends from Username
	 * 
	 * @param user
	 * @return
	 */
	public List<UserDetails> getUsernameNotFriendByUserid(UserDetails user);

	/**
	 * Get List of all User who are not yet Friends from Email ID
	 * 
	 * @param user
	 * @return
	 */
	public List<UserDetails> getUsernameNotFriendByEmailid(UserDetails user);

	/**
	 * Get UserDetails from UserID
	 * 
	 * @param userId
	 * @return
	 */
	public UserDetails getUserByuserId(int userId);
}
