package com.webcode.cn.testMain;

import org.apache.ibatis.session.SqlSession;

import com.webcode.cn.entity.User;
import com.webcode.cn.mapper.UserMapper;
import com.webcode.cn.util.SqlSessionFactoryUtil;

/**
 * @ClassName testMain.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020Äê4ÔÂ7ÈÕ
 * @Version 1.0
 */
public class testMain {

	public static void  main (String[] args){
	
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = new User();
			user.setLastName("tom");
			user.setSex(1);
			userMapper.saveUser(user);
			userMapper.deleteUserById(1);
			userMapper.updateUser(new User(2,"jetty",1));
			sqlSession.commit();			
		}catch(Exception ex){
			System.err.println(ex.getMessage());
			sqlSession.rollback();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
	}
}
