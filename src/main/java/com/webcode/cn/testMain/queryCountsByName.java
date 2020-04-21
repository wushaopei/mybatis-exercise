package com.webcode.cn.testMain;

import org.apache.ibatis.session.SqlSession;

import com.webcode.cn.entity.User;
import com.webcode.cn.mapper.UserMapper;
import com.webcode.cn.util.SqlSessionFactoryUtil;

/**
 * @ClassName select元素-简易数据类型的例子
 * @Description TODO
 * @Author wushaopei
 * @Date 2020年4月21日
 * @Version 1.0
 */
public class queryCountsByName {
	
	public static void  main (String[] args){
		
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			int counts = userMapper.queryUsersCountByName("tom");
			
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
