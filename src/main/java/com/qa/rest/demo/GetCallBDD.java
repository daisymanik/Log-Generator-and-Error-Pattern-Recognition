package com.qa.rest.demo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;    //Static imports to get No.of options After given
import static org.hamcrest.Matchers.*;        //Static imports


public class GetCallBDD {
	
	@Test
	
	public void testCircuits()
	{
		//given()
		//when()
		//then()
		//assert()
		given().
		when().
		get("http://ergast.com/api/f1/2017/circuits.json").
		then().
		assertThat().
		statusCode(200).
		and().
		
	body("MRData.CircuitTable.Circuits.circuitId",hasSize(20)).
	and().
	header("content-length",equalTo("4551"));
	}

}
