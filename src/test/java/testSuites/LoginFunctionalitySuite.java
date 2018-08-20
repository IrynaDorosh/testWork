package testSuites;
import com.plusSmilebox.pages.*;
import com.plusSmilebox.util.Constants;
import com.plusSmilebox.util.Helpers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import util.ListenerSmile;

import java.util.concurrent.TimeUnit;

@Listeners(ListenerSmile.class)
public class LoginFunctionalitySuite extends BaseTest {

    private StartPage startPage;
    private FBloginPage fBloginPage;
    private DashboardPage dashboardPage;
    private LogInWithEmailPage logInWithEmailPage;
    private WebDriverWait wait8;
    private EditorPage editorPage;

    @BeforeClass
    public void beforeClass() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        startPage = new StartPage(driver);
        fBloginPage = new FBloginPage(driver);
        logInWithEmailPage = new LogInWithEmailPage(driver);
        dashboardPage = new DashboardPage(driver);
        wait8 = new WebDriverWait(driver,8);
        editorPage  = new EditorPage(driver);
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
        startPage.linkSignUpWithEmail.click();
        logInWithEmailPage.logInWithEmail();
        Assert.assertEquals(driver.getTitle(), "Smilebox Dashboard");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}





