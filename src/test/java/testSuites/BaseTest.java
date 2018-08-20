package testSuites;

import com.plusSmilebox.pages.LogInWithEmailPage;
import com.plusSmilebox.pages.StartPage;
import com.plusSmilebox.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\AutoProjects\\AutoSmile\\testWork\\libs\\chromedriver.exe");
    }

    WebDriver driver = new ChromeDriver();
    private List<String> failedScreenshots = new ArrayList<>();
    private WebDriverWait wait8 = new WebDriverWait(driver, 8);;
    private StartPage startPage = new StartPage(driver);
    private LogInWithEmailPage logInWithEmailPage = new LogInWithEmailPage(driver);



    public WebDriver getDriver() {
        return driver;
    }

    public List<String> getFailedScreenshots() {
        return failedScreenshots;
    }

    public void logInWithEmailFromStartPage() {
        driver.get(Constants.LINK_START_PAGE);
        startPage.linkLogInWithExistedAccount.click();
        logInWithEmailPage.logInWithEmail();
        wait8.until(ExpectedConditions.titleContains("Smilebox Dashboard"));
    }

}
