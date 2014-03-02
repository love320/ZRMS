 /**
 * Copyright (c) 2010-& love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.mina.zrms.i18n;

import java.util.Locale;

/** 
 * @ClassName: MessageUtil 
 * @Description: TODO
 * @author love320.com
 * @date 2012-8-5 下午03:41:21 
 *  抽象信息处理工具
 *  工厂模式
 */
public abstract class AbstractMessageUtil {
	
	protected abstract MessageI18n MessageSourceFactoryMethod();
	
	public String message(String module, String code)
    {
        return message(module,code, null, Locale.getDefault());
    }
	
	public String message(String module, String code,Object[] arguments)
    {
        return message(module,code, arguments, Locale.getDefault());
    }
	
    /**
     * 通过错误码获取错误信息 包括模块码+错误码+错误描述
     * @param errCode 错误码
     * @param arguments 信息参数 
     * @param locale  国际化参数
     */
    public String message(String module, String code,Object[] arguments, Locale locale)
    {
    	MessageI18n messageSource = MessageSourceFactoryMethod();
        return information(module, code, messageSource.message(code, arguments, locale));
    }
    
	public String message(String module, String code,String errMessage)
    {
		MessageI18n messageSource = MessageSourceFactoryMethod();
		if(errMessage == null) {
			errMessage = messageSource.message(code, null, Locale.getDefault());
		}else{
			errMessage = messageSource.message(code, null, Locale.getDefault())+errMessage;
		}
		return information(module,code,errMessage);
    }
    
    //拼装信息
    private String information(String module, String code,String errMessage)
    {
        return module + Constant.CROSSBAND + code + Constant.COLON + errMessage;
    }
	
}
