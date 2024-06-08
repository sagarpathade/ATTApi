import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class post {

	@Test
	public void createUser() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		Response res = given().header("Content-Type", "application/json")
				.body("{\r\n" + "  \"id\": 0,\r\n" + "  \"username\": \"newtestuser\",\r\n"
						+ "  \"firstName\": \"Eder\",\r\n" + "  \"lastName\": \"Mejia\",\r\n"
						+ "  \"email\": \"eder.mejia@gmail.com\",\r\n" + "  \"password\": \"Test@1234\",\r\n"
						+ "  \"phone\": \"9876543610\",\r\n" + "  \"userStatus\": 0\r\n" + "}")
				.when().post("/user").then().extract().response();

		System.out.println(res.asPrettyString());

	}
	
	@Test
	public void getUser() {
	    RestAssured.baseURI = "https://petstore.swagger.io/v2";
	    Response res1 = given().pathParam("username", "newtestuser")
	                          .when().get("/user/{username}")
	                          .then().extract().response();
	    System.out.println(res1.asPrettyString());
	}

	}

