package com.library.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import static com.library.utility.LibraryAPI_Util.*;
import static org.hamcrest.Matchers.*;

public class US02_StepDef{


    @Given("Path param is {string}")
    public void path_param_is(String pathParam) {
        requestSpec = requestSpec.pathParam("id", pathParam);

    }

    @Then("{string} field should be same with path param")
    public void field_should_be_same_with_path_param(String field) {
     response.then().body(field, notNullValue());
    }

    @Then("following fields should not be null")
    public void following_fields_should_not_be_null(List<String> fields) {

        for (String eachField : fields) {
            response.then().body(eachField,notNullValue());
        }

        fields.forEach(eachField -> response.then().body(eachField,notNullValue()));
    }


}
