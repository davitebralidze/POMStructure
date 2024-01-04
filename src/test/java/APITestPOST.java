import Model.TestDataPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.Utils;

public class APITestPOST {

    public static void main(String[] args) {

        String requestBody =
                "{\n" +
                        "    \"Email\": \"0713georgia@gmail.com\",\n" +
                        "    \"Password\": \"Gagoshidze1!\",\n" +
                        "    \"RememberMe\": false\n" +
                        "}";

//        TestDataPojo accessCredentials = Utils.readJsonFile("src/main/java/testdata/TestData.json", TestDataPojo.class);
//
//        TestDataPojo testData = TestDataPojo.builder()
//                .Email(accessCredentials.getEmail())
//                .Password(accessCredentials.getPassword())
//                .RememberMe(accessCredentials.isRememberMe())
//                .build();

        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("https://api.techwave.ge/api/Account/SignIn");

        System.out.println(response.getStatusCode());

        System.out.println(response.jsonPath().getString("token"));

    }

}
