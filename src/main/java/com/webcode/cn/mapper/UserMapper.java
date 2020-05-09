package com.webcode.cn.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.webcode.cn.entity.User;

/**
 * @ClassName UserMapper.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020��4��5��
 * @Version 1.0
 */
public interface UserMapper {
	
	public User selectUserById(Integer id);
	
	public User selectUserByName(User user);
	
	public List<User> queryUsers();
	
	public List<User> selects();
	
	public int queryUsersCountByName(String  lastName);

	public int saveUser(User user);

	public int deleteUserById(Integer id);

	public int updateUser(User user);
	
	/**
	 * �����û���lastName���Ժ�sex���Բ�ѯ�û���Ϣ<br/>
	 * 	ǰ��������lastName���Ժ�sex����ֵ���Ϸ���<br/>
	 * 	���lastName���Ժ�sex�����ĸ����Ϸ����Ͳ�Ҫ�����ѯ����
	 */
	public List<User> queryUserByNameAndSex(User user);
	
	/**
	 * ����user��������Խ��в�ѯ<br/>
	 * 	1�����lastNameֵ��Ч���ǿգ�������ģ����ѯ<br/>
	 *  2��sex���������Ч�������Ա��ѯ<br/>
	 *  3��ʹ��Ĭ��������ѯ
	 */
	public List<User> queryUsersByNameOrSexChoose(User user);
	
	public List<User> queryUserByNameAndSexTrim(User user);
	
}
