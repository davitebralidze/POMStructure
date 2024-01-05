import Model.TestDataPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Utils;

import java.util.Objects;

public class APITestPOST {

    public static void main(String[] args) {

        String requestBody =
                "{\n" +
                        "    \"Email\" : \"0713georgia@gmail.com\",\n" +
                        "    \"Password\" : \"Gagoshidze1!\",\n" +
                        "    \"RememberMe\" : false\n" +
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

        String token = response.jsonPath().getString("token");

        System.out.println(token);

        System.out.println(requestBody);

    }

}
