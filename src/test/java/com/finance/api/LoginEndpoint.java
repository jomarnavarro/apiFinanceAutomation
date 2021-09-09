package com.finance.api;

import com.finance.pojo.api.AuthInfo;
import com.finance.pojo.api.Credentials;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class LoginEndpoint extends BaseEndpoint {

    public LoginEndpoint(String baseUrl) {
        super(baseUrl, null);
    }

    public void login(String user, String password) {
        AuthInfo authInfo =
                given()
                        .baseUri(super.getBaseUrl())
                        .contentType(ContentType.JSON)
                        .body(new Credentials(user, password))
                        .when()
                        .post("/api/login")
                        .peek()
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(AuthInfo.class);

        super.setToken(authInfo.getToken());
    }
}
