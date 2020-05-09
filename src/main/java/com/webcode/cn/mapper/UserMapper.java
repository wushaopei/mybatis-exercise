package com.webcode.cn.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.webcode.cn.entity.User;

/**
 * @ClassName UserMapper.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020年4月5日
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
	 * 根据用户的lastName属性和sex属性查询用户信息<br/>
	 * 	前提条件是lastName属性和sex属性值都合法。<br/>
	 * 	如果lastName属性和sex属性哪个不合法，就不要加入查询条件
	 */
	public List<User> queryUserByNameAndSex(User user);
	
	/**
	 * 根据user对象的属性进行查询<br/>
	 * 	1、如果lastName值有效（非空），则做模糊查询<br/>
	 *  2、sex属性如果有效，就做性别查询<br/>
	 *  3、使用默认条件查询
	 */
	public List<User> queryUsersByNameOrSexChoose(User user);
	
	public List<User> queryUserByNameAndSexTrim(User user);
	
}
