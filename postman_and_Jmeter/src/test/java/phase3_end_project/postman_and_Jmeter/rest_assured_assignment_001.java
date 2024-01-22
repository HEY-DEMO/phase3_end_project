package phase3_end_project.postman_and_Jmeter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class rest_assured_assignment_001 {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet";


    @Test
    public void testPostCall() {
        // JSON Body for POST request
        String requestBody = "{\r\n" +
                "\"id\": 344,\r\n" +
                "\"category\": {\r\n" +
                " \"id\": 0,\r\n" +
                " \"name\": \"string\"\r\n" +
                "},\n" +
                "\"name\": \"Doggie\",\r\n" +
                "\"photoUrls\": [\r\n" +
                " \"string\"\r\n" +
                "],\r\n" +
                "\"tags\": [\r\n" +
                " {\r\n" +
                " \"id\": 0,\r\n" +
                " \"name\": \"string\"\r\n" +
                " }\r\n" +
                "],\r\n" +
                "\"status\": \"available\"\r\n" +
                "}";

        // POST request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(BASE_URL);

        // Validate response code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Validate PetID
        int petId = response.jsonPath().getInt("id");
        Assert.assertEquals(petId, 344);
        petId = response.jsonPath().getInt("id");
    }

    @Test(dependsOnMethods = "testPostCall")
    public void testGetCall() {
        // GET request
        Response response = RestAssured.given().get(BASE_URL + "/344");

        // Validate response code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Validate response JSON body
        Assert.assertTrue(response.getBody().asString().contains("status"));
        Assert.assertTrue(response.getBody().asString().contains("id"));

        // Validate status value
        String statusValue = response.jsonPath().getString("status");
        Assert.assertEquals(statusValue, "available");
    }

    @Test(dependsOnMethods = "testGetCall")
    public void testDeleteCall() {
        // DELETE request using the stored PetID
        Response response = RestAssured.given().delete(BASE_URL + "/344");
        System.out.println("Response Body: " + response.getBody().asString());
        // Validate response code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Validate response JSON body
        Assert.assertTrue(response.getBody().asString().contains("code"));
        Assert.assertTrue(response.getBody().asString().contains("message"));

        // Validate message value is PetID
        String messageValue = response.jsonPath().getString("message");
        Assert.assertEquals(messageValue, String.valueOf(344));
        

    }
}
