package com.devEx.request;

import com.devEx.common.DataForApi;
import com.devEx.utulities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DevExRequest {
    //***d1s2 - 4  after go to profileStepDef to call method getAllProfiles
    static Response response;

    //***d1s2 -  3
    public static Response getAllProfiles(){

        response = given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.get("allProfiles"));
        response.prettyPrint();
        return response;
    }
    //***d1s3 - 9 after go to profileStepDef to call
    public static Response getOneUserWithPathParam(String id){
        response = given().accept(ContentType.JSON).and()
                .pathParam("userID", id)
                .when().get(ConfigurationReader.get("getOneUserWithPathParam"));
        return response;
    }

    //***d1s4 - 19 after go to SingUpStepDef
    public static Response registerNewUser(String email, String password, String name, String google, String facebook, String github){
        response=    given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(DataForApi.registerUserBody(email, password, name, google, facebook, github))
                .when()
                .post(ConfigurationReader.get("postRegisterUser"));

        return response;
    }

}
