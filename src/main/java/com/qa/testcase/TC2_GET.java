package com.qa.testcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.rest.demo.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2_GET extends Base {
	
	
	@BeforeClass

	public void setup()

	{
	System.out.println(System.getProperty("log4j.appender.file.layout"));
	logger=Logger.getLogger("Verify");
	PropertyConfigurator.configure("C:\\Log_Source_code\\RestfulTraining\\src\\main\\java\\log4j.properties");
	//FileInputStream input =new FileInputStream(System.getProperty("user.dir")+"/src/main/java/log4j.properties");
	/*logger.setLevel(Level.DEBUG);*/
	//logger.setLevel(Level.INFO);
		
	//C:\Users\madhavaraon\SeleniumTest\RestfulTraining\src\main\java\log4j.properties
	}
	
	@Test

	public void TC002_getSpecificEmployeeDetails()
	{
		
		logger.info("Test Case: TC002_getSpecificEmployeeDetails");
		logger.info("Test Case: Logout");
		
		logger.info("Populate Perticular Employee Details");
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		String host="/employee/13253";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET,host);
		String uri = RestAssured.baseURI+host;
		System.out.println("The URI is :" +uri);
		logger.error("The Specific Employee Details are :" +response);
		System.out.println("The Specific Employee Details are :" + response);
		String responseBody = response.getBody().asString();
		System.out.println("Get Specific Employee Details Response Body is :=>  " + responseBody);
		logger.error("Get Specific Employee Details Response Body is :=>  " + responseBody);	
	}

}
