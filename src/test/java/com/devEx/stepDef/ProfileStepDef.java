package com.devEx.stepDef;

import com.devEx.request.DevExRequest;
import com.devEx.utulities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ProfileStepDef {

    Response response;

    @Given("User creates a GET request and able to see all profiles")
    public void user_creates_a_get_request_and_able_to_see_all_profiles() {
         response = given().accept(ContentType.JSON)
                .when()
                .get(ConfigurationReader.get("allProfiles"));
        response.prettyPrint();

    }
    @Then("Verify that status code is {int}")
    public void verify_that_status_code_is(int expectedStatusCode) {
        assertEquals(expectedStatusCode,response.statusCode());
    }
    //*** d1s2 - 2   create DevExRequest under request package
    @Given("User creates a GET request and able to see all profiles second way")
    public void userCreatesAGETRequestAndAbleToSeeAllProfilesSecondWay() {
        //***d1s2 - 5 -> comes from DevExRequest
        response= DevExRequest.getAllProfiles();
    }
    //***d1s3 - 6
    @Given("User creates a GET request with path {string}")
    public void userCreatesAGETRequestWithPath(String id) {
        //***d1s3 - 8 after this take from to devExRequest class for method getOneUserWithPathParam(id)

//        response = given().accept(ContentType.JSON)
//                .pathParam("userID", id)
//                // .when().get("/api/profile/user/{userID}");
//                .when().get(ConfigurationReader.get("getOneUserWithPathParam"));

        //***d1s3 - 10
        response = DevExRequest.getOneUserWithPathParam(id);

    }
    //***d1s3 - 7
    @Then("Verify that user info's {string} and {string} and {string} and {string}")
    public void verifyThatUserInfoSAndAndAnd(String name, String email, String company, String location) {
        //***d1s3 - 11 used Gpath syntax
        System.out.println("response.path(\"user.name\") = " + response.path("user.name"));
        System.out.println("response.path(\"user.email\") = " + response.path("user.email"));
        System.out.println("response.path(\"user.company\") = " + response.path("company"));
        System.out.println("response.path(\"location\") = " + response.path("location"));
        //***d1s3 - 12
        assertEquals(name,response.path("user.name"));
        assertEquals(email,response.path("user.email"));
        assertEquals(company,response.path("company"));
        assertEquals(location,response.path("location"));
    }
    //***d1s3 - 13 after create singUp.feature for step4
}
