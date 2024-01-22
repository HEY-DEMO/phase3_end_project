package phase3_end_project.postman_and_Jmeter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class rest_assured_assignment_003 {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/user/Uname001";

    @Test
    public void getUserInfo() {
        // Perform the GET request
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL);

        // Assertions
        response.then()
                .statusCode(200)
                .body("username", equalTo("Uname001"))
                .body("email", equalTo("Positive@Attitude.com"))
                .body("userStatus", equalTo(1));
    }
}