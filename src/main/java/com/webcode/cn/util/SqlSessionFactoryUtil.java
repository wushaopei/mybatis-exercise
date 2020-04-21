package com.webcode.cn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @ClassName SqlSessionFactoryUtil.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020年4月7日
 * @Version 1.0
 */
public class SqlSessionFactoryUtil {
	
	// SqlSessionFactory对象
	private static SqlSessionFactory sqlSessionFactory = null;
	// 类线程锁
	private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;
	/**
	 * 私有化构造参数 
	 */
	private SqlSessionFactoryUtil(){}
	/**
	 * 构建SqlSessionFactory 
	 */
	public static SqlSessionFactory initSqlSessionFactory(){
//		String resource = "mybatis-config.xml";
//		String resource = "mybatis-property.xml";
		String resource = "mybatis-properties.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		}catch (IOException ex){
			Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE,null,ex);
		}
		synchronized(CLASS_LOCK){
			if(sqlSessionFactory == null){
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}
		}
		return sqlSessionFactory;
	}
	
	/**
	 * 打开 SqlSession 
	 */
	public static SqlSession openSqlSession (){
		if(sqlSessionFactory == null){
			initSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();
	}

}
