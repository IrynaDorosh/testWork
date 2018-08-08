package com.plusSmilebox.pages;

import com.plusSmilebox.libs.Constants;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBloginPage {

    private WebDriver driver;

    public FBloginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
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
        inputFieldEmailOrPhone.sendKeys(Constants.EMAIL_FOR_REGISTRATION_VIA_FB);
        inputFieldPassword.sendKeys(Constants.PASSWORD_FOR_REGISTRATION_VIA_FB);
        buttonLogIn.click();
    }




}
