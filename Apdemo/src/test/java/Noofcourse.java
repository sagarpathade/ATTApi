import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Noofcourse {
	@Test
	public void courseall() {
		String json = "{\r\n" + "\"dashboard\": {\r\n" + "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n" + "},\r\n" + "\"courses\": [\r\n" + "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n" + "\"price\": 50,\r\n" + "\"copies\": 6\r\n" + "},\r\n"
				+ "{\r\n" + "\"title\": \"Cypress\",\r\n" + "\"price\": 40,\r\n" + "\"copies\": 4\r\n" + "},\r\n"
				+ "{\r\n" + "\"title\": \"RPA\",\r\n" + "\"price\": 45,\r\n" + "\"copies\": 10\r\n" + "}\r\n" + "]\r\n"
				+ "}";

		JsonPath jp = new JsonPath(json);
	//	1. Print No of courses returned by API
		int coursesize = jp.getInt("courses.size()");
		System.out.println(coursesize);
//2. Print Purchase Amount
		int amount = jp.getInt("dashboard.purchaseAmount");
		System.out.println(amount);

		//3. Print Title of the first course
		String titleOfFirstCourse = jp.getString("courses[0].title");
		System.out.println(titleOfFirstCourse);

//4. Print All course titles and their respective Prices

		for (int i = 0; i < coursesize; i++) {
			String coursetitle = jp.getString("courses[" + i + "].title");
			System.out.println(coursetitle);
		}
//5. Print no of copies sold by RPA Course
		int copies = jp.getInt("courses[2].copies");
		System.out.println(copies);
//6. Verify if Sum of all Course prices matches with Purchase Amount
		int totalprice = 0;
		for (int i = 0; i < coursesize; i++) {
			int price = jp.getInt("courses[" + i + "].price");
			int copies1 = jp.getInt("courses[" + i + "].copies");
			totalprice = totalprice + (price * copies1);
		}
		System.out.println(totalprice);

		Assert.assertEquals(totalprice, amount);
		if (totalprice == amount) {
			System.out.println("Sum of all Course prices matches with Purchase Amount " + amount);

		} else {
			System.out.println("not equal too amount 910");
		}

	}
}
