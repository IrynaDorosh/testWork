package testSuite;
import com.plusSmilebox.pages.FBloginPage;
import com.plusSmilebox.pages.LogInWithEmailPage;
import com.plusSmilebox.pages.StartPage;
import com.plusSmilebox.pages.DashboardPage;
import com.plusSmilebox.util.Constants;
import com.plusSmilebox.util.Helpers;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private WebDriverWait wait8;
    private Helpers helpers;

    @BeforeClass
    public void beforeClass() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        startPage = new StartPage(driver);
        fBloginPage = new FBloginPage(driver);
        logInWithEmailPage = new LogInWithEmailPage(driver);
        dashboardPage = new DashboardPage(driver);
        wait8 = new WebDriverWait(driver,8);
        helpers = new Helpers(driver);
    }

    @Test(priority = 1)
    public void testUserCanLogInViaFacebookButton() {
        driver.get(Constants.LINK_START_PAGE);
        startPage.buttonLoginWithFB.click();
        fBloginPage.logInWithFBcredentials();
        Assert.assertEquals("Smilebox Dashboard", driver.getTitle());
        dashboardPage.logOutViaProvileDropdownOnDashboarPage();
    }

    @Test(priority = 2)
    public void testUserCanLogInViaLogInWithEmailButton () {
        driver.get(Constants.LINK_START_PAGE);
        startPage.linkLogIn.click();
        logInWithEmailPage.logInWithEmail();
        Assert.assertEquals(driver.getTitle(), "Smilebox Dashboard");
    }

    @Test(priority = 3)
    public void testUserCanSelectTemplatesFromHeaderContainer_FirstAndLast () throws InterruptedException {
        this.logInWithEmailFromStartPage(); //remove later
        driver.get(Constants.LINK_MAIN_PAGE);  //to refresh Dashboard
        Assert.assertFalse(helpers.isElementPresent(dashboardPage.subtitleNameAfterFiltering));
        dashboardPage.clickOnTemplatesDropdownInBarHeader();
        dashboardPage.selectChristmasTemplatesFromDropdown();
        Assert.assertEquals(dashboardPage.subtitleNameAfterFiltering.getText(), "Christmas");
        dashboardPage.clickOnTemplatesDropdownInBarHeader();
        dashboardPage.selectOtherBusinessTemplatesFromDropdown();
        Assert.assertEquals(dashboardPage.subtitleNameAfterFiltering.getText(), "Other Business");
    }
    
@Ignore
    @Test(priority = 3)
    public void checkThatFilterWorksInAllCategories() throws InterruptedException {
        this.logInWithEmailFromStartPage(); //TODO move to helpers
        driver.manage().window().maximize();
        dashboardPage.buttonCloseFromMarketingWrapper.click();
        dashboardPage.selectACategoryFromDropDownInFilters();
        Thread.sleep(2000);


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private void logInWithEmailFromStartPage() throws InterruptedException {
        driver.get(Constants.LINK_START_PAGE);
        System.out.println("driver.get(Constants.LINK_START_PAGE)");
        startPage.linkLogIn.click();
        System.out.println("startPage.linkLogIn.click();");
        logInWithEmailPage.logInWithEmail();
        System.out.println("logInWithEmailPage.logInWithEmail();");
        wait8.until(ExpectedConditions.titleContains("Smilebox Dashboard"));
    }
}





