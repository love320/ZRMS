 /**
 * Copyright (c) 2010-& love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */

package com.love320.mina.zrms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.mina.core.session.IoSession;

/** 
 * @ClassName: SessionContext 
 * @Description: Session容器
 * @author love320.com
 * @date 2014-3-2 下午08:15:18 
 *  
 */
public class SessionContext {
	
	private static Map<String,IoSession> sessionMap = new HashMap<String,IoSession>();
	
	public static void add(String key,IoSession session){
		synchronized (sessionMap) {
			sessionMap.put(key,session);
		}
	}
	
	public static IoSession get(String key){
		return sessionMap.get(key);
	}
	
	public static String[] all(){
		Set<String> keys= sessionMap.keySet();
		String[] strs = new String[keys.size()];
		int i = 0;
		for(String key : keys ){
			strs[i] =  key;
			i++;
		}
		return strs;
	}
	
	public static void remove(IoSession session){
		IoSession removeSession = null;
		String removekey = null;
		Set<String> keys= sessionMap.keySet();
		for(String key : keys ){
			Object obj = sessionMap.get(key);
			if(obj instanceof String[]){
				removeSession = ((IoSession[])obj)[0];
			}else{
				removeSession = (IoSession) obj;
			}
			if(removeSession == session) removekey = key;
		}
		
		if(removekey != null){
			synchronized (sessionMap) {
				System.out.println("removekey:"+removekey);
				sessionMap.remove(removekey);
			}
		}
		
	}

}
