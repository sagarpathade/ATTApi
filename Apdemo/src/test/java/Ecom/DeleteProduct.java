package Ecom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class DeleteProduct extends BaseData {
	

	
	@Test
	public void deleteAProduct()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Response resp = given()
		
		.header("Authorization", token)
		
		.when()
		
		.delete("api/ecom/product/delete-product/"+productId)
		
		.then()
		
		.extract()
		
		.response();
		
		String strResp = resp.asPrettyString();
		
		System.out.println(strResp);
		
		
		
	}

}


