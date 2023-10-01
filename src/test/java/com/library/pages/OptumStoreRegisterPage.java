package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OptumStoreRegisterPage {

    public OptumStoreRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='user-first-name']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='user-last-name']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@id='user-phonenumber']")
    public WebElement phoneNumberBox;

    @FindBy(xpath = "//input[@id='user-email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='user-password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//div/label/input[@name='termsOfService']")
    public WebElement TermsOfUseAndPrivacyPolicyBox;

    @FindBy(xpath = "//button[.='Continue']")
    public WebElement continueBtn;
}
