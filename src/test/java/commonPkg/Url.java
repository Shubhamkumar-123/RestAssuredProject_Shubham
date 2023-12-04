package commonPkg;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Url {
	public static String getUrl() {
		String url = "https://reqres.in/";
		return url;
	}

	public static String post() {
		String postUrl = "/api/users";
		return postUrl;
	}

	public static String get() {
		String fetchUrl = "/api/users?page=2";
		return fetchUrl;
	}

	public static RequestSpecification RequestSpec() {
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://reqres.in/")
				.setContentType(ContentType.JSON).build();
		return req;
	}

	
}
