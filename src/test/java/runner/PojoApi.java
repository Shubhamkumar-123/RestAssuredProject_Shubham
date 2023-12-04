package runner;

import static io.restassured.RestAssured.given;

import commonPkg.ResuseMethod;
import commonPkg.Url;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojobody.Body;
import pojobody.PojoClass;
import com.google.gson.Gson;

public class PojoApi {

	

	public static void main(String[] args) {
		PojoClass pc = new PojoClass();
		pc.setName("Shyam");
		pc.setJob("unique");
		String name = pc.getName();
		String job = pc.getJob();
		/*
		 * String response =
		 * given().body(pc).when().post(Url.post()).then().log().all().extract().
		 * response().asString(); JsonPath js = ResuseMethod.rawToJson(response);
		 * 
		 * String fname = js.getString("name");
		 */
		System.out.print("  Name " + name);
		System.out.print("  Name " + job);
	}

}
