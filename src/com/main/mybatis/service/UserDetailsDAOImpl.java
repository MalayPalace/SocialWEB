package com.main.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.main.mybatis.dao.UserDetails;
import com.main.mybatis.dao.UserDetailsDAO;
import com.main.mybatis.service.MyBatisUtil;

/**
 * Implementation for UserDetailsDAO
 * 
 * @author Malay Shah
 *
 */
public class UserDetailsDAOImpl implements UserDetailsDAO{

	@Override
	public List<UserDetails> getUsernameNotFriendByUserid(UserDetails user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			UserDetailsDAO userMapper = sqlSession.getMapper(UserDetailsDAO.class);
			return userMapper.getUsernameNotFriendByUserid(user);
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<UserDetails> getUsernameNotFriendByEmailid(UserDetails user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			UserDetailsDAO userMapper = sqlSession.getMapper(UserDetailsDAO.class);
			return userMapper.getUsernameNotFriendByEmailid(user);
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public UserDetails getUserByuserId(int userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			UserDetailsDAO userMapper = sqlSession.getMapper(UserDetailsDAO.class);
			return userMapper.getUserByuserId(userId);
		}finally{
			sqlSession.close();
		}
	}
}
