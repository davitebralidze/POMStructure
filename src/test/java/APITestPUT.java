import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APITestPUT {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";
        String ENDPOINT = "/api/users/2";

        String bodyJSON =
                "{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}";

        Response response = RestAssured.given().contentType(ContentType.JSON).body(bodyJSON).put(ENDPOINT);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());

    }
}
