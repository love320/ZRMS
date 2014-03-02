package com.love320.mina.zrms.bean;

import java.util.Date;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

public class DataBag {
	
	/**
	 * 执行的方法名
	 */
	private String name = null;
	
	/**
	 * 参数信息
	 */
	private Map param ;
	
	private IoSession session;
	
	/**
	 * 数据进入时间
	 */
	private Date inDate;
	
	/**
	 * 数据出去时间
	 */
	private Date outDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map getParam() {
		return param;
	}

	public void setParam(Map param) {
		this.param = param;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public IoSession getSession() {
		return session;
	}

	public void setSession(IoSession session) {
		this.session = session;
	}
	
	
	
	
}
