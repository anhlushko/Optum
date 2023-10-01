package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"Sign-in-77484\"]/i")
    public WebElement signIn;

    @FindBy(xpath = "//div[@class='o4-utility__sub js-utility-dd']//span[.='Individuals and families']")
    public WebElement IndividualsAndFamiliesBtn;

    @FindBy(xpath = "//a[@aria-label='Register Optum Store']")
    public WebElement optumStoreRegisterBtn;
}
