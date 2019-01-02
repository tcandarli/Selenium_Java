package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class RestAPIGetRequests {

	/*
	 * When I send a GET request to REST Url
	 * http://18.206.61.190:1000/ords/hr/employees Then response status should be 200
	 * 
	 */
	@Test
	public void simpleGet() {

		when().get("http://18.206.61.190:1000/ords/hr/employees").then().statusCode(200);

	}
	
	@Test
	public void printResponse() {
		
	}
}
