package com.plusSmilebox.pages;

import com.plusSmilebox.util.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.invoke.ConstantCallSite;

public class LogInWithEmailPage {

    private WebDriver driver;
    public LogInWithEmailPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='Email']")
    public WebElement inputFieldEmail;

    @FindBy(xpath="//input[@id='Password']")
    public WebElement inputFieldPassword;

    @FindBy(xpath="//button[@id='btnSubmit']")
    public WebElement buttonSubmit;





    /**
     * METHODS
     */

    public void logInWithEmail(){
        driver.manage().deleteAllCookies();
        inputFieldEmail.sendKeys(Constants.EMAIL_FOR_REGISTRATION_VIA_FB);
        inputFieldPassword.sendKeys(Constants.PASSWORD_FOR_REGISTRATION_VIA_FB);
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();", buttonSubmit);
        buttonSubmit.click();
    }


}
