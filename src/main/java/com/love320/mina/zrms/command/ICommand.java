package com.love320.mina.zrms.command;

import org.apache.mina.core.session.IoSession;

public interface ICommand {
	/**
	 * 处理接收到的消息
	 * @param sessionContext Session容器
	 * @param session 消息发送者的Session
	 * @param message 消息
	 * @return
	 */
	Object execute(IoSession session, Object message);
	/**
	 * 对消息进行解码，便于后面进一步处理
	 * @param message 消息
	 * @return
	 */
	Object decodeMessage(Object message);
	
}
