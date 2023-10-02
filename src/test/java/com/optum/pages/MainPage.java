package com.optum.pages;

import com.optum.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//button[contains(@id,'Sign-in')]")
    public WebElement signIn;


    @FindBy(xpath = "//a[@class='o4-utility__sublink']/span[.='Individuals and families']")
    public WebElement IndividualsAndFamiliesBtn;



    @FindBy(xpath = "//a[@aria-label='Register Optum Store']")
    public WebElement optumStoreRegisterBtn;
}

