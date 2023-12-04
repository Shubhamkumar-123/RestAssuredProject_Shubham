package pojobody;

public class Body {
	public static String payLoad() {
		String RequestBody = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}";
		return RequestBody;
	}

//Dynamic Data handle 
	public static String dynamicPayLoad(String name, String job) {
		String RequestBody = "{\r\n" + "    \"name\": \"" + name + "\",\r\n" + "    \"job\": \"" + job + "\"\r\n" + "}";
		return RequestBody;
	}
}