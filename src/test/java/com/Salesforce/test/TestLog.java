package com.Salesforce.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog {

	public static void main(String[] args) {
		
		Logger mylog=LogManager.getLogger(TestLog.class);
		
		
		mylog.info("chrome browser has started");
		mylog.info("application has opned in the broswer");
		
		try {
			int res=30/0;
		}
		catch (ArithmeticException e) {
			mylog.error("cannot divide by 0",e);
		}
		mylog.debug("debug information");
		mylog.fatal("fatal information");
		mylog.info("abrowser closed");
	}

}
