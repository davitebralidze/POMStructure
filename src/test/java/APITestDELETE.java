import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class APITestDELETE {
    public static void main(String[] args) {


        String ENDPOINT = "/api/users/2";
        RestAssured.baseURI = "https://reqres.in";
        Response response = RestAssured.get(ENDPOINT);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());

        int id = response.jsonPath().get("data.id");

        System.out.println(id);

    }

}
