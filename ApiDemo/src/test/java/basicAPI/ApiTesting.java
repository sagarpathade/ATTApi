package basicAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTesting {

	@Test
	public void getListOfUser()
	{
	RestAssured.baseURI = "https://reqres.in/";
		
	Response apiResponse = given()
	
							.when()
	
							.get("api/users/2")
	
							.then()
	
							.extract()
	
							.response();
	
	System.out.println(apiResponse);
	
	String actualResponse = apiResponse.asPrettyString();
	
	System.out.println(actualResponse);
	
	
	
	
		
	}


}
