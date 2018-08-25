package com.plusSmilebox.pages.initialPages;

import com.plusSmilebox.util.BasePage;
import com.plusSmilebox.util.Constants;
import com.plusSmilebox.util.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FBloginPage extends BasePage {

    public FBloginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//div[@id='email_container']/input")
    public WebElement inputFieldEmailOrPhone;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement inputFieldPassword;

    @FindBy(xpath = "//button[@id='loginbutton']")
    public WebElement buttonLogIn;

    /**
     * METHODS
     */
    public void logInWithFBcredentials(){
        waitForElementIsVisible(inputFieldEmailOrPhone, 10)
                .sendKeys(Constants.EMAIL_FOR_REGISTRATION_VIA_FB);
        inputFieldPassword.sendKeys(Constants.PASSWORD_FOR_REGISTRATION_VIA_FB);
        buttonLogIn.click();
    }




}
