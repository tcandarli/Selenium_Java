package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.jsoup.Connection.Response;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.*;

import static io.restassured.RestAssured.*;

public class RestAPIGetRequests {

	/*
	 * When I send a GET request to REST Url
	 * http://18.206.61.190:1000/ords/hr/employees Then response status should be
	 * 200
	 * 
	 */
	@Test
	public void simpleGet() {

		when().get("http://18.206.61.190:1000/ords/hr/employees").then().statusCode(200);

	}

	/*
	 * When I send a GET request to REST Url
	 * http://18.206.61.190:1000/ords/hr/countries Then I should see JSON Response
	 */

	@Test
	public void printResponse() {

		when().get("http://18.206.61.190:1000/ords/hr/countries").body().prettyPrint();

	}

	/*
	 * When I send a GET request to REST Api Url
	 * http://18.206.61.190:1000/ords/hr/countries/US And Accept type is
	 * "application/json" Then response status code should be 200
	 */

	@Test
	public void getWithHeaders() {

		with().accept(ContentType.JSON) // accept - application/json
				.when().get("http://18.206.61.190:1000/ords/hr/countries/US").then().statusCode(200);

	}

	/*
	 * When I send a GET request to REST URL:
	 * http://18.206.61.190:1000/ords/hr/employees/1234 Then status code is 404 And
	 * Response body error message is "Not Found"
	 */

	@Test
	public void negativeGet() {
		// when().get("http://18.206.61.190:1000/ords/hr/employees/1234").then().statusCode(404);
		// // First way

		io.restassured.response.Response response = when().get("http://18.206.61.190:1000/ords/hr/employees/1234");
		assertEquals(response.statusCode(), 404);
		assertTrue(response.asString().contains("Not Found"));
		response.prettyPrint();

	}

	/*
	 * When I send a GET request to REST URL:
	 * http://18.206.61.190:1000/ords/hr/employees/100 And Accept type is json Then
	 * status code is 200 And Response content should be json
	 * 
	 * WITH,WHEN,GET,ASSERTTHAT,ACCEPT,CONTENTTYPE
	 */

	@Test
	public void verifyContentTypeWithAssertThat() {

		String url = "http://18.206.61.190:1000/ords/hr/employees/100";

		given().accept(ContentType.JSON).when().get(url).then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON);

	}

}
