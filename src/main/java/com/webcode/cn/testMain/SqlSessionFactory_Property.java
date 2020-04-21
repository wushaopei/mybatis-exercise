package com.webcode.cn.testMain;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.webcode.cn.entity.User;
import com.webcode.cn.util.SqlSessionFactoryUtil;

/**
 * @ClassName SqlSessionFactory_Property.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020年4月13日
 * @Version 1.0
 */
public class SqlSessionFactory_Property {
	
	private static String decode(String str){
		//解密
		return str;
	}
	
	public static void  main (String[] args){
		
		InputStream cfgStream = null;
		Reader cfgReader = null;
		InputStream proStream = null;
		Reader proReader = null;
		Properties properties = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null; 
		try{
			// 读入配置文件流
			cfgStream = Resources.getResourceAsStream("mybatis-config.xml");
			cfgReader = new InputStreamReader(cfgStream); 
			
			//读入属性文件
			proStream = Resources.getResourceAsStream("jdbc.properties");
			proReader = new InputStreamReader(proStream);
			properties = new Properties();
			properties.load(proReader);
			
			
			// 解密为明文
			properties.setProperty("username", decode(properties.getProperty("username")));			
			properties.setProperty("password", decode(properties.getProperty("password")));				
					
			
			System.out.println( decode(properties.getProperty("username")) );
		}catch(Exception ex){
			
			Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(null,ex);	
		}
		
		synchronized(SqlSessionFactory_Property.class){
			if (sqlSessionFactory == null){
				// 使用属性来创建SqlSessionFactory
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(cfgReader, properties);
			}
		}

		
	}
}
