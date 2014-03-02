package com.love320.mina.zrms;

import com.love320.mina.zrms.i18n.MessageI18n;
import com.love320.mina.zrms.i18n.impl.ExceptionMessageSource;

import junit.framework.TestCase;

public class I18nTest extends TestCase {
	
	public void testMS(){
		 MessageI18n ms = new ExceptionMessageSource();
		 System.out.println(ms.message("10002","zzzz"));
	}

}
