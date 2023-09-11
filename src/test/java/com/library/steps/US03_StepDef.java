package com.library.steps;


import com.library.utility.LibraryAPI_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;


import java.util.Map;

import static com.library.utility.LibraryAPI_Util.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class US03_StepDef {


    Map<String, Object> randomBook;

    @Given("Request Content Type header is {string}")
    public void request_content_type_header_is(String requestContentType) {
        requestSpec = requestSpec.contentType(requestContentType);

    }

    @Given("I create a random {string} as request body")
    public void i_create_a_random_as_request_body(String string) {
        randomBook = getRandomBookMap();
        requestSpec = requestSpec.formParams(randomBook);
    }

    @Given("I logged in Library UI as {string}")

    public void i_logged_in_library_ui_as(String string) {

    }

    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String string) {

    }

    @When("I send POST request to {string} endpoint")
    public void i_send_post_request_to_endpoint(String endPoint) {
        response = given().spec(requestSpec).post(endPoint).prettyPeek();

    }

    @Then("the field value for {string} path should be equal to {string}")
    public void the_field_value_for_path_should_be_equal_to(String fieldMsg, String expectedMsg) {

        assertEquals(expectedMsg, LibraryAPI_Util.response.path("message").toString());
    }

    @Then("UI, Database and API created book information must match")
    public void ui_database_and_api_created_book_information_must_match() {

    }


}
