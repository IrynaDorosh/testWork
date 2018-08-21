package util;

import com.plusSmilebox.pages.LogInWithEmailPage;
import com.plusSmilebox.pages.StartPage;
import com.plusSmilebox.util.Constants;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\AutoProjects\\AutoSmile\\testWork\\libs\\chromedriver.exe");
    }

    protected WebDriver driver = new ChromeDriver();
    private List<String> failedScreenshots = new ArrayList<>();
    private WebDriverWait wait10 = new WebDriverWait(driver, 10);
    private StartPage startPage = new StartPage(driver);
    private LogInWithEmailPage logInWithEmailPage = new LogInWithEmailPage(driver);



    public WebDriver getDriver() {
        return driver;
    }

    public List<String> getFailedScreenshots() {
        return failedScreenshots;
    }

    protected void logInWithEmailFromStartPage() {
        driver.get(Constants.LINK_START_PAGE);
         wait10.withMessage("linkLogInWithExistedAccount is not visible")
                .until(ExpectedConditions.visibilityOf(startPage.linkLogInWithExistedAccount));
        startPage.linkLogInWithExistedAccount.click();
            wait10.withMessage("Login Page is not displayed")
                .until(ExpectedConditions.titleContains("Login"));
        logInWithEmailPage.logInWithEmail();
            wait10.withMessage("Smilebox Dashboard page is not displayed")
                .until(ExpectedConditions.titleContains("Smilebox Dashboard"));
    }

    protected void waitForPageTitleToDIsplayed (String title, String errorMessage ) {
        try {
            wait10.until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException e) {
            System.out.println(errorMessage);
        }
    }

    protected void waitForElementIsDisplayed (WebElement element, String errorMessage ){
        try{
            wait10.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println(errorMessage);
        }
    }

    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isEnabled();
            return true;
        } catch (
                NoSuchElementException e) {
            return false;
        }
    }




}


