package testng;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import commonPkg.ResuseMethod;
import commonPkg.Url;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojobody.PojoClass;

public class Serialisation {
	PojoClass emp1;

	@BeforeTest
	public void createUser() {
		emp1 = new PojoClass();
		emp1.setName("morpheus");
		emp1.setJob("leader");
	}

	@Test
	public void getUser() throws JsonProcessingException {
		RestAssured.baseURI = Url.getUrl();

		ObjectMapper obj = new ObjectMapper();
		String employeeJson = obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(employeeJson);

		String response = given().header("Content-Type", "application/json").body(employeeJson).when().post(Url.post())
				.then().extract().response().asString();
		JsonPath jsd = ResuseMethod.rawToJson(response);

		String firstName = jsd.getString("name");
		System.out.print("pojo  Name " + firstName);
		assertEquals(firstName, "morpheus");
	}
}
/*
 * Gson gson = new Gson(); PojoClass pc = new PojoClass(); pc.setName("Shyam");
 * pc.setJob("unique"); String response =
 * given().body(gson.toJson(pc)).when().post(Url.post()).then().log().all().
 * extract().response() .asString(); JsonPath js =
 * ResuseMethod.rawToJson(response);
 * 
 * String fname = js.getString("name"); System.out.print("  Name " + fname);
 */