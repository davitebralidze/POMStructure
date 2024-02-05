import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APITestPOST {

    public static void main(String[] args) {

        String requestBody =
                "{\n" +
                        "    \"Email\" : \"0713georgia@gmail.com\",\n" +
                        "    \"Password\" : \"Gagoshidze1!\",\n" +
                        "    \"RememberMe\" : false\n" +
                        "}";

        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("https://softwarege-qa.azurewebsites.net/api/Account/SignIn");

        System.out.println(response.getStatusCode());

        String token = response.jsonPath().getString("token");

        System.out.println(token);

        System.out.println(requestBody);

    }

}
