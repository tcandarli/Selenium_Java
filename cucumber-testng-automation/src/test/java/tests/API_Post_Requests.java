package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.Configuration;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

public class API_Post_Requests {
	
	/*
	POST SCENARIO:
		given content type is Json
		And Accept type is Json
		When I send POST request to 
		http://18.206.61.190:1000/ords/hr/regions
		with request body :
		{
			"region_id" : 5,
			"region_name" : "murodil's region"
		}
		Then status code should be 201
		And response body should match request body
	*/
	
	@Test
	public void postNewRegion () {
		
		String url = ConfigurationReader.getProperty("hrapp.baseresturl") + "/regions/";
		
		// String requestJson = "{\"region_id\" : 6,\"region_name\" : \"new region\"}";
		
		Map requestMap = new HashMap<>();
		requestMap.put("region_id", 55);
		requestMap.put("region_name", "new region");
		
		Response response =  given().accept(ContentType.JSON)
		.and().contentType(ContentType.JSON)
		.and().body(requestMap)
		.when().post(url);
		
		System.out.println(response.statusLine());
		response.prettyPrint();
		
		
	}
	
	

}
