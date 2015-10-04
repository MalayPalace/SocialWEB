package com.main.mybatis.dao;

import java.sql.Date;

/**
 * Class to Map from Friends_Details Table in Database
 * 
 * @author Malay Shah
 *
 */
public class FriendsDetails {
	private int tableId;
	private int userId_fk;
	private int friendsId;
	private int pendingFlag;
	private Date insDate;
	private int isBlock;

	//GETTER & SETTER
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public int getUserId_fk() {
		return userId_fk;
	}
	public void setUserId_fk(int userId_fk) {
		this.userId_fk = userId_fk;
	}
	public int getFriendsId() {
		return friendsId;
	}
	public void setFriendsId(int friendsId) {
		this.friendsId = friendsId;
	}
	public int getPendingFlag() {
		return pendingFlag;
	}
	public void setPendingFlag(int pendingFlag) {
		this.pendingFlag = pendingFlag;
	}
	public Date getInsDate() {
		return insDate;
	}
	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}
	public int getIsBlock() {
		return isBlock;
	}
	public void setIsBlock(int isBlock) {
		this.isBlock = isBlock;
	}
}
