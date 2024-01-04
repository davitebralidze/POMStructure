import com.github.dockerjava.transport.DockerHttpClient;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static util.PropertyLoader.returnConfigValue;

public class APITest {

    public static void main(String[] args) {

        String BASE_URI = "https://evalplatform-qa-api.azurewebsites.net";
        String ENDPOINT = "/api/assessment/GetAll?Page.PageSize=10&Page.PageNumber=1&IsDeleted=false&";
        String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiI3MTU0ZTk5Mi1iZmMzLTQ2YjUtOTkyNS00ZTE4YjUxZmVlMDMiLCJ1bmlxdWVfbmFtZSI6ImRhdml0LmVicmFsaWR6ZUBmbGF0cm9ja3RlY2guY29tIiwiZW1haWwiOiJkYXZpdC5lYnJhbGlkemVAZmxhdHJvY2t0ZWNoLmNvbSIsInJvbGUiOiJUZW5hbnRBZG1pbiIsIkNvbXBhbmllcyI6IltcIjE1YjNhYjYxLWQ1YmQtNGE2OC1iMGI3LTJkM2ZlMGJiNWJkMVwiLFwiYWUzYmYzOGYtOTExYy00M2QxLTlhZGQtNDY5ZmYxOGY1YmQ4XCIsXCIyN2UxODk4NC1mYzYzLTQ0YmItYWFiYS00OThlYTQ4YzNmMGJcIixcIjlkYjkyYTMwLTlmM2UtNGY2Ni05MWU1LWJlNWI2ZWE2ZTdkMFwiXSIsIlVuaXRzIjoiW1wiMjA4NmUxMDYtZDlkZS00Zjg2LWQzZWQtMDhkYmY0YTExNTNlXCIsXCIyOGFmMjFiOC0wZGJhLTRhMzUtZDNlZS0wOGRiZjRhMTE1M2VcIixcIjc3ZWU1YWEzLTc2OTMtNDczNS1jYWRlLTA4ZGJmN2I4NTYwNlwiLFwiMWZlOGVjYTAtNzdiNC00N2VlLTU4NTEtMDhkYzBjMzA2NzZmXCJdIiwidGVuYW50SWQiOiJlMDVmMDNlMS1lM2Q5LTRmNTYtYmZiZi04ZWQzNWRkZmEzYzQiLCJLbm93bGVkZ2UgYmFzZSI6IkFsbG93QWRkQW5kRWRpdCIsIlF1ZXN0aW9uIGNhdGVnb3JpZXMiOiJBbGxvd0FkZEFuZEVkaXQiLCJVbml0IjoiQWxsb3dBZGRBbmRFZGl0IiwiQ29tcGFueSI6IkFsbG93QWRkQW5kRWRpdCIsIlF1aXp6ZXMiOiJBbGxvd0FkZEFuZEVkaXQiLCJUYWxlbnRzIjoiQWxsb3dBZGRBbmRFZGl0IiwiQXNzZXNzbWVudHMiOiJBbGxvd0FkZEFuZEVkaXQiLCJQb3NpdGlvbnMiOiJBbGxvd0FkZEFuZEVkaXQiLCJVc2VyIG1hbmFnZW1lbnQiOiJBbGxvd0FkZEFuZEVkaXQiLCJGQVEiOiJBbGxvd0FkZEFuZEVkaXQiLCJDaGFuZ2UgbG9ncyI6IkFsbG93QWRkQW5kRWRpdCIsIkF1dG8gR2VuZXJhdGUgUXVlc3Rpb24ocykiOiJBbGxvd0FkZEFuZEVkaXQiLCJDYW4gdmVyaWZ5IGFsbCBxdWVzdGlvbnMiOiJBbGxvd0FkZEFuZEVkaXQiLCJTa2lsbHMiOiJBbGxvd0FkZEFuZEVkaXQiLCJDYW4gYWNjZXNzIHNvbWUgY29tcGFuaWVzIjoiIiwiQ2FuIGFjY2VzcyBzb21lIHVuaXRzIjoiIiwibmJmIjoxNzA0MzcyMTE3LCJleHAiOjE3MDQzNzMwMTUsImlhdCI6MTcwNDM3MjExNywiaXNzIjoiaHR0cHM6Ly9ldmFscGxhdGZvcm0tcWEtYXBpLmF6dXJld2Vic2l0ZXMubmV0LyIsImF1ZCI6IkZSVCBFdmFsdWF0aW9uIFRvb2wifQ.8cfgwHMUUSHurgfBh-0kFjfaDi049H9dwhGJL64lK-I";

        Response restAssured = RestAssured.given().header("Authorization", "Bearer " + accessToken).get(BASE_URI + ENDPOINT);

        int statusCode = restAssured.getStatusCode();

        String id = restAssured.jsonPath().get("items[0].id");

        System.out.println("The body of the response: " + restAssured.getBody().asString());
        System.out.println("Status code: " + statusCode);
        System.out.println("The id of the assessment is: " + id);






    }

}
