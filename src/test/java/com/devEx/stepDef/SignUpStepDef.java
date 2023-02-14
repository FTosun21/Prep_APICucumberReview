package com.devEx.stepDef;

import com.devEx.common.DataForApi;
import com.devEx.request.DevExRequest;
import com.devEx.utulities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignUpStepDef {

    Response response;

    //***d1s4 - 15
    @Given("User creates a POST request with {string} and {string} and {string} and {string} and {string} and {string}")
    public void user_creates_a_post_request_with_and_and_and_and_and(String email, String password, String name, String google, String facebook, String github) {
        //***d1s4 - 18 after this take from to devExRequest class for method registerNewUser()

//        response = given().accept(ContentType.JSON)
//                .and()
//                .contentType(ContentType.JSON)
//                .and()
//                .body(DataForApi.registerUserBody(email, password, name, google, facebook, github))
//                .when()
//                .post(ConfigurationReader.get("postRegisterUser"));

        response= DevExRequest.registerNewUser(email, password, name, google, facebook, github);
        response.prettyPrint();
    }

    //***d1s4 - 16 after create DataForApi under common package
    @Then("Verify that body contains {string}")
    public void verify_that_body_contains(String token) {

        //***d1s4 - 20 after go to singUp.feature and create new step for status code  and

        // explain way because response is in the profileStepDef, and it is different response
        assertTrue(response.body().asString().contains(token));
    }

    //***d1s4 - 22
    @Then("Verify that status code should be {int}")
    public void verifyThatStatusCodeShouldBe(int expectedStatusCode) {
        //***d1s4 - 23
        assertEquals(expectedStatusCode,response.statusCode());
    }
}
