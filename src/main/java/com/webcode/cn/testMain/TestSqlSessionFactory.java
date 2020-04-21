package com.webcode.cn.testMain;

import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import com.webcode.cn.entity.User;
import com.webcode.cn.mapper.UserMapper;

/**
 * @ClassName TestSqlSessionFactory.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020年4月5日
 * @Version 1.0
 */
public class TestSqlSessionFactory {
	
	@Test
	public void test1() throws Exception {
		
		SqlSession session = null;
		
		try {
			// 读取指定的资源
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			// 通过sqlSessionFactoryBuilder创建SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			System.out.println( sqlSessionFactory );
			
			// 定义SqlSession
			// 相当于 以前的Connection对象，每次用来都用关闭
			session = sqlSessionFactory.openSession();
//			selectOne方法用来执行select查询语句，并返回一个对象
			// 放名称空间+id
			User user = session.selectOne("com.webcode.cn.entity.User.selectUserById", 1);
			System.out.println( user );
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();//释放资源
		}
		
	}
	
	@Test
	public void test2() throws Exception {
		// 读取指定的资源
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3333/mybatis?characterEncoding=utf8&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建数据库事务方式
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		// 创建数据库运行环境
		Environment environment = new Environment("development", transactionFactory, dataSource);
		// 构建Configuration对象
		Configuration configuration = new Configuration(environment);
		// 加入一个映射器
		configuration.addMapper(UserMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		System.out.println( sqlSessionFactory );
		// 相当于 以前的Connection对象，每次用来都用关闭
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
//			selectOne方法用来执行select查询语句，并返回一个对象
			// 放名称空间+id
			UserMapper userMapper = openSession.getMapper(UserMapper.class);			
			User user = userMapper.selectUserById(1);
			System.out.println( user );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();//释放资源
		}
		
	}

}
