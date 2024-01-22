package phase3_end_project.postman_and_Jmeter;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class rest_assured_assignment_004 {

    // Define the base URL
    private static final String BASE_URL = "https://petstore.swagger.io/v2/user/login";

    @Test
    public void testLoginApi() {
        // Set base URI
        RestAssured.baseURI = BASE_URL;

        // Create Basic Authentication credentials
        BasicAuthScheme basicAuthScheme = new BasicAuthScheme();
        basicAuthScheme.setUserName("Uname001");
        basicAuthScheme.setPassword("@tt!tude");

        // Hit the GET call and capture the response
        Response response = given()
                .auth().basic(basicAuthScheme.getUserName(), basicAuthScheme.getPassword())
                .contentType(ContentType.JSON)
                .get();

        // Assertions using Hamcrest
        response.then()
                .statusCode(200) // Validate HTTP status code
                .body("message", Matchers.containsString("logged in user session")); // Validate response message

        // You can add more assertions based on the response content if needed
    }
}
