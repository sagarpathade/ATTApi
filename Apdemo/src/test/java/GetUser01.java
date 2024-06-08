import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetUser01 {

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
	
	int stsCode = response.statusCode();// fetching the status code
	
	System.out.println(stsCode);
	
	Assert.assertEquals(stsCode, 200);
	
	long timeValue = response.getTime();
	
	System.out.println(timeValue);// time taken to complete transaction
	
	Headers allHeader = response.headers();
	
	List<Header> headerList = allHeader.asList();
	
	
	System.out.println(headerList);// To print all the headers at one go
	System.out.println("*****************************");

	
	String valueOfContentType = response.getHeader("Content-Type"); // to fetch the specific value of header
	
	System.out.println(valueOfContentType);
	
	System.out.println("*****************************");
	
	for(Header hl :headerList)
	{
		System.out.println(hl);
	}
	
	}}

