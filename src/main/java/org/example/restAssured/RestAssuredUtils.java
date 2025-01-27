package org.example.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestAssuredUtils {

    private static final String BASE_URI = "https://reqres.in/api";

    static {
        RestAssured.baseURI = BASE_URI;
    }

    // მეთოდი GET request-ისთვის
    public static Response sendGetRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

}
