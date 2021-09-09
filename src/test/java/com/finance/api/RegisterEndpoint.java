package com.finance.api;

import com.finance.pojo.api.Credentials;
import com.finance.pojo.api.RegisterResponseBody;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterEndpoint extends BaseEndpoint {
    public RegisterEndpoint(String baseUrl, String token) {
        super(baseUrl, token);
    }

    public Credentials registerNewUser() {
        String randomUserName = "RandoUser" + new Random().nextInt(10000000);
        String randomPassword = "test" + new Random().nextInt(10000);
        RegisterResponseBody rrb = given()
                .header("x-access-token",super.getToken())
                .contentType(ContentType.JSON)
                .body(new Credentials(randomUserName, randomPassword))
                .baseUri(getBaseUrl())
                .when()
                .post("/api/register")
                .peek()
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .contentType(ContentType.JSON)
                .body("message", notNullValue())
                .extract()
                .as(RegisterResponseBody.class);
        return new Credentials(randomUserName, randomPassword);
    }
}
