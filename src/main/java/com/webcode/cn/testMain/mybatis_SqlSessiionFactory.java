package com.webcode.cn.testMain;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @ClassName mybatis_SqlSessiionFactory.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020Äê4ÔÂ5ÈÕ
 * @Version 1.0
 */
public class mybatis_SqlSessiionFactory {

	public  static void main(String [] args) throws IOException{
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
			
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

}
