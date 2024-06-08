import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getuse {
@Test
	public void getuser01() {
		RestAssured.baseURI="https://reqres.in/";
	Response respoonse=given()
	.when()
	.get("api/users?page=2")
	.then()
	.extract()
	.response();
	String strres = respoonse.asPrettyString();
	System.out.println(strres);
	
JsonPath jp=	respoonse.jsonPath();
int totalvalue=jp.getInt("page");
	System.out.println(totalvalue);
	String emailValue = jp.getString("data[2].email");
System.out.println(emailValue);
int dataall=jp.getInt("data.size()");
System.out.println(dataall);
for (int i=0; i<dataall;i++) {
	String firstName =jp.getString("data["+i+"].email");
	System.out.println(firstName);

}

	}
	
}
