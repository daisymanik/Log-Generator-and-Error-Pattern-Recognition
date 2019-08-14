package com.qa.testcase;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Authentication {
	
	public class premitive
	{
		@Test
		public void preauth()
		{
			RestAssured.baseURI="http://restapi.demoqa.com";
			String host = "/authentication/CheckForAuthentication";
			RequestSpecification httprequest = RestAssured.given();
			httprequest.auth().preemptive().basic("ToolsQA","TestPassword");
			Response resp=httprequest.request(Method.GET,host);
			//response=httpreq.request(Method.GET,"/authentication/CheckForAuthentication");
			String uri= RestAssured.baseURI+host;
			System.out.println("The URI is :" + uri);
			int status_code =resp.getStatusCode();
			System.out.println("The satus code is : "+status_code);
			Assert.assertEquals(status_code, 200);
			
		}
	}

}
