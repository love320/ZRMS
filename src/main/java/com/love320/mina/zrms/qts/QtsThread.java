package com.love320.mina.zrms.qts;

import com.love320.mina.zrms.bean.DataBag;
import com.love320.mina.zrms.command.ICommand;
import com.love320.mina.zrms.utils.SpringBeanFactoryUtils;

public class QtsThread extends java.lang.Thread {
	
	private SpringBeanFactoryUtils spring;
	
	public QtsThread(SpringBeanFactoryUtils spring){
		this.spring = spring;
	}

	@Override
	public void run() {
		for (;;) {
			try {
				Object obj = QtsQueue.getO();
				if(obj != null){
					DataBag bag = (DataBag)obj;
					ICommand command = (ICommand) spring.getBean(bag.getName());
					command.execute(bag.getSession(), bag);
				}else{
					sleep(1000*3);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//
		
	}
	

}
