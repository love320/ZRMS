 /**
 * Copyright (c) 2010-& love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */

package com.love320.mina.zrms;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/** 
 * @ClassName: ServerHandler 
 * @Description: 服务主处理器
 * @author love320.com
 * @date 2014-3-2 下午08:15:18 
 *  
 */
public class ServerHandler extends IoHandlerAdapter {

	/**
	 * 设置为闲置的以秒为单位指定类型的空闲时间。
	 */
	private final int IDLE = 300;
	
	/**
	 * 日志记录
	 */
	private final Logger log = Logger.getLogger(ServerHandler.class.getName());
	 
	/**
	 * session集合
	 */
	public static Set<IoSession> sessions = Collections .synchronizedSet(new HashSet<IoSession>());
	
	/**
	 * 空构造
	 */
	public ServerHandler(){
		
	}

	/**
	 * 捕获到异常时
	 */
	@Override
    public void exceptionCaught(IoSession session, Throwable cause)throws Exception {
		SessionContext.remove(session);//移出
        session.close(false);//关闭会话
        log.debug("session occured exception, so close it." + cause.getMessage());//打印异常信息
    }
	
	/**
	 * 创建会话时
	 */
	@Override
	public void sessionCreated(IoSession session) {
		log.debug("remote client ["+session.getRemoteAddress().toString()+"] connected.");
		//session.write("Welcome");
		sessions.add(session);//添加会话
	}
	
	/**
	 * 收到的消息时
	 */
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {

		log.debug("客户端"+((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress()+"连接成功！");

		Date date = new Date();
		session.write(date.toString());
		session.setAttribute(session.getRemoteAddress(), message);
		
		session.setAttribute("type", message);
		String remoteAddress = ((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress();
		session.setAttribute("ip", remoteAddress);
		
		//执行....
		
	}

	/**
	 * 会话关闭时
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		 log.debug("sessionClosed.");
		 SessionContext.remove(session);//移出
		 sessions.remove(session);//移出
	}

	/**
	 * 空闲会话
	 */
	@Override
	public void sessionIdle(IoSession session, IdleStatus status)throws Exception {
		SessionContext.remove(session);//移出
		log.debug("session idle, so disconnecting......");
        session.close(false);//关闭会话
        log.debug("disconnected.");
	}
	
	/**
	 * 发送消息时
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		 log.debug("messageSent.");
    }
	
	/**
	 * 会话打开时
	 */
	@Override
    public void sessionOpened(IoSession session) throws Exception {
		log.debug("sessionOpened.");
        session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDLE);//设置空闲
    }

}
