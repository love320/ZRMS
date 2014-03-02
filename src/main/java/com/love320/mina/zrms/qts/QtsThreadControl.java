package com.love320.mina.zrms.qts;

import com.love320.mina.zrms.utils.SpringBeanFactoryUtils;

public class QtsThreadControl {
	
	private SpringBeanFactoryUtils spring;
	
	public static int num = 5; //线程数

	public void init(){
		for(int i = 1 ;i<=num;i++){
			QtsThread thread = new QtsThread(spring);
			thread.start();
		}
	}
	
	public void destroy(){
		
	}

	public void setSpring(SpringBeanFactoryUtils spring) {
		this.spring = spring;
	}
	
	
	
}
