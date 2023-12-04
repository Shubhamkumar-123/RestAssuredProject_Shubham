package commonPkg;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojobody.Body;
import pojobody.PojoClass;

public class RequestSpecBuilderCalss {

	PojoClass emp1;

	@BeforeTest
	public void createUser() {
		emp1 = new PojoClass();
		emp1.setName("morpheus");
		emp1.setJob("leader");
	}

	@Test
	public void getUser() throws JsonProcessingException {

		ObjectMapper obj = new ObjectMapper();
		String employeeJson = obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println("employee json " + employeeJson);

//		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://reqres.in/")
//				.setContentType(ContentType.JSON).build();

		RequestSpecification res = given().spec(Url.RequestSpec()).body(employeeJson);
		Response response = res.when().post(Url.post()).then().extract().response();

		String responseString = response.asString();
		System.out.println(responseString);
		JsonPath jsd = ResuseMethod.rawToJson(responseString);

		String firstName = jsd.getString("name");
		System.out.print("Requestspecbuilder  Name " + firstName);
		// assertEquals(firstName, "morpheus");
	}

}
