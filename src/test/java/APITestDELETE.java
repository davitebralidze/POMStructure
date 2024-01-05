import io.restassured.RestAssured;
import io.restassured.response.Response;
public class APITestDELETE {
    public static void main(String[] args) {

        String ENDPOINT = "/api/users/2";
        RestAssured.baseURI = "https://reqres.in";
        Response response = RestAssured.delete(ENDPOINT);

        System.out.println(response.getStatusCode());

    }

}
