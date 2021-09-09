package com.finance.api;

import com.finance.pojo.api.BuyBody;
import com.finance.pojo.api.BuyResponseBody;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class BuyEndpoint extends BaseEndpoint {

    public BuyEndpoint(String baseUrl, String token) {
        super(baseUrl, token);
    }

    public void buyStock(String symbol, int qty) {
        given()
                .header("x-access-token", super.getToken())
                .body(new BuyBody(symbol, qty))
                .contentType(ContentType.JSON)
                .baseUri("http://localhost:5000")
                .when()
                .post("/api/buy")
                .peek()
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .contentType(ContentType.JSON)
                .body("message", notNullValue());
    }
}
