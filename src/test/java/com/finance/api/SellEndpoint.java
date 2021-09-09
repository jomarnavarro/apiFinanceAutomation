package com.finance.api;

import com.finance.pojo.api.SellBody;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;

public class SellEndpoint extends BaseEndpoint {

    public SellEndpoint(String baseUrl, String token) {
        super(baseUrl, token);
    }

    public void sellStock(String symbol, int qty) {
        given()
                .header("x-access-token",super.getToken())
                .contentType(ContentType.JSON)
                .body(new SellBody(symbol, qty))
                .baseUri(super.getBaseUrl())
                .when()
                .post("/api/sell")
                .peek()
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .contentType(ContentType.JSON)
                .body("message", notNullValue())
                .body("message", containsString(symbol))
                .body("message",containsString(qty + ""));
    }
}
