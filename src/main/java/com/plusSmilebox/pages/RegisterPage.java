package com.plusSmilebox.pages;

import com.plusSmilebox.util.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@id='FullName']")
    public WebElement nameForRegistrationInput;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailForRegistrationInput;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordForRegistrationInput;

    @FindBy(xpath="//button[@id='btnSubmit']/span")
    public WebElement buttonSignIn;



}
