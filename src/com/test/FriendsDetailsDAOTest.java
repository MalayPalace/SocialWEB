package com.test;

import java.util.List;

import com.main.mybatis.service.FriendsDetailsDAOImpl;

public class FriendsDetailsDAOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FriendsDetailsDAOImpl frnd=new FriendsDetailsDAOImpl();
		List<Integer> result=null;
		int id;
		int check=10;
		
		try{
			result=frnd.getFriendRequestSend(5);
		}catch(Exception err){
			err.printStackTrace();
		}

		if(!result.isEmpty()){
			for(Integer value:result){
				id=(int)value;
				System.out.println(id);
			}
		}else{
			System.out.println("Return List is empty");
		}
		
		System.out.println();
		if (result.contains(check)){
			System.out.println("TRUE");
		}else{
			System.out.println("FALSE");
		}
	}
/*		FriendsDetails fr=new FriendsDetails();
		FriendsDetailsDAOImpl frnd=new FriendsDetailsDAOImpl();
		int rows=0;
		
		//Add values
		fr.setUserId_fk(8);
		fr.setFriendsId(9);
		
		try{
			rows=frnd.insertRelation(fr);
		}catch(Exception err){
			err.printStackTrace();
		}
		
		if(!(rows==0)){
			System.out.println(rows+" Data inserted successfully");
		}else{
			System.out.println("No rows inserted");
		}
	}
*/
}
