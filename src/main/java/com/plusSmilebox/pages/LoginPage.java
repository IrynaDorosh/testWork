package com.plusSmilebox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[@id='Facebook']/span")
    public WebElement buttonLoginWithFB;

    /**
     * METHODS
     */
//    public void clickFacebookButton()  {
//        buttonLoginWithFB.click();
//
//    }
}
