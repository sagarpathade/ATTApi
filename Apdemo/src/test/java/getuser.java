import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getuser {
	@Test
	public void getUser()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		Response response = given()
		
							.when()
		
							.get("api/users?page=2")
		
							.then()
		
							.extract()
		
							.response();
		
	String strResponse	= response.asPrettyString();
	
	System.out.println(strResponse);
	
	JsonPath jp = response.jsonPath();
	
	int totalValue = jp.getInt("total");
	
	System.out.println(totalValue);
	
	String emailValue = jp.getString("data[1].email");
	
	System.out.println(emailValue);
		
	int numberOfElements = jp.getInt("data.size()");// to get the size of array
	
	System.out.println(numberOfElements);
	
	for(int i=0; i<numberOfElements; i++)
	{
		String firstName = jp.getString("data["+i+"].first_name");
		
		System.out.println(firstName);
	}
	
		
		
		
	}
}
