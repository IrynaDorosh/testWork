package testSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\Prog\\testWork\\testWork\\libs\\chromedriver.exe");
    }

    WebDriver driver = new ChromeDriver();
    private List<String> failedScreenshots = new ArrayList<>();


    public WebDriver getDriver() {
        return driver;
    }

    public List<String> getFailedScreenshots() {
        return failedScreenshots;
    }
}
