package commonPkg;

import io.restassured.path.json.JsonPath;

public class ResuseMethod {

	public static JsonPath rawToJson(String responseBody) {
		JsonPath js = new JsonPath(responseBody);
		return js;
	}
}
