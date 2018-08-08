package initialTestSuite;

import com.plusSmilebox.pages.FBloginPage;
import com.plusSmilebox.pages.LoginPage;
import com.plusSmilebox.pages.MainPage;
import com.plusSmilebox.util.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(ListenerSmile.class)
public class FirstTestSet extends BaseTest {

    private LoginPage loginPage;
    private FBloginPage fBloginPage;
    private MainPage mainPage;

    @BeforeClass
    public void beforeClass() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        fBloginPage= new FBloginPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test(priority = 1)
    public void loginViaFacebook() throws InterruptedException, IOException {
        driver.get(Constants.LINK_LOGIN_PAGE);
        loginPage.buttonLoginWithFB.click();
        fBloginPage.logInWithFBcredentials();
        Assert.assertEquals("Smilebox Dashboard8", driver.getTitle());
    }

    @Test(priority = 2)
    public void loginViaFacebook2() throws InterruptedException, IOException {
        driver.get(Constants.LINK_LOGIN_PAGE);
        loginPage.buttonLoginWithFB.click();
        fBloginPage.logInWithFBcredentials();
        Assert.assertEquals("Smilebox Dashboard899", driver.getTitle());
    }

    @Test(priority = 3)
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

