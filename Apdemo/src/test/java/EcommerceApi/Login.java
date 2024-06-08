package EcommerceApi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Login extends BaseData {

	

		@Test
		public void loginToApp()
		{
			RestAssured.baseURI = "https://rahulshettyacademy.com";
			
			Response response = given()
			
			.header("Content-Type", "application/json")
			
					.body("{\r\n" + "    \"userEmail\": \"sagarpathadeqa@gmail.com\",\r\n"
							+ "    \"userPassword\": \"Test@1234\"\r\n" + "}")
			
			.when()
			
			.post("/api/ecom/auth/login")
			
			.then()
			
			.extract()
			
			.response();
			
			String strResp = response.asPrettyString();
			
			System.out.println(strResp);
			
			JsonPath jp = response.jsonPath();
			
	String tokenValue = jp.getString("token");

	System.out.println(tokenValue);
	
	userId =jp.get("userId");
			
			
			
		}




}
