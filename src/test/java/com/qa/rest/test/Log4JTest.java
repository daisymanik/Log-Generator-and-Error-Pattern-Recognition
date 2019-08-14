package com.qa.rest.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Log4JTest {
	final static Logger logger = Logger.getLogger(Log4JTest.class);
static
	{
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
    System.setProperty("currenttime", dateFormat.format(new Date()));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Log4JTest obj = new Log4JTest();
		
		obj.runMe("mkyong");

	}
	
private void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
	}
	

}
