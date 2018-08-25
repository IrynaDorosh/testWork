package util;

import com.plusSmilebox.pages.initialPages.LogInWithEmailPage;
import com.plusSmilebox.pages.initialPages.StartPage;
import com.plusSmilebox.util.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
    protected WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    public abstract Logger getLogger();

    protected void initialStepRedirectsToDashboardPage(){
        driver.get(Constants.LINK_MAIN_PAGE);
        String title = driver.getTitle();
        if("Welcome".equals(title)) {
            waitForElementIsVisible(startPage.linkLogInWithExistedAccount, 10).click();
            waitForTitleRefreshed("Login", 10);
            logInWithEmailPage.logInWithEmail();
            waitForTitleRefreshed("Smilebox Dashboard", 10);
            }
        if("Login".equals(title)){
            logInWithEmailPage.logInWithEmail();
            waitForTitleRefreshed("Smilebox Dashboard", 10);
        }
        if (!title.equals("Smilebox Dashboard")) {
            getLogger().error("Cannot get to Dashboard page. Current page title after refreshing is " + title);
        }
        }


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


    protected WebElement waitForElementIsVisible(WebElement element, int timeToWait) { // the same in BaseTest
        wait = new WebDriverWait(driver, timeToWait);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            getLogger().error("WebElement " + element +" is not visible");
        }
        return element;
    }

    protected void waitForTitleRefreshed (String title, int timeToWait) { // the same in BaseTest
        wait = new WebDriverWait(driver, timeToWait);
        try {
            wait.until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException e) {
            getLogger().error("Title " + title +" is not found");
        }
    }



    public static boolean isElementDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }
}


