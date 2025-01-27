package ge.automation.apiTest;

import org.example.restAssured.RestAssuredUtils;
import org.testng.Assert;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void testGetStatusCode() {
        // ენდფოინთი GET request-ისთვის
        String endpoint = "/users?page=2";

        // გავაგზავნოთ GET request და მივიღოთ პასუხი
        Response response = RestAssuredUtils.sendGetRequest(endpoint);

        // მივიღოთ status code მიღებული პასუხიდან
        int statusCode = response.getStatusCode();

        // შევამოწმოთ არის თუ არა მიღებული status code 200 (OK)
        Assert.assertEquals(statusCode, 200, "მოსალოდნელი status code უნდა იყოს 200");
    }
}
