package testSuites;
import com.plusSmilebox.pages.*;
import com.plusSmilebox.pages.initialPages.FBloginPage;
import com.plusSmilebox.pages.initialPages.LogInWithEmailPage;
import com.plusSmilebox.pages.initialPages.RegisterPage;
import com.plusSmilebox.pages.initialPages.StartPage;
import com.plusSmilebox.util.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import util.BaseTest;
import util.ListenerSmile;

import java.util.concurrent.TimeUnit;

@Listeners(ListenerSmile.class)
public class SmileTestSuite extends BaseTest {

    private StartPage startPage;
    private FBloginPage fBloginPage;
    private DashboardPage dashboardPage;
    private LogInWithEmailPage logInWithEmailPage;
    private WebDriverWait wait10;
    private EditorPage editorPage;
    private MyCreationsPage myCreationsPage;
    private final static Logger logger = Logger.getLogger(SmileTestSuite.class);
    private RegisterPage registerPage;

    @Override
    public Logger getLogger() {
        return logger;
    }

    @BeforeClass
    public void beforeClass() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        startPage = new StartPage(driver);
        fBloginPage = new FBloginPage(driver);
        logInWithEmailPage = new LogInWithEmailPage(driver);
        dashboardPage = new DashboardPage(driver);
        wait10 = new WebDriverWait(driver, 10);
        editorPage = new EditorPage(driver);
        myCreationsPage= new MyCreationsPage(driver);
        registerPage = new RegisterPage(driver);

    }

    @Test(priority = 1)
    public void testUserCanLogInViaFacebookButton() {
        driver.get(Constants.LINK_START_PAGE);
        startPage.clickButtonLoginWithFB();
        waitForTitleRefreshed("Facebook", 20);
        fBloginPage.logInWithFBcredentials();
        waitForTitleRefreshed("Smilebox Dashboard", 20);
        Assert.assertEquals("Smilebox Dashboard", driver.getTitle());
        dashboardPage.logOutViaProvileDropdownOnDashboarPage();
        Assert.assertNotEquals(driver.getTitle(), "Smilebox Dashboard");
    }

    @Test(priority = 2)
    public void testUserCanLogInViaLogInWithEmailButton () {
        driver.get(Constants.LINK_START_PAGE);
        startPage.clickLinkLogInWithExistedAccount();
        logInWithEmailPage.logInWithEmail();
        waitForTitleRefreshed("Smilebox Dashboard", 20);
        Assert.assertEquals(driver.getTitle(), "Smilebox Dashboard");
    }

    @Test(priority = 3)
    public void testUserCanSelectTemplatesFromHeaderContainer_FirstAndLast() {
        initialStepRedirectsToDashboardPage();
   //        Assert.assertFalse(isElementDisplayed(dashboardPage.subtitleNameAfterFiltering)); //to ensure that no templates are selected
        dashboardPage.clickOnTemplatesDropdownInBarHeader();
        dashboardPage.selectChristmasTemplatesFromDropdown();
        Assert.assertEquals(dashboardPage.subtitleNameAfterFiltering.getText(), "Christmas");
        dashboardPage.clickOnTemplatesDropdownInBarHeader();
        dashboardPage.selectOtherBusinessTemplatesFromDropdown();
        Assert.assertEquals(dashboardPage.subtitleNameAfterFiltering.getText(), "Other Business");
    }

    @Test(priority = 4)
    public void testCheckThatCreationListDisplayedAfterClickingOnMyCreationsTab() throws InterruptedException {
        initialStepRedirectsToDashboardPage();
        dashboardPage.templateExampleJoimUsFloral.click();
        waitForElementIsVisible(dashboardPage.buttonPersonalise, 30).click();
        editorPage.fillInFieldsInFloralTemplate();
        editorPage.savingModifiedTemplate();
        driver.get(Constants.LINK_MY_CREATIONS_PAGE);
        Assert.assertTrue(isElementDisplayed(myCreationsPage.creationList));// check assert
        //implement functionality delete edited template
    }

    @Test(priority = 5)
    public void testShouldFail() {
        driver.get(Constants.LINK_LOGIN_WITH_EMAIL_PAGE);
        try {
            waitForElementIsVisible(logInWithEmailPage.inputFieldEmail, 10).sendKeys("Invalid email");
        } catch (Exception e) {
            waitForElementIsVisible(startPage.linkLogInWithExistedAccount, 10).click();
            waitForElementIsVisible(logInWithEmailPage.inputFieldEmail, 10).sendKeys("Invalid email");
        }
        logInWithEmailPage.buttonSubmit.click();
        Assert.assertEquals(driver.getTitle(), "Smilebox dashboard");
    }

    @Test (priority = 5)
    public void shareSditedTemplateOnFacebook() throws InterruptedException {
        initialStepRedirectsToDashboardPage();
        dashboardPage.tabMyCreationsInBarheader.click();
        System.out.println("000");
        waitForTitleRefreshed("My Creations", 10);
        System.out.println("111");
        Thread.sleep(3000);
        WebElement templateReadyToShare = dashboardPage.findTemplateWiThInnerText("Ready to Share");
        System.out.println("222");
        Thread.sleep(3000);
        templateReadyToShare.click();

            Thread.sleep(3000);




    }

    @Ignore
    @Test
    public void testTest() throws InterruptedException {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

