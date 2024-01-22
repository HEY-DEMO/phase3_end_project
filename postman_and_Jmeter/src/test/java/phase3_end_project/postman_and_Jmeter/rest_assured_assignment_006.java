package phase3_end_project.postman_and_Jmeter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class rest_assured_assignment_006 {

    @Test
    public void testLogoutApi() {
        // Define the base URL
        String baseUrl = "https://petstore.swagger.io/v2/user/logout";

        // Perform the GET request
        Response response = RestAssured.get(baseUrl);

        // Validate response status code
        assertThat(response.statusCode(), equalTo(200));

        // Validate 'code' field in the response
        assertThat(response.path("code"), equalTo(200));

        // Validate 'message' field in the response
        assertThat(response.path("message"), equalTo("ok"));
    }
}
