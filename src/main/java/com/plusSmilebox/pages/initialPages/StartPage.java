package com.plusSmilebox.pages.initialPages;

import com.plusSmilebox.util.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// https://plus.smilebox.com/Account/Welcome

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='Facebook']/span")
    public WebElement buttonLoginWithFB;

    @FindBy(xpath = "//a[text()= 'Log in!']")
    public WebElement linkLogInWithExistedAccount;

    @FindBy(xpath = "//a[text()= 'email']")
    public WebElement linkSignUpWithEmail;




    /**
     * METHODS
     */

    public void clickButtonLoginWithFB() {
        waitForElementIsVisible(buttonLoginWithFB, 10).click();
    }

    public void clickLinkLogInWithExistedAccount() {
        waitForElementIsVisible(linkLogInWithExistedAccount, 10).click();
    }

}


