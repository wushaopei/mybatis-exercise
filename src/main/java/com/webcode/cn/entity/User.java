package com.webcode.cn.entity;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName User.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020Äê4ÔÂ5ÈÕ
 * @Version 1.0
 */
@Setter
@Getter
@ToString
@Alias("user")
public class User {
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String lastName, Integer sex) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.sex = sex;
	}
	private Integer id;
	private String lastName;
	private Integer sex;
	
	
}
