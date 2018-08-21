package com.plusSmilebox.pages;

import com.plusSmilebox.util.Constants;
import com.plusSmilebox.util.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FBloginPage {

    private WebDriver driver;
    WebDriverWait wait10;

    public FBloginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait10 = new WebDriverWait(driver, 10);
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
        wait10.withMessage("inputFieldEmailOrPhone is not present")
                .until(ExpectedConditions.visibilityOf(inputFieldEmailOrPhone));
        inputFieldEmailOrPhone.sendKeys(Constants.EMAIL_FOR_REGISTRATION_VIA_FB);
        inputFieldPassword.sendKeys(Constants.PASSWORD_FOR_REGISTRATION_VIA_FB);
        buttonLogIn.click();
    }




}
