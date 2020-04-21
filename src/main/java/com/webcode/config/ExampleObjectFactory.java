package com.webcode.config;


import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

/**
 * @ClassName ExampleObjectFactory.java
 * @Description TODO
 * @Author wushaopei
 * @Date 2020年4月17日
 * @Version 1.0
 */
//ExampleObjectFactory.java
public class ExampleObjectFactory extends DefaultObjectFactory {
	
	private static final long serialVersionUID = -3814827216040286292L;
	
	Logger log = Logger.getLogger(ExampleObjectFactory.class);
	
	@Override
	public <T> T create(Class<T>  type) {
		log.info("使用定制对象工厂的create方法构建单个对象");
	 return super.create(type);
	}
	
	@Override
	public <T> T create(Class<T>  type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		
		log.info("使用定制对象工厂的create方法构建列表对象");
		return super.create(type, constructorArgTypes, constructorArgs);
	}
	
	@Override
	public void setProperties(Properties properties) {
		log.info("定制属性： " + properties);
	 super.setProperties(properties);
	}
	
	public <T> boolean isCollection(Class<T> type) {
	 return Collection.class.isAssignableFrom(type);
	}
}