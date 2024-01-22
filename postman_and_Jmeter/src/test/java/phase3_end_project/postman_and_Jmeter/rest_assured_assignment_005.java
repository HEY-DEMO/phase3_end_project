package phase3_end_project.postman_and_Jmeter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class rest_assured_assignment_005 {

    // Define the base URL
    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet/findByStatus";

    @Test
    public void testPetStatusAvailable() {
        // Set base URI
        RestAssured.baseURI = BASE_URL;

        // Hit the GET call with status = available
        Response response = given()
                .param("status", "available")
                .contentType(ContentType.JSON)
                .get();

        // Assertions using Hamcrest
        response.then()
                .statusCode(200) // Validate HTTP status code
                .body("status", Matchers.everyItem(Matchers.equalTo("available"))); // Validate all pet details have status = available
    }

    @Test
    public void testPetStatusPending() {
        // Set base URI
        RestAssured.baseURI = BASE_URL;

        // Hit the GET call with status = pending
        Response response = given()
                .param("status", "pending")
                .contentType(ContentType.JSON)
                .get();

        // Assertions using Hamcrest
        response.then()
                .statusCode(200) // Validate HTTP status code
                .body("status", Matchers.everyItem(Matchers.equalTo("pending"))); // Validate all pet details have status = pending
    }

    @Test
    public void testPetStatusSold() {
        // Set base URI
        RestAssured.baseURI = BASE_URL;

        // Hit the GET call with status = sold
        Response response = given()
                .param("status", "sold")
                .contentType(ContentType.JSON)
                .get();

        // Assertions using Hamcrest
        response.then()
                .statusCode(200) // Validate HTTP status code
                .body("status", Matchers.everyItem(Matchers.equalTo("sold"))); // Validate all pet details have status = sold
    }
}
