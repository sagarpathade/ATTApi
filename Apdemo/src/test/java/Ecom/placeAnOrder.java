package Ecom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class placeAnOrder extends BaseData {
	@Test
	public void placeAnOrder() {

		{

			RestAssured.baseURI = "https://rahulshettyacademy.com";

			Response response = given()

					.header("Content-Type", "application/json")

					.header("Authorization", token)

					.body("{\"orders\": [\r\n" + "        {\r\n" + "        \"country\": \"India\", \r\n"
							+ "        \"productOrderedId\" : \"" + productId + "\"\r\n" + "        }\r\n" + "    ]\r\n"
							+ "}")
					.when()

					.post("api/ecom/order/create-order")

					.then()

					.extract()

					.response();

			String strResp = response.asPrettyString();

			System.out.println(strResp);
		}
	}
}
