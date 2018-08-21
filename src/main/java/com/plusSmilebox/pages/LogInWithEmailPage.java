package com.plusSmilebox.pages;

import com.plusSmilebox.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//https://plus.smilebox.com/Account/Login

public class LogInWithEmailPage {

    private WebDriver driver;
    WebDriverWait wait8;

    public LogInWithEmailPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait8 = new WebDriverWait(driver, 8);
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
        wait8.withMessage("inputFieldEmail is not present")
                .until(ExpectedConditions.visibilityOf(inputFieldEmail));
        inputFieldEmail.sendKeys(Constants.EMAIL_FOR_REGISTRATION_VIA_FB);
        inputFieldPassword.sendKeys(Constants.PASSWORD_CURRENT_USER);
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();", buttonSubmit);
        buttonSubmit.click();
    }


}
