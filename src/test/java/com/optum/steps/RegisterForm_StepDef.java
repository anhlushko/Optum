package com.optum.steps;

import com.github.javafaker.Faker;
import com.optum.pages.MainPage;
import com.optum.pages.OptumStoreRegisterPage;
import com.optum.utility.ConfigurationReader;
import com.optum.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterForm_StepDef {

    MainPage mainPage = new MainPage();

    OptumStoreRegisterPage storeRegisterPage = new OptumStoreRegisterPage();

    Faker faker = new Faker();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));

    @Given("user is on optum page")
    public void user_is_on_optum_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("optum_url"));
    }

    @When("user click on Sign in")
    public void user_click_on_sign_in() {

    mainPage.signIn.click();

    }

    @When("user click on Individuals and families")
    public void user_click_on_individuals_and_families() {

//wait.until(ExpectedConditions.visibilityOf(mainPage.IndividualsAndFamiliesBtn));

      mainPage.IndividualsAndFamiliesBtn.click();
    }

    @Then("click register under Optum Store")
    public void click_register_under_optum_store() {
        mainPage.optumStoreRegisterBtn.click();
    }

    @When("enter first name")
    public void enter_first_name() {
        storeRegisterPage.firstNameBox.sendKeys("A!@#$%");
    }

    @When("enter last name")
    public void enter_last_name() {
        storeRegisterPage.lastNameBox.sendKeys("H!@#$%");
    }

    @When("enter valid email")
    public void enter_valid_email() {
        storeRegisterPage.emailBox.sendKeys(faker.internet().emailAddress());
    }

    @Then("create a valid password")
    public void create_a_valid_password() {
        storeRegisterPage.emailBox.sendKeys("Ha11111!");
    }

    @Then("click on radio button I agree to Optum Store's Terms of Service and Privacy Policy")
    public void click_on_radio_button_i_agree_to_optum_store_s_terms_of_service_and_privacy_policy() {
        wait.until(ExpectedConditions.elementToBeClickable(storeRegisterPage.TermsOfUseAndPrivacyPolicyBox));
        storeRegisterPage.TermsOfUseAndPrivacyPolicyBox.click();
    }

    @Then("user click on Continue button")
    public void user_click_on_continue_button() {
        storeRegisterPage.continueBtn.click();
    }

    @And("enter valid phone number")
    public void enterValidPhoneNumber() {
        storeRegisterPage.phoneNumberBox.sendKeys("2679128070");
    }
}
