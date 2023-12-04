package testng;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonPkg.ResuseMethod;
import commonPkg.Url;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojobody.Body;

public class TestDataDriven {

	@Test(dataProvider = "testdata")
	public void bodyDataDyanamic(String fname, String fjob) {
		RestAssured.baseURI = Url.getUrl();
		String responseDynamicPostBody = given().header("Content-Type", "application/json")
				.body(Body.dynamicPayLoad(fname, fjob)).when().post(Url.post()).then().extract().response().asString();

		JsonPath jsd = ResuseMethod.rawToJson(responseDynamicPostBody);
		String firstName = jsd.getString("name");
		String firstjob = jsd.getString("job");
		System.out.print("testdataAll  job " + firstjob);
		System.out.print("testdataAll  Name " + firstName);

		assertEquals(firstName, "shyam");
		assertEquals(firstjob, "politics");

	}

	@DataProvider(name = "testdata")
	public Object[][] getData() {
		return new Object[][] { { "shyam", "politics" }, { "krishna", "gwala" } };
	}

}
