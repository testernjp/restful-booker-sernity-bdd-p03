package com.restful.booker.userinfo;

import com.restful.booker.constant.EndPoints;
import com.restful.booker.model.AuthPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class AuthSteps {

    @Step("Creating token with username : {0}, password : {1}")
    public ValidatableResponse createToken(String username, String password) {
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername(username);
        authPojo.setPassword(password);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(authPojo)
                .post(EndPoints.AUTHENTICATE)
                .then().log().all().statusCode(200);

    }
}