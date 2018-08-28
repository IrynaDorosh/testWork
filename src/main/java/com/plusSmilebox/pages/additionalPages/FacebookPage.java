package com.plusSmilebox.pages.additionalPages;

import com.plusSmilebox.util.BasePage;
import com.plusSmilebox.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FacebookPage extends BasePage {
    public FacebookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@id='email']")
    public WebElement inputEmail;

    @FindBy(xpath="//input[@id='pass']")
    public WebElement inputPassword;

    @FindBy(xpath="//input[@data-testid='royal_login_button']")
    public WebElement buttonEnter;

    @FindBy(xpath="//div[@data-click='profile_icon']/a")
    public WebElement iconProfile;

    public void logInToFB(){
        driver.get("https://www.facebook.com/");
        this.inputEmail.sendKeys(Constants.FB_EMAIL);
        this.inputPassword.sendKeys(Constants.FB_PASS);
        this.buttonEnter.click();
        waitForElementIsVisible(this.iconProfile, 10).click();
    }

}