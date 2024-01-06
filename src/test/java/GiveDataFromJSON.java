import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.Utils;

public class GiveDataFromJSON {

    public static void main(String[] args) {

        String json = Utils.getFormattedJsonString("src/main/java/testdata/TestData.json");

        System.out.println(json);

        Response response = RestAssured.given().contentType(ContentType.JSON).body(json).post("https://api.techwave.ge/api/Account/SignIn");

        System.out.println(response.getStatusCode());

        String token = response.jsonPath().getString("token");

        System.out.println(token);

    }

}




