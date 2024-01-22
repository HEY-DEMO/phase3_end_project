package phase3_end_project.postman_and_Jmeter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class rest_assured_assignment_002 {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet";
    private static final HashMap<String, String> ENVIRONMENT_VALUES = new HashMap<>();

    static {
        ENVIRONMENT_VALUES.put("DEV", "available_DEV");
        ENVIRONMENT_VALUES.put("QA", "available_QA");
        ENVIRONMENT_VALUES.put("PROD", "available_PROD");
    }

    @Parameters("environment")
    @Test
    public void putCallTesting(String environment) {
        // Read the status value based on the environment
        String statusValue = ENVIRONMENT_VALUES.get(environment);

        // PUT Call request JSON body
        String requestBody = "{"
                + "\"id\": 20021, "
                + "\"category\": {\"id\": 20021, \"name\": \"string\"}, "
                + "\"name\": \"doggie\", "
                + "\"photoUrls\": [\"string\"], "
                + "\"tags\": [{\"id\": 0, \"name\": \"string\"}], "
                + "\"status\": \"" + statusValue + "\""
                + "}";

        // Perform the PUT request
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(BASE_URL);

        // Assertions
        response.then()
                .statusCode(200)
                .body("id", equalTo(20021))
                .body("status", equalTo(statusValue));
    }
}
