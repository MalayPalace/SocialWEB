package com.main.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.main.mybatis.dao.FriendsDetails;
import com.main.mybatis.dao.FriendsDetailsDAO;
import com.main.mybatis.dao.UserDetails;

/**
 * Implementation of FriendsDetailsDAO
 * 
 * @author Malay Shah
 *
 */
public class FriendsDetailsDAOImpl implements FriendsDetailsDAO{

	@Override
	public int insertRelation(FriendsDetails fnd) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		int rows=0;
		try{
			FriendsDetailsDAO sqlMapper = sqlSession.getMapper(FriendsDetailsDAO.class);
			rows=sqlMapper.insertRelation(fnd);
			sqlSession.commit();
			return rows;
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<UserDetails> getFriendRequestByFriendsID(int friendsId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			FriendsDetailsDAO sqlMapper = sqlSession.getMapper(FriendsDetailsDAO.class);
			return sqlMapper.getFriendRequestByFriendsID(friendsId);
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<Integer> getFriendRequestSend(int userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			FriendsDetailsDAO sqlMapper = sqlSession.getMapper(FriendsDetailsDAO.class);
			return sqlMapper.getFriendRequestSend(userId);
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<UserDetails> getFriendsList(int userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			FriendsDetailsDAO sqlMapper = sqlSession.getMapper(FriendsDetailsDAO.class);
			return sqlMapper.getFriendsList(userId);
		}finally{
			sqlSession.close();
		}
	}
}
