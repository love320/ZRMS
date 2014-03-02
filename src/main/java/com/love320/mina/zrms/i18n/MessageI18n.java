 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.mina.zrms.i18n;

import java.util.Locale;

/** 
 * @ClassName: MessageSource 
 * @Description: TODO
 * @author love320.com
 * @date 2012-8-5 下午03:01:07 
 *  获取国际信息文件
 */
public interface MessageI18n {
	
	public String message(String key);//通过 key 获取配置文件信息(默认配置文件)
	
	public String message(String key, Locale locale);//通过 key 获取配置文件信息(指定国际配置文件)
	
	public String message(String key, Locale locale,Object... arguments);//通过 key 获取配置文件信息(指定国际配置文件)
	
	public String message(String key,Object... arguments);//通过 key 获取配置文件信息并自动格式化信息(默认配置文件)
	
	//public String message(String key, Object[] arguments);//通过 key 获取配置文件信息并自动格式化信息(默认配置文件)
	
	public String message(String key, Object[] arguments, Locale locale);//通过 key 获取配置文件信息并自动格式化信息(指定国际配置文件)
	
}
