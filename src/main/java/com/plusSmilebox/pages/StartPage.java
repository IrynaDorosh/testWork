package com.plusSmilebox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    private WebDriver driver;
    public StartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[@id='Facebook']/span")
    public WebElement buttonLoginWithFB;

    @FindBy(xpath="//a[text()= 'Log in!']")
    public WebElement linkLogIn;

    @FindBy(xpath="//a[text()= 'email']")
    public WebElement linkEmail;



    /**
     * METHODS
     */

}
