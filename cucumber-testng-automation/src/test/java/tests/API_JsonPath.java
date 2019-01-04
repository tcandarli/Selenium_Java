package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

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
	
	/*
	 * Given Accept type is Json
	 * And Params are limit=100
	 * And path param is 110
	 * When I send get request to 
	 * http://18.206.61.190:1000/ords/hr/employee 
	 * Then status code is 200 
	 * And Response content should be json 
	 * And following data should be returned:
	 * "employee_id": 110,
	    "first_name": "John",
	    "last_name": "Chen",
	    "email": "JCHEN",
	 */
	
	@Test
	public void testWithPathParameter() {
		
		given().accept(ContentType.JSON)
		.and().params("limit", 100)
		.and().pathParams("employee_id", 110)
		.when().get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/{employee_id}")
		.then().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().assertThat().body("employee_id", equalTo(110),
								 "first_name", equalTo("John"),
								 "last_name", equalTo("Chen"),
								 "email", equalTo("JCHEN"));
													
	}
	
	/*
	 * Given Accept type is Json
	 * And Params are limit=100
	 * When I send get request to 
	 * http://18.206.61.190:1000/ords/hr/employee 
	 * Then status code is 200 
	 * And Response content should be json 
	 * all employee ids should be returned
	 */
	
	
	@Test
	public void testWithJsonPath() {
		
		Map<String, Integer> rParamMap = new HashMap<>();
		rParamMap.put("limit", 100);
		
		Response response =  given().accept(ContentType.JSON)  // header
							.and().params(rParamMap) // query param/request param
							.and().pathParams("employee_id", 110) // path param
							.when().get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/{employee_id}");
		
		JsonPath json = response.jsonPath();  // get json body and assign to jsonPath object
		System.out.println(json.getInt("employee_id")); 
		System.out.println(json.getString("last_name")); 
		System.out.println(json.getString("job_id")); 
		System.out.println(json.getString("salary")); 	
		
	}
	

}
