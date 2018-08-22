package util;

import com.plusSmilebox.pages.LogInWithEmailPage;
import com.plusSmilebox.pages.StartPage;
import com.plusSmilebox.util.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\AutoProjects\\AutoSmile\\testWork\\libs\\chromedriver.exe");
    }

    protected WebDriver driver = new ChromeDriver();
    protected WebDriverWait wait15 = new WebDriverWait(driver, 15);
    private StartPage startPage = new StartPage(driver);
    private LogInWithEmailPage logInWithEmailPage = new LogInWithEmailPage(driver);

    public WebDriver getDriver() {
        return driver;
    }

    public abstract Logger getLogger();

    protected void logInWithEmailFromStartPage() {
        driver.get(Constants.LINK_START_PAGE);
        wait15.withMessage("linkLogInWithExistedAccount is not visible")
                .until(ExpectedConditions.visibilityOf(startPage.linkLogInWithExistedAccount));
        startPage.linkLogInWithExistedAccount.click();
        wait15.withMessage("Login Page is not displayed")
                .until(ExpectedConditions.titleContains("Login"));
        logInWithEmailPage.logInWithEmail();
        wait15.withMessage("Smilebox Dashboard page is not displayed")
                .until(ExpectedConditions.titleContains("Smilebox Dashboard"));
    }

    protected void waitForPageTitleToDisplayed(String title, String errorMessage) {
        try {
            wait15.until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException e) {
            System.out.println(errorMessage);
        }
    }

    protected void waitForElementIsDisplayed(WebElement element, String errorMessage) {
        try {
            wait15.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println(errorMessage);
        }
    }

    public static boolean isElementDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }
}


