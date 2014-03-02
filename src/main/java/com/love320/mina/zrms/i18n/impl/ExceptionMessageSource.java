 /**
 * Copyright (c) 2010-& love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.mina.zrms.i18n.impl;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.love320.mina.zrms.i18n.Constant;
import com.love320.mina.zrms.i18n.MessageSource;


/** 
 * @ClassName: ExceptionMessageSource 
 * @Description: TODO
 * @author love320.com
 * @date 2012-8-5 下午03:09:09 
 *  
 */
public class ExceptionMessageSource implements MessageSource {
	
	private String name = Constant.ERROR_FILE;//信息文件

	@Override
	public String message(String key) {
		return message(key,Locale.getDefault());
	}

	@Override
	public String message(String key, Locale locale) {
		return message(key,null,locale);
	}
	
	@Override
	public String message(String key, Locale locale, Object... arguments) {
		return message(key,arguments,locale);
	}

	@Override
	public String message(String key, Object... arguments) {
		return message(key,arguments,Locale.getDefault());
	}

	@Override
	public String message(String key, Object[] arguments, Locale locale) {
		
		ResourceBundle rb = ResourceBundle.getBundle(name, locale);
		String message = rb.getString(key);
		if((arguments != null) && (arguments.length > 0)){
			message = MessageFormat.format(message, arguments);
			
		}
		return message == null ? key : message;
	}


}
