package com.webcode.cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.webcode.cn.entity.User;

/**
 * @ClassName UserMapper.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020Äê4ÔÂ5ÈÕ
 * @Version 1.0
 */
public interface UserMapper {
	
	public User selectUserById(Integer id);

	public List<User> queryUsers();
	
	public int queryUsersCountByName(String  lastName);

	public int saveUser(User user);

	public int deleteUserById(Integer id);

	public int updateUser(User user);
}
