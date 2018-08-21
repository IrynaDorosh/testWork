package testSuites;
import com.plusSmilebox.pages.*;
import com.plusSmilebox.util.Constants;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @BeforeClass
    public void beforeClass() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        startPage = new StartPage(driver);
        fBloginPage = new FBloginPage(driver);
        logInWithEmailPage = new LogInWithEmailPage(driver);
        dashboardPage = new DashboardPage(driver);
        wait10 = new WebDriverWait(driver, 10);
        editorPage = new EditorPage(driver);
        myCreationsPage= new MyCreationsPage(driver);
    }

    @Test(priority = 1)
    public void testUserCanLogInViaFacebookButton() {
        driver.get(Constants.LINK_START_PAGE);
        startPage.clickButtonLoginWithFB();
            wait10.withMessage("Facebook page is not displayed")
                    .until(ExpectedConditions.titleContains("Facebook"));
        fBloginPage.logInWithFBcredentials();
        wait10.withMessage("Smilebox Dashboard page is not displayed")
                .until(ExpectedConditions.titleContains("Smilebox Dashboard"));
        Assert.assertEquals("Smilebox Dashboard", driver.getTitle());
        dashboardPage.logOutViaProvileDropdownOnDashboarPage();
    }

    @Test(priority = 2)
    public void testUserCanLogInViaLogInWithEmailButton () {
        driver.get(Constants.LINK_START_PAGE);
        startPage.clicklinkLogInWithExistedAccount();
        wait10.withMessage("Login page is not displayed")
                .until(ExpectedConditions.titleContains("Login"));
        logInWithEmailPage.logInWithEmail();
        wait10.withMessage("Smilebox Dashboard page is not displayed")
                .until(ExpectedConditions.titleContains("Smilebox Dashboard"));
        Assert.assertEquals(driver.getTitle(), "Smilebox Dashboard");
    }

    @Test(priority = 3)
    public void testUserCanSelectTemplatesFromHeaderContainer_FirstAndLast ()  {
        //super.logInWithEmailFromStartPage(); //remove later
        driver.get(Constants.LINK_MAIN_PAGE);  //to refresh Dashboard
        driver.manage().window().maximize();
            waitForPageTitleToDIsplayed("Smilebox Dashboard", "Smilebox Dashboard page is not displayed");
        Assert.assertFalse(isElementPresent(dashboardPage.subtitleNameAfterFiltering)); //to ensure that no templates are selected
        dashboardPage.clickOnTemplatesDropdownInBarHeader();
        dashboardPage.selectChristmasTemplatesFromDropdown();
        Assert.assertEquals(dashboardPage.subtitleNameAfterFiltering.getText(), "Christmas");
        dashboardPage.clickOnTemplatesDropdownInBarHeader();
        dashboardPage.selectOtherBusinessTemplatesFromDropdown();
        Assert.assertEquals(dashboardPage.subtitleNameAfterFiltering.getText(), "Other Business");
    }

    @Test(priority = 4)
    public void testCheckThatCreationListDisplayedAfterClickingOnMyCreationsTab () throws InterruptedException {
        super.logInWithEmailFromStartPage(); //remove later
        dashboardPage.tabMyCreationsInBarheader.click();
            waitForPageTitleToDIsplayed("My Creations", "My Creations title is not displayed");
        Assert.assertTrue(isElementPresent(myCreationsPage.containerForCreations), "Element containerForCreations not present");
            Assert.assertEquals(myCreationsPage.containerForCreations.getText(), "What are you waiting for? Create an awesome slideshow now!"); //verify that empty
        Assert.assertFalse(isElementPresent(myCreationsPage.creationList));
        dashboardPage.logoSmilebox.click();
            waitForPageTitleToDIsplayed("Smilebox Dashboard", "Smilebox Dashboard page is not displayed");
        dashboardPage.templateExampleJoimUsFloral.click();
            waitForElementIsDisplayed(dashboardPage.buttonPersonalise,"Personalise button is not displayed");
        dashboardPage.buttonPersonalise.click();
            waitForPageTitleToDIsplayed("Smilebox Dashboard", "Smilebox Dashboard page is not displayed");
        editorPage.fillInFieldsInFloralTemplate();
        editorPage.savingModifiedTemplate();
            waitForElementIsDisplayed(editorPage.buttonPreviewAndShare, "Not redirected to Editor page after Save +Save");
        driver.get(Constants.LINK_MY_CREATIONS_PAGE);
        Assert.assertTrue(isElementPresent(myCreationsPage.creationList));
        //implement functionality delete edited template
        Thread.sleep(2000);
    }
    @Ignore
    @Test(priority = 5)
    public void testShouldFail() {
        driver.get(Constants.LINK_START_PAGE);
        Assert.assertEquals(driver.getTitle(), "SSSmile","Title SSSmile is not displayed");

    }

    @Ignore
    @Test
    public void checkThatFilterWorksInAllCategories() throws InterruptedException {
        //super.logInWithEmailFromStartPage();

        dashboardPage.buttonCloseFromMarketingWrapper.click();
        dashboardPage.selectACategoryFromDropDownInFilters();
        Thread.sleep(2000);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

