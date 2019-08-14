package com.qa.testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.qa.base.ReadAndWriteLogFile;
import com.qa.rest.demo.Base;
import com.qa.utillity.Log4jConfig;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC1_GET extends Base {
	
	String Testcase="TC_02";
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("beforeMethod");
	System.out.println(System.getProperty("currenttime"));	
		
	}
	
	@Test

	public void TC001_getEmployeeDetails()
	{
		logger.info("Test Case: TC001_getEmployeeDetails");
		//System.out.println(" I am executed first");
		logger.info("Test Case: Login");
		logger.info("Verify Populate Users Scenario");
		
		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		String host="/employees";
		
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET,host);
		String uri = RestAssured.baseURI+host;
		System.out.println("The URI is :" +uri);	
		logger.info("The Employee Details :" +response);
		String responseBody = response.getBody().asString();
		
		System.out.println("GetEmployee Details Response Body is :=>  " + responseBody);
		String statusLine = response.statusLine();
		logger.info("The StatusLine is :" +statusLine);
		
	//-------------------here	
	String res	=response.contentType();
	logger.fatal("The Response is :" +res);
	
	
	//logger.fatal("sds");
	
	String serverType=response.header("Server");
	logger.fatal("Server Type is:" + serverType);
	
	Headers head1 = response.headers();
//	logger.info("All the headers is:" + head1);
	
	   String bd =response.getHeader(responseBody);
	   
		logger.info("ResponseBody is:" + bd);
		
		int sc =response.getStatusCode();
		logger.fatal("Statuc Code is:" + sc);
	
	double t=response.time();
	logger.info("Time is:" + t);
	
	int len =response.contentType().length();
	logger.info("Content Length is:" + len);
	
	int lene =response.contentType().length();
	logger.warn("Content Length is:" + lene);
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

//@Test
public void verifyResponseBody()
{
	logger.info("Verifying Response Body");
	String responseBody = response.getBody().toString();
	//System.out.println("Response Body is :=>  " + responseBody);
	//String responseBody1 = response.getBody().asString();
	//logger.info("ResponseBody is :" +responseBody1);
	Assert.assertTrue(responseBody !=null);
	System.out.println("ResponseBody is :" +responseBody);
}

//@Test 
public void verfiyStatusLine()
{
	logger.info("Verify StatusLine");
	String statusLine = response.statusLine();
	logger.info("The StatusLine is :" +statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	
}

@AfterMethod
public  void generatereport() throws IOException, InterruptedException, FilloException {
	
	
	//ReadAndWriteLogFile.readAndWriteFile(Log4jConfig.getPropertyValue("log4j.appender.file.File"),Testcase);
	ReadAndWriteLogFile.readAndWriteFile(Log4jConfig.prop.getProperty("log4j.appender.file.File"),Testcase);
	
	
}


	/*
	 * public static void addsystemDate() throws IOException {
	 * 
	 * Properties prop = new Properties();
	 * 
	 * FileInputStream input=new FileInputStream(new
	 * File("G:\\Nagarajan\\Log Code\\RestfulTraining\\src\\main\\java\\log4j.properties"
	 * )); prop.load(input); prop.setProperty("log4j.appender.file.File",
	 * System.getProperty("currenttime")); prop.store(new FileOutputStream(new
	 * File("G:\\Nagarajan\\Log Code\\RestfulTraining\\src\\main\\java\\log4j.properties"
	 * )), "Heys"); }
	 */
}
