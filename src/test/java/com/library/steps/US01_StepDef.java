package com.library.steps;

import com.library.utility.ConfigurationReader;
import com.library.utility.LibraryAPI_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class US01_StepDef {

    public String token;

    public RequestSpecification requestSpec;

    public Response response;

    @Given("I logged Library api as a {string}")
    public void i_logged_library_api_as_a(String userType) {
        token = LibraryAPI_Util.tokenByRole(userType);
        LibraryAPI_Util.token = token;
    }

    @Given("Accept header is {string}")
    public void accept_header_is(String acceptContentType) {

        requestSpec = given()
                .accept(acceptContentType)
                .header("x-library-token", LibraryAPI_Util.token)
                .baseUri(ConfigurationReader.getProperty("library.baseUri"));
        LibraryAPI_Util.requestSpec = requestSpec;

    }

    @When("I send GET request to {string} endpoint")
    public void i_send_get_request_to_endpoint(String endPoint) {
        response = requestSpec.when().get(endPoint);
        LibraryAPI_Util.response = response;
    }

    @Then("status code should be {int}")
    public void status_code_should_be(int expectedStatusCode) {
        LibraryAPI_Util.response.then().statusCode(expectedStatusCode);
        // System.out.println(response.statusCode());
    }

    @Then("Response Content type is {string}")
    public void response_content_type_is(String expectedResponseContentType) {

        assertEquals(expectedResponseContentType,LibraryAPI_Util.response.contentType());
        //  System.out.println(response.contentType());

    }

    @Then("{string} field should not be null")
    public void field_should_not_be_null(String field) {

        LibraryAPI_Util.response.then().body(field, notNullValue());
        // System.out.println("response.jsonPath().getList(field) = " + response.jsonPath().getList(field));
    }
}
