package com.plusSmilebox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// https://plus.smilebox.com/Account/Welcome

public class StartPage {

    private WebDriver driver;
    WebDriverWait wait10;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait10 = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//button[@id='Facebook']/span")
    public WebElement buttonLoginWithFB;

    @FindBy(xpath = "//a[text()= 'Log in!']")
    public WebElement linkLogInWithExistedAccount;

    @FindBy(xpath = "//a[text()= 'email']")
    public WebElement linkSignUpWithEmail;

    public void clickButtonLoginWithFB() {
        wait10.withMessage("clickButtonLoginWithFB is not visible")
                .until(ExpectedConditions.visibilityOf(buttonLoginWithFB));
        buttonLoginWithFB.click();
    }

    public void clicklinkLogInWithExistedAccount() {
        wait10.withMessage("linkLogInWithExistedAccount is not visible")
                .until(ExpectedConditions.visibilityOf(linkLogInWithExistedAccount));
        linkLogInWithExistedAccount.click();
    }


    /**
     * METHODS
     */

}


