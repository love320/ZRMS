package com.love320.mina.zrms.qts;

import java.util.LinkedList;
import java.util.Queue;

public class QtsQueue{
	
	private static Queue<Object> obs = new LinkedList<Object>(); 
	
	public static Object getO(){
		int num = obs.size();
		if(num <= 0) return null;
		synchronized (obs) {
			return obs.poll();
		}
	}
	
	public static void setO(Object ob){
		synchronized (obs) {
			obs.offer(ob);
		}
	}
	
	public static boolean isEmpty(){
		return obs.isEmpty();
	}

}
