package com.love320.mina.zrms.go;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Spring {
	
	private static BeanFactory factory = new FileSystemXmlApplicationContext("classpath:spring-mina.xml");
	
	public BeanFactory getSpring(){
		return factory;
	}
	
	public static Object getBean(String name){
		return factory.getBean(name);
	}
	
}
