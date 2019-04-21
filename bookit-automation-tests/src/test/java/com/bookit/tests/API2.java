package com.bookit.tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class API2 {

	/*
	 * Given Accept type is JSON When I send a Get request to url/employees Then
	 * status code is 200 And response content should be JSON and 100 employees data
	 * should be in JSON response body
	 */

	String baseurl = "http://34.203.227.227:1000/ords/hr";

	@Test
	public void employeesWithParams() {

		given().accept(ContentType.JSON).and().params("limit", 100).and().when().get(baseurl + "/employees").then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("items.employeed_id", Matchers.hasSize(100));

	}

	/*
	 * Given Accept type is JSON When I send a Get request to url/employees Then
	 * status code is 200 And response content should be JSON and first_name must be
	 * "John" and email must be "JCHEN"
	 */

	@Test
	public void testWithPathParams() {

		given().accept(ContentType.JSON).and().pathParam("id", 110).when().get(baseurl + "/employees/{id}").then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("first_name", Matchers.equalTo("John"), "email", Matchers.equalTo("JCHEN"));

	}

	/*
	 * Given Accept type is JSON When I send a Get request to url/employees/110 Then
	 * status code is 200 And response content should be json and first_name must be
	 * "John" and email must be "JCHEN"
	 */

	@Test
	public void testWithJsonPath() {

		Response response = given().accept(ContentType.JSON).and().pathParam("id", 110).when()
				.get(baseurl + "/employees/{id}");

		// get json body and assign to JsonPath object
		JsonPath json = response.jsonPath();

		String actualFirstname = json.getString("first_name");
		String expectedFirstname = "John";

		String actualEmail = json.getString("email");
		String expectedEmail = "JCHEN";

		assertEquals(actualFirstname, expectedFirstname);
		assertEquals(actualEmail, expectedEmail);

	}

	/*
	 * Given Accept type is JSON When I send a Get request to url/employees/ Then
	 * status code is 200 And response content should be json all data should be
	 * returned
	 */

	@Test
	public void testJsonPathWithList() {

		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("limit", 100);

		Response response = given().accept(ContentType.JSON).and().params(paramMap).when().get(baseurl + "/employees/");

		JsonPath json = response.jsonPath();

		// verify status code
		assertEquals(response.statusCode(), 200);

		// get all employee ids and assign to one list
		List<Integer> empIDs = json.getList("items.employee_id");

		// verify we got 100 employees as a response
		assertEquals(empIDs.size(), 100);

		// get all emails and assign one list and print them
		List<String> emails = json.getList("items.email");
		System.out.println(emails);

		// get all emp id that are greater than 150
		List<Integer> empID2s = json.getList("items.findAll{it.employee_id > 150}.employee_id");
		System.out.println(empID2s);

		// get all employees lastname , whose salary greater than 7000
		List<String> lastnames7000 = json.getList("items.findAll{it.salary > 7000}.last_name");
		System.out.println(lastnames7000);
		System.out.println(lastnames7000.size());
	}
	
	/*Given Accept type is JSON
	 * When I send a Get request to url/employees/140
	 * Then status code is 200
	 * And response content should be json
	 * all data should be returned
	 */
  
  @Test
  public void testWithJSONtoMap() {
	  
	  Response response = given().accept(ContentType.JSON)
			  .and().when().get(baseurl+"/employees/140");
	  
	  //we convert JSON result to hasmap data structure
	    Map<String,Object> jsonmap = response.as(HashMap.class);
	    
	    //get firstname value from map 
	  System.out.println(jsonmap.get("first_name"));
	  //get salary value from map
	  System.out.println(jsonmap.get("salary"));
	  
	  String actualFirstName = (String) jsonmap.get("first_name");
	  
	  assertEquals(actualFirstName, "Joshua");	
	  
  }
  
  
  @Test
  public void convertJSONtoListofMaps() {
	  
	  Response response = given().accept(ContentType.JSON)
			  .when().get(baseurl+"/departments");
	  
	  JsonPath json = response.jsonPath();
	 
	  //we are getting JSON response and assign to list of maps 
	 List<Map> result = json.getList("items",Map.class);
	 
	 String actualDepartmentName = (String) result.get(4).get("department_name");
	 String expectedDepartmentName = "Shipping";
	 
	 //compare expected and actual department names
	 assertEquals(actualDepartmentName, expectedDepartmentName);
	 
	 //verify department id 
	
	 //Umid's code 
	 int actDepID= (int) result.get(4).get("department_id");
	 int ExDepID= 50;
	 assertEquals(actDepID,ExDepID);
	 
	 
  }
  
  
  //TASK
  /*Given Content type is JSON
   * And Limit is 10
   * When I send the GET request to url/regions
   * the status code must be 200
   * The I should see following data
   * 		1 Europe
   * 		2 Americas
   * 		3 Asia
   * 		4 Middle East and Africa
   */
  
  @Test 
  public void regionTaskV1() {
	  
	  given().accept(ContentType.JSON).and().params("limit",10)
	  .when().get(baseurl+"/regions").then().statusCode(200).and()
	  .assertThat().body("items.region_name", Matchers.hasItems("Europe","Americas","Asia","Middle East and Africa"));		  
	  
  }
  
  @Test
  public void regionTaskV2() {
	  
	  Response response = given().accept(ContentType.JSON).and().params("limit",10)
			  .when().get(baseurl+"/regions");
	  
	  JsonPath json = response.jsonPath();
	  
	  //status code check
	  assertEquals(response.statusCode(), 200);
	 
	  //region verify
	  assertEquals(json.getString("items[0].region_name"), "Europe");
	  assertEquals(json.getString("items[1].region_name"), "Americas");
	  assertEquals(json.getString("items[2].region_name"), "Asia");
	  assertEquals(json.getString("items[3].region_name"), "Middle East and Africa");  
	  
  }
   
  @Test
  public void regionTaskV3() {
	  Response response = given().accept(ContentType.JSON).and().params("limit",10)
			  .when().get(baseurl+"/regions");
	  
	  JsonPath json = response.jsonPath();
	  
	  //status code check
	  assertEquals(response.statusCode(), 200);
	 
	  //JSON into list of maps
	  List<Map> result=json.getList("items",Map.class);
	  
	 assertEquals(result.get(0).get("region_name"), "Europe");
	 assertEquals(result.get(1).get("region_name"), "Americas");
	 assertEquals(result.get(2).get("region_name"), "Asia");
	 assertEquals(result.get(3).get("region_name"), "Middle East and Africa");	  
	  
  }
  
}
