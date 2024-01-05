import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITestJSON {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";
        String ENDPOINT = "/api/users?page=2";
        Response response = RestAssured.get(ENDPOINT);

        String email = response.jsonPath().get("data[2].email");
        System.out.println(email);

    }

}
