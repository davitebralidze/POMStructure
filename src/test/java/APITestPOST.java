import Util.PropertyLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITestPOST {

    @Test(groups = "smoke")
    public void testAPI() {
        PropertyLoader propertyLoader = new PropertyLoader("qa");
//        String requestBody =
//                "{\n" +
//                        "    \"Email\" : \"0713georgia@gmail.com\",\n" +
//                        "    \"Password\" : \"Gagoshidze1!\",\n" +
//                        "    \"RememberMe\" : false\n" +
//                        "}";

        String requestBodyWithTextBlock =
                """
                {
                    "Email" : "testforautomation@gm.cm",
                    "Password" : "asdASD123!@#",
                    "RememberMe" : false
                }""";


        System.out.println(propertyLoader.returnConfigValue("credentialsWithJson"));
//        System.out.println(requestBodyWithTextBlock);

        Response response = RestAssured.given().contentType(ContentType.JSON).body(propertyLoader.returnConfigValue("credentialsWithJson")).post("https://softwarege-qa.azurewebsites.net/api/Account/SignIn");

        System.out.println(response.getStatusCode());

        String token = response.jsonPath().getString("token");

        System.out.println(token);

        System.out.println(requestBodyWithTextBlock);


    }

}
