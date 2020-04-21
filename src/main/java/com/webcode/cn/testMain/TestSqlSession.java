package com.webcode.cn.testMain;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import com.webcode.cn.entity.User;
import com.webcode.cn.mapper.UserMapper;

/**
 * @ClassName TestSqlSession.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020��4��5��
 * @Version 1.0
 */
public class TestSqlSession {
	
	
	public SqlSessionFactory getSqlSessionFactory() {
		
		// ��ȡָ������Դ
		InputStream is;
		SqlSessionFactory sqlSessionFactoryMethod = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			// ͨ��sqlSessionFactoryBuilder����SqlSessionFactory
			sqlSessionFactoryMethod = new SqlSessionFactoryBuilder().build(is);
			System.out.println( sqlSessionFactoryMethod );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlSessionFactoryMethod;

	}

	public SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

	@Test
	public void test1() {
		// ���� SqlSession
		SqlSession sqlsession = null;
		
		try {			
			
			// ����SqlSession
			sqlsession = sqlSessionFactory.openSession();
//			selectOne��������ִ��select��ѯ��䣬������һ������
			// some code ...
			User user = sqlsession.selectOne("com.webcode.cn.entity.User.selectUserById", 1);
			System.out.println( user );
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlsession.rollback();
		} finally {
			// ��finally �����ȷ����Դ��˳���ر�
			sqlsession.close();//�ͷ���Դ
		}
		
	}
	
	@Test
	public void test2() throws Exception {
		// ��ȡָ������Դ
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3333/mybatis?characterEncoding=utf8&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//�������ݿ�����ʽ
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		// �������ݿ����л���
		Environment environment = new Environment("development", transactionFactory, dataSource);
		// ����Configuration����
		Configuration configuration = new Configuration(environment);
		// ����һ��ӳ����
		configuration.addMapper(UserMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		System.out.println( sqlSessionFactory );
		// �൱�� ��ǰ��Connection����ÿ���������ùر�
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
//			selectOne��������ִ��select��ѯ��䣬������һ������
			// ��ȡӳ����Mapper
			UserMapper userMapper = openSession.getMapper(UserMapper.class);			
			User user = userMapper.selectUserById(1);
			System.out.println( user );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();//�ͷ���Դ
		}
		
	}
}
