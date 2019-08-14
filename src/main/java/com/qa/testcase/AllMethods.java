package com.qa.testcase;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import com.qa.rest.demo.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AllMethods
{
	public static RequestSpecification httpreq ;
	public static Response response;
	public static Logger logger;
	
	@Test
	
	public void verifyAll()
	{
	
	//logger.info("------------- : Verify All methods Scenario : -----------------------");
	RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
	String resource="/employees";
	RequestSpecification httpreq = RestAssured.given();
	Response response = httpreq.request(Method.GET,resource);
	String uri = RestAssured.baseURI+resource;
	System.out.println("The URI is :" +uri);
	logger.info("The Employee Details :" +response);
	//http://restapi.demoqa.com/utilities/weather/city/Hyderabad
	}
	
/*	public static void main(String args[])
	{
		AllMethods  all = new AllMethods();
		
		all.verifyURL();
	} */
}

