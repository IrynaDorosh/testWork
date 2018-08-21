package com.plusSmilebox.pages;

import com.plusSmilebox.util.Helpers;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.plusSmilebox.util.Helpers.waitForElementToBePresent;
// https://plus.smilebox.com/Account/Welcome

public class StartPage {

    private WebDriver driver;
    WebDriverWait wait8;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait8 = new WebDriverWait(driver, 8);
    }

    @FindBy(xpath = "//button[@id='Facebook']/span")
    public WebElement buttonLoginWithFB;

    @FindBy(xpath = "//a[text()= 'Log in!']")
    public WebElement linkLogInWithExistedAccount;

    @FindBy(xpath = "//a[text()= 'email']")
    public WebElement linkSignUpWithEmail;

    public void clickButtonLoginWithFB() {
        wait8.withMessage("clickButtonLoginWithFB is not visible")
                .until(ExpectedConditions.visibilityOf(buttonLoginWithFB));
        buttonLoginWithFB.click();
    }


    /**
     * METHODS
     */

}


