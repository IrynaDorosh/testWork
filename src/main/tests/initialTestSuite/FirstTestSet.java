package initialTestSuite;

import com.plusSmilebox.libs.Helpers;
import com.plusSmilebox.libs.Constants;
import com.plusSmilebox.pages.FBloginPage;
import com.plusSmilebox.pages.LoginPage;
import com.plusSmilebox.pages.MainPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//@Listeners(ListenerSmile.class)

public class FirstTestSet {

    public WebDriver getDriver() {
        return driver;
    }

    private  WebDriver driver;
    private LoginPage loginPage;
    private FBloginPage fBloginPage;
    private MainPage mainPage;
    private Helpers helpers;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\SmileProject\\src\\main\\java\\com\\plusSmilebox\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        fBloginPage= new FBloginPage(driver);
        mainPage = new MainPage(driver);
        helpers = new Helpers(driver);
    }

    @Test
    public void a_loginViaFb() throws InterruptedException, IOException {
        driver.get(Constants.LINK_LOGIN_PAGE);
        loginPage.buttonLoginWithFB.click();
        fBloginPage.logInWithFBcredentials();
        Assert.assertEquals("Smilebox Dashboard", driver.getTitle());
    }

    @Test
    public void checkTemplatesChristmas() throws InterruptedException {
        driver.get(Constants.LINK_MAIN_PAGE);
        mainPage.selectChristmasTemplatesFromDropdown();
        Assert.assertEquals("Christmas", mainPage.SubtitleNameAfterFiltering.getText());
        Thread.sleep(2000);

    }

    @AfterClass
    public void afterClass(){
        driver.close();

    }


}

