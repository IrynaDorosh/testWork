package testSuite;

import com.plusSmilebox.pages.FBloginPage;
import com.plusSmilebox.pages.LogInWithEmailPage;
import com.plusSmilebox.pages.StartPage;
import com.plusSmilebox.pages.DashboardPage;
import com.plusSmilebox.util.Constants;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(ListenerSmile.class)
public class FirstTestSet extends BaseTest {

    private StartPage startPage;
    private FBloginPage fBloginPage;
    private DashboardPage dashboardPage;
    private LogInWithEmailPage logInWithEmailPage;

    @BeforeClass
    public void beforeClass() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        startPage = new StartPage(driver);
        fBloginPage = new FBloginPage(driver);
        logInWithEmailPage = new LogInWithEmailPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(priority = 1)
    public void loginViaFacebook() throws InterruptedException, IOException {
        driver.get(Constants.LINK_START_PAGE);
        startPage.buttonLoginWithFB.click();
        fBloginPage.logInWithFBcredentials();
        Assert.assertEquals("Smilebox Dashboard", driver.getTitle());
        dashboardPage.logOutViaProvileDropdownOnDashboarPage();
    }

    @Test(priority = 2)
    public void logInWithEmail() throws InterruptedException {
        driver.get(Constants.LINK_START_PAGE);
        startPage.linkLogIn.click();
        logInWithEmailPage.logInWithEmail();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Smilebox Dashboard");
    }

    @Test(priority = 3)
    public void checkTemplatesChristmas() throws InterruptedException {
        driver.get(Constants.LINK_MAIN_PAGE);
        dashboardPage.selectChristmasTemplatesFromDropdownInBarHeader();
        Assert.assertEquals(dashboardPage.subtitleNameAfterFiltering.getText(), "Christmas");
        Thread.sleep(2000);
    }



    @Test(priority = 3)
    public void checkAllCategoriesServices() throws InterruptedException {
        logInEmail();
        driver.manage().window().maximize();
        dashboardPage.buttonCloseFromMarketingWrapper.click();
        Thread.sleep(1000);
        dashboardPage.selectServicesTemplatesFromDropDownInFilters();
        Thread.sleep(2000);


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private void logInEmail() throws InterruptedException {
        driver.get(Constants.LINK_START_PAGE);
        startPage.linkLogIn.click();
        logInWithEmailPage.logInWithEmail();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Smilebox Dashboard");
    }
}





