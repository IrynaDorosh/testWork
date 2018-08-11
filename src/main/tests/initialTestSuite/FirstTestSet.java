package initialTestSuite;

import com.plusSmilebox.pages.FBloginPage;
import com.plusSmilebox.pages.LogInWithEmailPage;
import com.plusSmilebox.pages.StartPage;
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

    private StartPage startPage;
    private FBloginPage fBloginPage;
    private MainPage mainPage;
    private LogInWithEmailPage logInWithEmailPage;

    @BeforeClass
    public void beforeClass() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        startPage = new StartPage(driver);
        fBloginPage= new FBloginPage(driver);
        logInWithEmailPage = new LogInWithEmailPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test(priority = 1)
    public void loginViaFacebook() throws InterruptedException, IOException {
        driver.get(Constants.LINK_START_PAGE);
        startPage.buttonLoginWithFB.click();
        fBloginPage.logInWithFBcredentials();
        Assert.assertEquals("Smilebox Dashboard", driver.getTitle());
    }

    @Test(priority = 1)
    public void logInWithEmail() throws InterruptedException {
        driver.get(Constants.LINK_START_PAGE);
        startPage.linkEmail.click();
        logInWithEmailPage.logInWithEmail();
         Thread.sleep(2000);
        Assert.assertEquals( driver.getTitle(), "Smilebox Dashboard");
    }



    @Test(priority = 2)
    public void loginViaFacebook2() throws InterruptedException, IOException {
        driver.get(Constants.LINK_START_PAGE);
        startPage.buttonLoginWithFB.click();
        fBloginPage.logInWithFBcredentials();
        Assert.assertEquals(driver.getTitle(),"Smilebox Dashboard");
    }

    @Test(priority = 3)
    public void checkTemplatesChristmas() throws InterruptedException {
        driver.get(Constants.LINK_MAIN_PAGE);
        mainPage.selectChristmasTemplatesFromDropdown();
        Assert.assertEquals( mainPage.SubtitleNameAfterFiltering.getText(), "Christmas");
        Thread.sleep(2000);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

