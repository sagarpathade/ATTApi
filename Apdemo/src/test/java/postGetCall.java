import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class postGetCall {
	@Test
	public void createUser() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		Response response = given()

				.header("Content-Type", "application/json")

				.body("{\r\n" + "  \"id\": 0,\r\n" + "  \"username\": \"staginguser\",\r\n"
						+ "  \"firstName\": \"Tom\",\r\n" + "  \"lastName\": \"David\",\r\n"
						+ "  \"email\": \"tom.david@gmail.com\",\r\n" + "  \"password\": \"Test@1234\",\r\n"
						+ "  \"phone\": \"9876549610\",\r\n" + "  \"userStatus\": 0\r\n" + "}")

				.when()

				.post("/user")

				.then()

				.extract()

				.response();

		String resp = response.asPrettyString();

		System.out.println(resp);

	}

	@Test
	public void getUserData() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		Response response = given()

				.when()

				.get("/user/staginguser")

				.then()

				.extract()

				.response();

		String fetchResponse = response.asPrettyString();

		System.out.println(fetchResponse);

	}

}
