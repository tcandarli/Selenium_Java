package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import io.restassured.http.ContentType;

public class API_JsonPath {

	/*
	 * Given Accept type is JSON 
	 * When I send a GET request to REST URL:http://18.206.61.190:1000/ords/hr/regions 
	 * Then status code is 200 
	 * And Response content should be json 
	 * And 4 regions should be returned 
	 * And Europe is one of the region names
	 */
	
	// validation of multiple values in response json
	@Test
	public void testItemsCountFromResponseBody() {
		given().accept(ContentType.JSON)
		.when().get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/regions")
		.then().assertThat().statusCode(200)
		.and().assertThat().contentType(ContentType.JSON)
		.and().assertThat().body("items.region_id", hasSize(4))
		.and().assertThat().body("items.region_name", hasItem("Europe"));
	}
	
	/*
	 * Given Accept type is Json
	 * And Params are limit 100
	 * When I send get request to 
	 * http://18.206.61.190:1000/ords/hr/employees
	 * Then status code is 200 
	 * And Response content should be json 
	 * And 100 employees data should be in json reponse body
	 */
	
	@Test
	public void testWithQueryParameterAndList() {
		given().accept(ContentType.JSON)
		.and().params("limit", 100)
		.when().get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees")
		.then().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().assertThat().body("items.employee_id", hasSize(100));
		
		
	}

}
