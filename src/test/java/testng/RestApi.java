package testng;
import io.restassured.path.json.*;
import pojobody.Body;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import commonPkg.ResuseMethod;
import commonPkg.Url;
import io.restassured.RestAssured;

public class RestApi {
	public static void main(String[] args) {
		RestAssured.baseURI = Url.getUrl();

		// get
		String responseGetBody = given().log().all().when().get(Url.get()).then().log().all().extract().response()
				.asString();
		System.out.print(responseGetBody);
		JsonPath jsp = ResuseMethod.rawToJson(responseGetBody);
		String name = jsp.getString("data[0].first_name");
		System.out.print(" First Name " + name);
		assertEquals(name, "Michael");

		// post
		String responsePostBody = given().header("Content-Type", "application/json").body(Body.payLoad()).when()
				.post(Url.post()).then().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js = ResuseMethod.rawToJson(responsePostBody);
		
		String fname = js.getString("name");
		System.out.print("  Name " + fname);
		assertEquals(fname, "morpheus");

		// Dynamic post
		String responseDynamicPostBody = given().header("Content-Type", "application/json")
				.body(Body.dynamicPayLoad("shyam", "allRounder")).when().post(Url.post()).then().assertThat()
				.statusCode(201).extract().response().asString();
		JsonPath jsd = ResuseMethod.rawToJson(responseDynamicPostBody);

		String firstName = jsd.getString("name");
		System.out.print("dynamic  Name " + firstName);
		assertEquals(firstName, "shyam");
	}
	
}
