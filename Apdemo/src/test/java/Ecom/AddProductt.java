package Ecom;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddProductt extends BaseData {

	@Test
	public void addProduct() {
		String pathOfImage = System.getProperty("user.dir") + "\\APIimage.png";

		File file = new File(pathOfImage);

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		Response response = given()

				.header("Authorization", token)

				.param("productName", "kid Jeans")

				.param("productAddedBy", userId)

				.param("productCategory", "fashion")

				.param("productSubCategory", "shorts")

				.param("productPrice", "200")

				.param("productDescription", "jeans")

				.param("productFor", "kids")

				.multiPart("productImage", file)

				.when()

				.post("api/ecom/product/add-product")

				.then()

				.extract()

				.response();

		String responseData = response.asPrettyString();

		JsonPath jp = response.jsonPath();

		productId = jp.getString("productId");

		System.out.println(productId);

		System.out.println(responseData);

	}

}
