package com.qa.utillity;

import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;

public class Log4jConfig {

	public static Properties prop = new Properties();
	public static String filepath;
	static {
		try {
			filepath = System.getProperty("ResSuite");
			if (filepath == null) {
				filepath = "C:\\Log_Source_code\\RestfulTraining\\src\\main\\java\\log4j.properties";
				
				try{
					//filepath = filepath + File.separator + "log4j.properties";
					prop.load(new FileInputStream(filepath));
					/*InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath);
					prop.load(resourceStream);*/
				} catch (Exception E) {
					Assert.fail(E.getMessage());
				}
			} else {
				System.out.println(filepath);
				filepath = filepath + File.separator + "log4j.properties";
				prop.load(new FileInputStream(filepath));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

}
