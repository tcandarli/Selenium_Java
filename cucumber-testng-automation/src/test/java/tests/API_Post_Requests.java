package tests;

import static io.restassured.RestAssured.*;

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
	
	

}
