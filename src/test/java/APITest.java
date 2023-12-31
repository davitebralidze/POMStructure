import com.github.dockerjava.transport.DockerHttpClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITest {

    String BASE_URI = "https://reqres.in";
    String getEndPoint = "/api/users?page=2";

    @Test
    public void apiTest() {

        Response restAssured = RestAssured.get(BASE_URI + getEndPoint);
        System.out.println(restAssured.getBody().asString());

    }


}
