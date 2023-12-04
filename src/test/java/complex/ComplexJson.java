package complex;

import io.restassured.path.json.JsonPath;

public class ComplexJson {
	public static void main(String[] args) {

		JsonPath js = new JsonPath(Payload.addPlace());
		// Array
		int count = js.getInt("data.size()");
		System.out.println("print count " + count);
		// print support
		String url = js.getString("support.url");
		System.out.println("print url " + url);
		String text = js.getString("support.text");
		System.out.println("print text " + text);

		// print first element in the array

		String email = js.getString("data[0].email");
		System.out.println("print email " + email);

		// print all email element in the array

		for (int i = 0; i < count; i++) {
			int id = js.get("data[" + i + "].id");
			System.out.println("print all id " + id);

			String allEmail = js.getString("data[" + i + "].email");
			System.out.println("print all email " + allEmail);
		}
		// dynamic Array
		for (int i = 0; i < count; i++) {

			String first_name = js.getString("data[" + i + "].first_name");
			System.out.println("print all email " + first_name);
			if (first_name.equalsIgnoreCase("Michael")) {
				String avatar = js.get("data[0].avatar");
				System.out.println("dynamic avtar " + avatar);
				break;
			}
		}

	}
}
