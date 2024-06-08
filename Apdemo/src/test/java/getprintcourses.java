import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//Queries
//1. Print No of courses returned by API
//2. Print Purchase Amount
public class getprintcourses {
@Test
	public void getcourse() {
		
		RestAssured.baseURI="https://www.abc.com";
		
Response res=given().when().get().then().extract().response();

System.out.println(res.asPrettyString());
String rep = res.asPrettyString();
	JsonPath jo = new JsonPath(rep);
	
int coursenumber = jo.getInt("courses.size()");
System.out.println(coursenumber);
	}
}
